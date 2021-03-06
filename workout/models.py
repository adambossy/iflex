from django.db import models

from iflex.members.models import Member
from iflex.exercises.models import ExerciseType

# TO-DO: pictures/journaling feature for progress monitoring

# Actual contents for workouts that have taken place 

# A workout (a compilation of exercises)
class Workout (models.Model): 

    member = models.ForeignKey(Member)

    date = models.DateTimeField()

    time_created = models.DateTimeField(auto_now_add=True)

    # Notes on the workout
    notes = models.CharField(max_length=256) 

    def __str__(self):
        return (str(self.id) + ', ' + str(self.date) + ', ' + self.notes + ', ' + str(self.time_created))
#        return (str(self.id) + ', ' + self.member_id + ', ' + self.data + ', ' + self.notes)

# An exercise that the member has actually completed as part of a workout
class Exercise (models.Model): 

    workout = models.ForeignKey(Workout)

    # Total calories burned in this workout
    # NOTE: May NOT be NULL? (any of these values should be optional)
    # Make this automatically computable based on distance and weight
    calories = models.IntegerField() #max_digits=4)

    # For ordering workout correctly
    position = models.IntegerField()

    # reps (cnt), weight (kg or lbs --const) -- weight
    # time (minutes), distance(km, mi, laps*dist/laps) etc. -- cardio

    # Notes on the workout
    notes = models.CharField(max_length=256, blank=True, null=True)

    def __str__(self):
        return (str(self.id) + ', ' + str(self.workout) + ', ' + str(self.calories) + ', ' + ', ' + str(self.position) + ', ' + self.notes)

# Templates and Dat

# *** Templates ***

# Structures pertaining to how future (or past) workouts should be laid out 

#class CardioType (models.Model): # A reference table for types of exercise (run, biceps curl, bike, etc.)

#    type = models.CharField(max_length=64)

#    def __str__(self):
#        return (str(self.id) + ', ' + self.type)

#class LiftType (models.Model): # A reference table for types of exercise (run, biceps curl, bike, etc.)

#    type = models.CharField(max_length=64)

#    def __str__(self):
#        return (str(self.id) + ', ' + self.type)

# A reference table for types of exercise (run, biceps curl, bike, etc.)
# Listing of exercise types; extending as members add new ones; similar ones are consolidated by us to filter noise
# Ideally, this would have a list of parameters listed in a separate table, to data for which would be stored in yet another table
#  and stored in the aforementioned one
#class ExerciseType2 (models.Model):

    # Name of workout type (run, bench press, lap swim, etc.)
#    type = models.CharField(max_length=128) 

##    cl = models.ForeignKey(ExerciseClass)

#    def __str__(self):
#        return (str(self.id) + ', ' + self.type + ', ' + self.cl.className)

# reps (cnt), weight (kg or lbs --const) -- weight
# time (minutes), distance(km, mi, laps*dist/laps) etc. -- cardio
class Cardio (models.Model):

    workout = models.ForeignKey(Workout)

    exercise = models.ForeignKey(Exercise)

    type = models.ForeignKey(ExerciseType)

    # May need break down for warm up, even time stretched
#    time = models.TimeField()
    time = models.IntegerField()

    dist = models.FloatField()#decimal_places=1)

    UNITS_CHOICES = (
        ('km', 'kilometers'),
        ('mi', 'miles'),
    )
    
    units = models.CharField(max_length=2, choices=UNITS_CHOICES)

    def __str__(self):
        return (str(self.id) + ', ' + str(self.exercise) + ', ' + str(self.type) + ', ' + str(self.time) + ', ' + str(self.dist) + ', ' + self.units)

class Lift (models.Model):

    workout = models.ForeignKey(Workout)

    exercise = models.ForeignKey(Exercise)

    type = models.ForeignKey(ExerciseType)

    reps = models.IntegerField()

    weight = models.IntegerField()

    UNITS_CHOICES = (
        ('kg', 'kilograms'),
        ('lbs', 'pounds'),
    )

    units = models.CharField(max_length=3, choices=UNITS_CHOICES)

    def __str__(self):
        return (str(self.id) + ', ' + str(self.exercise) + ', ' + str(self.type) + ', ' + str(self.reps) + ', ' + str(self.weight) + ', ' + self.units)

# *** Data ***

