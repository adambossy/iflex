from django.shortcuts import render_to_response
from django.http import HttpResponseRedirect

from time import gmtime, strptime
from datetime import datetime

from iflex.journal.models import *
from iflex.members.models import Member

from django.forms import ModelForm
from django.core.files.uploadedfile import SimpleUploadedFile

class JournalForm (ModelForm):
    class Meta:
        model = Pic # JournalEntry
#        exclude = ('member',)

def default (request):
    return HttpResponseRedirect('/journal/1/')

def index (request, member_id):
    # TO DO: If member_id does not exist, then throw error page saying "Member does not exist."
    obj_dict = {
        'journal_entries_list': JournalEntry.objects.filter(member=member_id).order_by('-date')[0:10],
        'member': Member.objects.get(id=member_id),
        }
    return render_to_response('journal/index.html', obj_dict)

# TODO: Check for image extensions (.jpg, .gif, .png, etc.) (Download PIL [Python imaging library])
# TODO: Auto-create thumbnails
# TODO: Find a way to make the lack of a date throw a custom error message.
# TODO: Add date picker to date form field.
# TODO: Make the default date today's date.

def add (request, member_id):
    # validate form, yadda yadda
    # TO DO: extend this form by using a template. allow
    # the template to dynamically add multiple pics. auto-
    # matically bind the form to its respective model.
    if request.POST:
        jform = JournalForm(request.POST, request.FILES)
        if jform.is_valid():
            cd = jform.cleaned_data
            instance = jform.save() #cd.save()
            feedback = 'Note added successfully.'
            return HttpResponseRedirect('/journal/add/%s/?feedback=%s' % (member_id, feedback))
        else:
            obj_dict = {
                'journal_form': jform,
                'member': Member.objects.get(id=member_id),
            }
            return render_to_response('journal/add.html', obj_dict)
    else:
        obj_dict = {
            'journal_form': JournalForm(),
            'member': Member.objects.get(id=member_id),
            }
        if request.GET:
            obj_dict['feedback'] = request.GET['feedback']
        return render_to_response('journal/add.html', obj_dict)
 
# TODO: Delete images?
def delete (request, member_id, journal_entry_id):
    journal_entry = JournalEntry.objects.get (member=member_id, id=journal_entry_id)
    journal_entry.pic_set.all().delete()
    feedback = "Entry deleted successfully."
    journal_entry.delete()
    return HttpResponseRedirect('/journal/%s/?feedback=%s' % (member_id, feedback))
