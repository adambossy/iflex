from django.shortcuts import render_to_response
from django.http import HttpResponseRedirect
from django.http import HttpResponse
from django.core import serializers
from django.utils import simplejson
from django.forms import ModelForm
from django.template.loader import get_template
from django.template import Context

from iflex.members.models import *
from iflex.exercises.models import *
from iflex.template_editor.models import *

import pprint
ppr = pprint.PrettyPrinter(indent=4).pprint

SERVICES = (
            'service_load_exercise_templates',
            'service_load_workout_templates',
            'service_load_lift_templates',
            )

# TODO: Change the output mechanisms of these views to whatever is most "appropriate"
# (not necessarily always render_to_response)
def index (request, member_id):
    # use proper httpresponse
    return render_to_response('template_editor/builder.html', { 'member_id': member_id })

def view_load(request):
    return HttpResponse(load(request))
    
# Terribly inefficient for simplicity's sake
def load(request):   #, workout_template_id):
    workout_template_id = int(request.GET['workout_template_id']) if 'workout_template_id' in request.GET else None
    
    workout_template = WorkoutTemplate.objects.get(id=workout_template_id)
    dict = [workout_template]
    exercise_template_list = ExerciseTemplate.objects.order_by('position').filter(workout_template=workout_template)
    for exercise_template in exercise_template_list:
        lift_template = LiftTemplate.objects.get(exercise_template=exercise_template)
#        exercise_type = ExerciseType.objects.get(id=lift_template.type.id)
#        print lift_template.type.name
        reps_template = RepsTemplate.objects.filter(lift_template=lift_template)
        dict += [exercise_template] + [lift_template.type] + [lift_template] + list(reps_template)
    print("dict:",simplejson.dumps(simplejson.loads(serializers.serialize('json', dict)), indent=4))
    return compile_gwt_response(request, serializers.serialize('json', dict))
    
def save (request, member_id):

    workout_template_id = int(request.GET['workout_template_id']) if 'workout_template_id' in request.GET else None
    # and isinstance(request.GET['workout_template_id'])

    name = request.GET['name'] if 'name' in request.GET else None
#    collection = request.GET['collection']
#    position = request.GET['position']
    json = simplejson.loads(request.GET['template']) if 'template' in request.GET else None

    position = WorkoutTemplate.objects.count()

    # Ensure we have all the parameters necessary to save our template
#    if name and collection and position and json:
    if name and json:

#        template_collection = TemplateCollection.objects.get(id=collection)

        # These will be "list" templates for the time being until the time
        # allocation is sorted out
        workout_template = WorkoutTemplate(
            id = workout_template_id,
            name = name,
            author = Member.objects.get(id=member_id),
#            collection = template_collection,
            position = position
        )

        workout_template.save()
        
        exercise_list = json['exercise_list']

        for lift_template in LiftTemplate.objects.filter(workout_template=workout_template):
            for reps_template in RepsTemplate.objects.filter(lift_template=lift_template):
                reps_template.delete()
            lift_template.exercise_template.delete()
            lift_template.delete()                

        # TODO Disallow these from being re-created each time a template is saved         
        index=0
        for exercise in exercise_list:
            exercise_template = ExerciseTemplate(
                workout_template = workout_template,
                position = index,
                notes = exercise['notes']
                )
            exercise_template.save()
            print("warmup_reps: ", exercise['warmup_reps'])
            print("workout_reps: ", exercise['workout_reps'])
            lift_template = LiftTemplate(
                workout_template = workout_template,
                exercise_template = exercise_template,
                type = ExerciseType.objects.get(id=exercise['typeId']), #request.GET['exercise_type_id']),
                rest = exercise['rest'], #_list[index],
                )
            lift_template.save()
            save_reps(lift_template, exercise['warmup_reps'], False)
            save_reps(lift_template, exercise['workout_reps'], True)
            index+=1

        response_dict = {
                          'success': True,
                          'messages': ["Success"],
                          'id': workout_template.id,
                          'name': name,
#                          'collection': collection
                        }
        return compile_json_response(request, response_dict)

    else:
        response_dict = {
                          'success': False, 
                          'messages': ["Failed"]
                        }
        return compile_json_response(request, response_dict)

def save_reps(lift_template, reps_list, work):
    for reps in reps_list:
        reps_template = RepsTemplate(
            lift_template = lift_template,
            reps = reps,
            work = work
        )
        reps_template.save()

#def fetch_template_collections(request, member_id):
#    return serializers.serialize('json', TemplateCollection.objects.get(author=Member.objects.get(id=1)))
    
def fetch_workout_template_list(request, member_id):
    workout_template_list = WorkoutTemplate.objects.filter(id=member_id)
    res = []
    for workout_template in workout_template_list:
        res.append({
                    'pk': workout_template.id,
                    'name': workout_template.name
                    })
    return res

# Include all initial AJAX calls to retrieve the JSON
def init(request):
    if 'member_id' in request.GET:
        json = {
                'exercise_list': fetch_exercise_list(request),
                #        'save_form': fetch_save_form(request),
#                'template_collections': fetch_template_collections(request, request.GET['member_id']),
#                'workout_templates': serializers.serialize('json', fetch_workout_template_list(request, request.GET['member_id'])),
                'workout_template_list': fetch_workout_template_list(request, request.GET['member_id']),
        }
#        print json
    else:
        json = {
                'messages': ["Please specify a user."],
        }
    return compile_json_response(request, json)

