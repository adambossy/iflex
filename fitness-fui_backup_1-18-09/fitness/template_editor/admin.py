from iflex.template_editor.models import *
from django.contrib import admin

class WorkoutTemplateInline(admin.TabularInline):
    model = WorkoutTemplate
    extra = 3

class ExerciseTemplateInline(admin.TabularInline):
    model = ExerciseTemplate
    extra = 3

class LiftTemplateInline(admin.TabularInline):
    model = LiftTemplate
    extra = 3

class TemplateCollectionAdmin(admin.ModelAdmin):
#    fieldsets = [
#        (None,               {'fields': ['question']}),
#        ('Date information', {'fields': ['pub_date'], 'classes': ['collapse']}),
#    ]
    inlines = [WorkoutTemplateInline]

class WorkoutCollectionAdmin(admin.ModelAdmin):
    inlines = [ExerciseTemplateInline, LiftTemplateInline]

admin.site.register(TemplateCollection, TemplateCollectionAdmin)
admin.site.register(WorkoutTemplate, WorkoutCollectionAdmin)
admin.site.register(ExerciseTemplate)
admin.site.register(LiftTemplate)
admin.site.register(RepsTemplate)