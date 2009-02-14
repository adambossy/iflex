from django.db import models
from django.forms import ModelForm
from django.utils import simplejson

from iflex.members.models import Member
from iflex.exercises.models import ExerciseType

class TemplateCollection(models.Model):

    # TODO: ignore fancy week range and all. Each template consists of only one workout right now.
    name = models.CharField(max_length=64)

    author = models.ForeignKey(Member)

    def __unicode__(self):
        return (self.name + ', ' + str(self.author))

# class WorkoutTemplateChoiceField(forms.ModelChoiceField):
#     def _get_choices(self):
#         # Technically, don't have to do this, but do so anyway to be the most
#         # compatible with parent's behavior.
#         if hasattr(self, "_choices"):
#             return self._choices
#         return WorkoutTemplateQuerySetIterator(self.queryset, self.empty_label,
#             self.cache_choices)
#     choices = property(_get_choices, forms.ModelChoiceField._set_choices)

class WorkoutTemplate(models.Model):
    
    name = models.CharField(max_length=64, verbose_name='Template Name')

    position = models.IntegerField()

    # name "Workout A", "Upper Body Circuit", "Shoulders and Lats"

    # position (for ordering)

    # Some kind of date repition information ripped from Google Calendar
    # TODO: Should be viewable on a calendar

    # One-to-many relationships between workouts and collections at the moment
    # Will possibly make this a ManyToMany relationship in the future
    collection = models.ForeignKey(TemplateCollection, verbose_name='My Collections', blank=True, null=True)

    description = models.CharField(max_length=1024, blank=True, null=True)
    
    author = models.ForeignKey(Member)

    def __unicode__(self):
        return (self.name + ', ' + str(self.collection) + ', ' + str(self.author))

class WorkoutTemplateForm(ModelForm):
#    collections = forms.WorkoutTemplateChoiceField(TemplateCollection.objects.all())
    class Meta:
        model = WorkoutTemplate
        exclude = 'position'

def serialize_form(form):
    fields = []
    dict = {}
    for field in form:
        field_dict = {
            'html': str(field),  
            'label': field.label,
            'label_tag': field.label_tag(),
            'html_name': field.html_name,
            'help_text': field.help_text,
            'errors': field.errors,
        }
        dict.update( { field.name: field_dict } )
        fields.append(field.name)
    dict.update({ 'fields': fields })
    return dict

# An exercise that the member has actually completed as part of a workout
# NOTE: Holds mainly just ordering information
class ExerciseTemplate (models.Model): 

    workout_template = models.ForeignKey(WorkoutTemplate)

    # For ordering workout template correctly
    position = models.IntegerField()

    notes = models.CharField(max_length=128, blank=True, null=True)
    
    def __str__(self):
        return (str(self.id) + ', ' + str(self.workout_template) + ', ' + str(self.position) + '\n')

# Does this even need to exist?
class LiftTemplate (models.Model):

    workout_template = models.ForeignKey(WorkoutTemplate)

    # One-to-one
    exercise_template = models.ForeignKey(ExerciseTemplate)

    type = models.ForeignKey(ExerciseType)

    # TODO: Make ranges and other such semantics allowable? Question: what would these added
    # semantics allow us to do? Keep as strings for now.
    # TODO: We probably don't need a max length of 12. What will people actually put here?
#    warmup_sets = models.CharField(max_length=12)

#    warmup_reps = models.CharField(max_length=12)

#    workout_sets = models.CharField(max_length=12)

#    workout_reps = models.CharField(max_length=12)

#    tempo = models.CharField(max_length=12)

    rest = models.CharField(max_length=12)
    
#    notes = models.CharField(max_length=64, blank=True, null=True)

    def __unicode__(self):
        return (str(self.id) + ',' + str(self.type) + ',' + self.rest)

class RepsTemplate (models.Model):
    
    lift_template = models.ForeignKey(LiftTemplate)
    
    reps = models.CharField(max_length=12)

    # True if work, false if warmup
    work = models.BooleanField()
    
    def __unicode__(self):
        return (str(self.id) + ',' + self.reps + ',' + str(self.work))
#    def __str__(self):
#        return (str(self.id) + ', ' + str(self.workout_template) + ', ' + str(self.exercise_template) + ', ' + str(self.type) + ', ' + self.warmup_sets + ', ' + self.warmup_reps + ', ' + self.workout_sets + ', ' + self.workout_reps + ', ' + self.tempo + ', ' + self.rest)

# TODO: CardioTemplate

