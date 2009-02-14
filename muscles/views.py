from django.shortcuts import render_to_response
from django.http import HttpResponseRedirect
from django.forms import ModelForm

from iflex.muscles.models import MuscleEntity
from iflex.exercises.models import ExerciseType
from iflex.members.models import Member

# from time import gmtime

class MuscleEntityForm (ModelForm):
    class Meta:
        model = MuscleEntity

def default(request):
    obj_dict = {
        'muscle_entity_form': MuscleEntityForm(),
        'muscle_entity_list': MuscleEntity.objects.all(),
        }
    if request.GET:
        obj_dict['feedback'] = request.GET['feedback']
    return render_to_response('muscles/default.html', obj_dict)

def add (request):
    print request.POST
    muscle_entity_form = MuscleEntityForm(request.POST)
    muscle_entity_form.save()
    feedback = request.POST['name'] + " added successfully."
    return HttpResponseRedirect('/muscles/?feedback=%s' % feedback)
    
def delete (request, muscle_entity_id):
    muscle_entity = MuscleEntity.objects.get (id=muscle_entity_id)
    feedback = muscle_entity.name + " deleted successfully."
    muscle_entity.delete()
    return HttpResponseRedirect('/muscles/?feedback=%s' % feedback)

#def default(request):
#    return render_to_response('muscles/default.html')
