from django.shortcuts import render_to_response
from django.http import HttpResponseRedirect, HttpResponse
from django.core import serializers
from django.utils import simplejson
from iflex.workout.models import *
from iflex.exercises.models import *
# TODO Move this function so that we're not importing views
from iflex.template_editor.views import compile_json_response
from iflex.template_editor.models import *
from datetime import datetime
from time import strptime

import cPickle

# TODO There's a proper way of doing this. Fix it:
project_root = '/home/abossy/projects/fitness/templates/workout'
css_root = project_root

def index (request):
    return HttpResponseRedirect('/workout/profile/1/')

def add_workout (request, member_id):
    return render_to_response('workout/add_workout.html', None)
    
def fetch_workout_template (request, member_id):

    # Let's just assume the id is 10 for fun
    template = WorkoutTemplate.objects.get(id=1)
    lift_template_list = list(LiftTemplate.objects.filter(workout_template=template))
    workout_item_list = []
    for lift_template in lift_template_list:
        workout_item = {
            'pk': lift_template.id,
#            'model': lift_template.model,
            'type_id': lift_template.type.id,
            'type': lift_template.type.name,
            'warmup_sets': lift_template.warmup_sets,
            'warmup_reps': lift_template.warmup_reps,
            'workout_sets': lift_template.workout_sets,
            'workout_reps': lift_template.workout_reps,
            'tempo': lift_template.tempo,
            'rest': lift_template.rest
        }
        workout_item_list.append(workout_item)

    obj_dict = {
        'workout_item_list': workout_item_list,
    }
    print workout_item_list
#    json = serializers.serialize("json", workout_item_list)
#    json = simplejson.dumps(workout_item_list)
#    return HttpResponse(json)
    return compile_json_response(request, obj_dict)

#    return render_to_response('workout/add_workout.html', obj_dict)
    # serializers.serialize("json", LiftTemplate.objects.filter(workout_template=template))
#    return HttpResponse(exercise_type_list)
def fetch_id_name(exercise_type):
    return { str(exercise_type.id): exercise_type.name } 
    
def add (request, member_id):

    # Need a more flexible date parsing algorithm for 'date' column
    workout = Workout (
        member = Member.objects.get(id=member_id),
        date = datetime(*strptime(request.POST['date'], "%m/%d/%Y")[0:6]),
        notes = request.POST['notes'],
        )
    workout.save()

    exercise_list = request.POST.getlist('id[]')

    print "REQUEST: ", request
    print "exercise_list: ", exercise_list

    cardio_index = 0
    lift_index = 0

    for exercise_type in exercise_list:
        print "exercise_type: ", exercise_type
        exercise = Exercise (
            workout = workout,
            position = request.POST.getlist('index[]')[cardio_index+lift_index],
            calories = request.POST['calories'],
            ) # notes, calories
        exercise.save()
        if exercise_type=='cardio':
            write_cardio(request.POST, workout, exercise, cardio_index)
            cardio_index=cardio_index+1
        elif exercise_type=='lift':
            write_lift(request.POST, workout, exercise, lift_index)
            lift_index=lift_index+1

    return HttpResponseRedirect('/workout/profile/%s/' % member_id)

def write_lift (rp, wo, ex, li):
    lift_type = rp.getlist('lift_type[]')[li]
    print lift_type
    lift = Lift (
        workout=wo,
        exercise=ex,
        type=ExerciseType.objects.get(id=lift_type),
        reps=rp.getlist('reps[]')[li],
        weight=rp.getlist('weight[]')[li],
        units=rp.getlist('lift_units[]')[li],
        )
    lift.save()

def write_cardio (rp, wo, ex, ci):
    cardio_type = rp.getlist('cardio_type[]')[ci]
    print cardio_type
    cardio = Cardio (
        workout=wo,
        exercise=ex,
        type=ExerciseType.objects.get(id=rp.getlist('cardio_type[]')[ci]),
#        time = time(0, rp.getlist('time[]')[ci]),
#        time = datetime(*strptime(rp.getlist('time[]')[ci], "ss")[0:6]),
        time=rp.getlist('time[]')[ci],
        dist=rp.getlist('distance[]')[ci],
        units=rp.getlist('cardio_units[]')[ci],
       ) 
    cardio.save()

def profile (request, member_id):
    obj_dict = {
        'member': Member.objects.get(id=member_id),
        'recent_workouts': Workout.objects.filter(member=member_id).order_by('-date')[0:2],
        }
    return render_to_response('workout/profile.html', obj_dict)
    
#def recent (request, member_id):
#    workouts = Workout.object.get(id=member_id)
    
def recent (request, member_id):
    recent_workouts_dict = {
        'member': Member.objects.get(id=member_id),
#        'recent_workouts': Workout.objects.filter(member=member_id).order_by('-date')[0:10],
        'recent_workouts': Workout.objects.filter(member=member_id).order_by('-date'),
        }
    return render_to_response('workout/recent.html', recent_workouts_dict)

def details (request, member_id, workout_id):

    lift_type_list = ExerciseType.objects.filter(id=0)
    cardio_type_list = ExerciseType.objects.filter(id=1)

    member = Member.objects.get(id=member_id)
    workout = Workout.objects.get(member=member, id=workout_id)

    exercise_list = Exercise.objects.filter(workout=workout)
    cardio_list = Cardio.objects.filter(workout=workout)
    lift_list = Lift.objects.filter(workout=workout)

    print cardio_list.values()
    print lift_list.values()

    cardio_index = 0
    lift_index = 0
    exercise_list_out = []
    for exercise in exercise_list:
        print "ci: ", cardio_index
        print "li: ", lift_index
        if cardio_list and cardio_index < len(cardio_list.values()):
            if exercise.id == cardio_list[cardio_index].exercise_id:
                exercise_list_out.append(cardio_list[cardio_index])
                cardio_index = cardio_index + 1
        if lift_list and lift_index < len(lift_list.values()):
            if exercise.id == lift_list[lift_index].exercise_id:
                exercise_list_out.append(lift_list[lift_index])
                lift_index = lift_index + 1

    workout_details_dict = {
        'workout': workout,
        'exercise_list': exercise_list,
        'exercise_list_out': exercise_list_out,
        }

    print "DEBUG INFO"
    print workout
    print exercise_list
    print cardio_list
    print lift_list
    print exercise_list_out

    return render_to_response('workout/details.html', workout_details_dict)

# There should already exist a function that does this, I just don't know the name.
#def front (ls):
#    var=ls[0]
#    ls=ls[1:]
#    return var

def reqList (el):
    request.POST.getlist[el]

def test (request, member_id):
    obj_dict = {
        'member_id': member_id
        }
    return render_to_response('workout/test.html', obj_dict)
