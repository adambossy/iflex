from django.shortcuts import render_to_response
from django.http import HttpResponseRedirect
from iflex.workout.models import *

def index (request):
    return render_to_response('members/add.html', )

def add (request):
    # TODO: Get birthday instead of "age" to keep it up to date
    member = Member (
        firstName = request.POST['firstName'],
        lastName = request.POST['lastName'],
        password = request.POST['password'],
        age = request.POST['age'],
        height = request.POST['height'],
        weight = request.POST['weight']
        )
    member.save()
    return HttpResponseRedirect('/workout/profile/%s/' % member.id)
