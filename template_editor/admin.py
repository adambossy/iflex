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

class RepsTemplateInline(admin.TabularInline):
    model = RepsTemplate
    extra = 3

class TemplateCollectionAdmin(admin.ModelAdmin):
#    fieldsets = [
#        (None,               {'fields': ['question']}),
#        ('Date information', {'fields': ['pub_date'], 'classes': ['collapse']}),
#    ]
    inlines = [WorkoutTemplateInline]

class WorkoutTemplateAdmin(admin.ModelAdmin):
    inlines = [ExerciseTemplateInline, LiftTemplateInline]

class LiftTemplateAdmin(admin.ModelAdmin):
    inlines = [RepsTemplateInline]

admin.site.register(TemplateCollection, TemplateCollectionAdmin)
admin.site.register(WorkoutTemplate, WorkoutTemplateAdmin)
admin.site.register(ExerciseTemplate)
admin.site.register(LiftTemplate, LiftTemplateAdmin)
admin.site.register(RepsTemplate)

