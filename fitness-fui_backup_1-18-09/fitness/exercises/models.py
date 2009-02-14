from django.db import models

from iflex.members.models import *
from iflex.muscles.models import *

# Create your models here.

# #class CardioType (models.Model): # A reference table for types of exercise (run, biceps curl, bike, etc.)
# class MuscleGroup (models.Model):

# #    LOWER_BODY = (
# #        ('0', 'False'),
# #        ('1', 'True'),
# #        )

# #    lower_body = models.IntegerField(max_length=1, choices=LOWER_BODY)

# #    UPPER_BODY = (
# #        ('0', 'False'),
# #        ('1', 'True'),
# #        )

# #    upper_body = models.IntegerField(max_length=1, choices=UPPER_BODY)

#     BODY_SEGMENT_CHOICES = (
#         ('0', 'Lower Body'),
#         ('1', 'Upper Body'),
#         )

#     body_segment = models.IntegerField(max_length=1, choices=BODY_SEGMENT_CHOICES)

#     name = models.CharField(max_length=64)

#     def __unicode__(self):
#         return (str(self.id) + ', ' + self.name + ', ' +
#                 str(self.body_segment) + '\n')

class ExerciseType (models.Model): # A reference table for types of exercise (run, biceps curl, bike, etc.)

    # 0, lift type, 1, cardio type
    TYPE_CHOICES = (
        ('0', 'lift_type'),
        ('1', 'cardio_type'),
    )

    type = models.IntegerField(max_length=1, choices=TYPE_CHOICES)

    name = models.CharField(max_length=64)

    # Parents exist for variations of major exercises (like Bench Press; it's a parent of many forms of bench presses)
    parent = models.ForeignKey('self', null=True, blank=True)
    
    muscle_entities = models.ManyToManyField(MuscleEntity, related_name="muscle_entities")  

    primary_muscle = models.ForeignKey(MuscleEntity, related_name="primary_muscle", blank=True)
    
    secondary_muscle = models.ForeignKey(MuscleEntity, related_name="secondary_muscle", null=True, blank=True)

    created_by = models.ForeignKey(Member)

    time_created = models.DateTimeField(auto_now_add=True)

    def __unicode__(self):
        # TODO: Figure out a way to cleanly format these damn django toString methods with newlines
        s = (str(self.type) + ', ' + self.name + ', muscle_entites=[') # + str(self.muscle_entities))
#        for muscle_entity in self.muscle_entities.all():
#            s += ('\n ' + str(muscle_entity))
        s+=",".join(map(lambda obj: str(obj), list(self.muscle_entities.all())))
        return (s + ']\n')


#class LiftType (models.Model): # A reference table for types of exercise (run, biceps curl, bike, etc.)

#    type = models.CharField(max_length=64)

#    created_by = models.ForeignKey(Member)

#    time_created = models.DateTimeField(auto_now_add=True)

#    def __str__(self):
#        return (str(self.id) + ', ' + self.type)