# Returns the raw populated template, no HTTP response
def fetch_save_form(request):
#    t = get_template('template_editor/workout_template_form.html')
#    obj_dict = { 'workout_template_form': WorkoutTemplateForm() }
#    return t.render(Context(obj_dict)) + fetch_workout_template_list()
    return serialize_form(WorkoutTemplateForm())
   
# Returns the raw JSON data as a list, not formatted
# TODO: NEED UNIT TESTS FOR THESE KINDS OF FUNCTIONS
def fetch_exercise_list(request):
# Fetches exercise types from database and formats them into a JSON string for the template editor
# TODO: How to maximize efficiency with this sort of function
    ls = []
    muscle_entity_list = MuscleEntity.objects.filter(primary=True)
    # TODO: Ask Dad if there's any way to accomplish this without iterating (i.e., one SQL call)
    for muscle_entity in muscle_entity_list:
#        exercise_type_list = ExerciseType.objects.filter(muscle_entities__in=get_children(MuscleEntity.objects.get(id=muscle_entity.id))) 
        exercise_type_list = ExerciseType.objects.filter(primary_muscle__in=get_children(MuscleEntity.objects.get(id=muscle_entity.id))) 
        dict = { 
            'name': muscle_entity.name,
            'type_names_list': map(lambda exercise_type: exercise_type.name, exercise_type_list),
            'type_ids_list': map(lambda exercise_type: exercise_type.id, exercise_type_list)
            }
        ls.append(dict)
    return ls

# TODO: Put these in models
#def fetch_workout_template_list(request, collection_id):
#    t = get_template('template_editor/workout_template_list.html')
#    obj_dict = { 'workout_template_list': WorkoutTemplate.objects.filter(collection=TemplateCollection.objects.get(id=collection_id)) }
##    obj_dict = { 'workout_template_form': XForm() }
#    return t.render(Context(obj_dict))

## TODO: How to render a template without setting all the parameters?
#def compile_html_response(request, template, obj_dict):
#    t = get_template(template)
#    final = t.render(Context(obj_dict))
##    return compile_gwt_response(request, json)

# Takes json and returns an HTTP response with headers that GWT can understand
def compile_json_response(request, json):
    return compile_gwt_response(request, simplejson.dumps(json))

def compile_gwt_response(request, body):

    if 'callback' in request.GET:
        body = ('%s(%s);' % (request.GET['callback'], body))

    response = HttpResponse(body)

    response['Content-Type'] = 'text/javascript'
    response['Content-Length'] = len(body)
    response['Expires'] = -1
    response['Cache-Control'] = 'no-cache'
    response['Pragma'] = 'no-cache'

    return response

#class XForm(ModelForm):
##    collections = forms.WorkoutTemplateChoiceField(TemplateCollection.objects.all())
#
#    class Meta:
#        model = LiftTemplate
#        exclude = 'position'

# For testing calls via the browser
def view_exercise_list(request):
#    return compile_json_response(request, fetch_exercise_list(request))
    return HttpResponse(fetch_exercise_list(request))

def view_workout_template_list(request):
    return HttpResponse(fetch_workout_template_list(request, request.GET['member_id']))

def view_serialized_form(request):
    return HttpResponse(simplejson.dumps(serialize_form(WorkoutTemplateForm()), indent=4))

def view_save_form(request):
#    return compile_json_response(request, fetch_save_form(request))
    return HttpResponse(fetch_save_form(request))

def service_load_exercise_templates(request):
    return compile_gwt_response(request,
            serializers.serialize('json',
                    ExerciseTemplate.objects.order_by('position').filter(workout_template=WorkoutTemplate.objects.get(
                            id=int(request.GET['workout_template_id']) if 'workout_template_id' in request.GET else None
                    )),
                    relations = ()
            )
    )

def service_load_lift_templates(request):
    return compile_gwt_response(request,
            serializers.serialize('json', 
                    LiftTemplate.objects.filter(
                            exercise_template__in=ExerciseTemplate.objects.order_by('position').filter(
                                    workout_template=WorkoutTemplate.objects.get(
                                            id=int(request.GET['workout_template_id']) if 'workout_template_id' in request.GET else None
                                    )
                            )
                    ),
                    relations = ()
            )
    )
                
# Nested relations/fields/exclude/etc
# >>> print serializers.serialize('json', lt, relations={'type': {'relations':('primary_muscle',),'exercise_template':{}}}, indent=4)                    

def service_load_workout_template(request):
    if 'workout_template_id' in request.GET:
        return compile_gwt_response(request,
                serializers.serialize('json',
                        WorkoutTemplate.objects.filter(
                                id=int(request.GET['workout_template_id']) if 'workout_template_id' in request.GET else None
                        ),
                        # TODO: Test getting "LiftTemplate" as a reverse key
                        reverse = {'ExerciseTemplate': 'workout_template', 'LiftTemplate': {'relations': 'type', 'reverse': {'RepsTemplate': 'lift_template'}}}
                )
        )
    else:
        return compile_gwt_response(request,
                                    "Must specify a WorkoutTemplate object with workout_template_id parameter.")

#print serializers.serialize('json', WorkoutTemplate.objects.filter(id=1), reverse = {('WorkoutTemplate', 'exercise_template')}) #, 'lift_template': {'reverse': ('reps_template',) }}

  
# EXAMPLE: Cyclic fk references
# print serializers.serialize('json', lt, relations={'type': {'relations':('primary_muscle',),'exercise_template':{}}}, indent=4)    
# See fitness/sample-serialization-output
