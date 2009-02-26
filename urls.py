from django.conf.urls.defaults import *
from django.conf import settings
from django.contrib import admin
from iflex.workout.models import Workout
from iflex.members.models import Member
from iflex.exercises.models import ExerciseType

admin.autodiscover()

all_members_dict = {
    'queryset': Member.objects.all(),
}

#recent_workouts_dict = { 
#    'queryset': Workout.objects.all(),
#    'date_field': 'date',
#    'num_latest': 10,
#}

urlpatterns = patterns('',
                       # Workout
                       (r'^$', 'iflex.static.views.default'),

                       (r'^login/$', 'iflex.static.views.login'),

                       (r'^auth/$', 'iflex.static.views.auth'),

                       (r'^mockup/$', 'iflex.workout.views.'),

                       (r'^fetch/$', 'iflex.workout.views.fetch'),

                       (r'^workout/add/(?P<member_id>\d+)/$',
                        'iflex.workout.views.add'),

#                       (r'^workout/add_workout/(?P<member_id>\d+)/$',
#                        'iflex.workout.views.add_workout'),

                       (r'^workout/add_workout/$',
                        'iflex.workout.views.add_workout'),

#                       (r'^workout/fetch_workout_template/(?P<member_id>\d+)/$',
#                        'iflex.workout.views.fetch_workout_template'),

                       (r'^workout/profile/(?P<member_id>\d+)/$',
                        'iflex.workout.views.profile'),

                       (r'^workout/recent/(?P<member_id>\d+)/$',
                        'iflex.workout.views.recent'),

                       (r'^workout/details/(?P<member_id>\d+)/(?P<workout_id>\d+)/$',
                        'iflex.workout.views.details'),

                       # Exercises
                       (r'^exercises/$',
                        'iflex.exercises.views.default'),

                       (r'^exercises/add/$', 
                        'iflex.exercises.views.add'),

#                       (r'^exercises/addForm/$', 
#                        'iflex.exercises.views.addForm'),

#                       (r'^exercises/list/$', 
#                        'iflex.exercises.views.list'),

                       (r'^exercises/delete/(?P<exercise_id>\d+)/$', 
                        'iflex.exercises.views.delete'),

#                       (r'^exercises/script_init_workout_types/$',
#                        'iflex.exercises.views.script_init_workout_types'),

                       # Muscles
                       (r'^muscles/$',
                        'iflex.muscles.views.default'),

#                        (r'^muscles/default_muscle/$',
#                         'iflex.muscles.views.default_muscle'),

#                        (r'^muscles/default_muscle_group/$',
#                         'iflex.muscles.views.default_muscle_group'),

                        (r'^muscles/add/$', 
                         'iflex.muscles.views.add'),

#                        (r'^muscles/add_muscle_group/$', 
#                         'iflex.muscles.views.add_muscle_group'),

                        (r'^muscles/delete/(?P<muscle_id>\d+)/$', 
                         'iflex.muscles.views.delete'),

#                        (r'^muscles/delete_muscle_group/(?P<muscle_group_id>\d+)/$', 
#                         'iflex.muscles.views.delete_muscle_group'),

                       # Members
                       (r'^members/$', 'iflex.members.views.index'),

                       (r'^members/add/$', 'iflex.members.views.add'),

                       # Journal
                       (r'^journal/(?P<member_id>\d+)/$', 'iflex.journal.views.index'),

                       (r'^journal/$', 'iflex.journal.views.default'),

                       (r'^journal/add/(?P<member_id>\d+)/$', 'iflex.journal.views.add'),
#                       (r'^journal/add/$', 'iflex.journal.views.add'),

                       (r'^journal/addf/(?P<member_id>\d+)/$', 'iflex.journal.views.add'),

                       (r'^journal/delete/(?P<member_id>\d+)/(?P<journal_entry_id>\d+)/$',
                        'iflex.journal.views.delete'),

                       # Templates
                       # TODO: Should I even require a member id as an author or should I allow anonymous template creation
                       # using the session ID and IP (with some kind of spam restriction?)
                       (r'^template_editor/(?P<member_id>\d+)/$', 'iflex.template_editor.views.index'),

                       (r'^template_editor/save/(?P<member_id>\d+)/$', 'iflex.template_editor.views.save'),
                       
                       (r'^template_editor/load/$', 'iflex.template_editor.views.load'),
#                       (r'^template_editor/save/$', 'iflex.template_editor.views.save'),

                       # NOTE: using the naming convention "fetch" becaues it's remote...? instead of a data structure
#                       (r'^template_editor/fetch_exercises/$', 'iflex.template_editor.views.fetch_exercises'),
                       (r'^template_editor/init/$', 'iflex.template_editor.views.init'),

                       (r'^template_editor/service_load_exercise_templates/$', 'iflex.template_editor.views.service_load_exercise_templates'),
                       (r'^template_editor/service_load_lift_templates/$', 'iflex.template_editor.views.service_load_lift_templates'),
                       (r'^template_editor/service_load_workout_template/$', 'iflex.template_editor.views.service_load_workout_template'),

                       # Admin
                       (r'^admin/(.*)', admin.site.root),
#                       (r'^admin/', include('django.contrib.admin.urls')),

                       (r'^test/(?P<member_id>\d+)/$', 'iflex.workout.views.test'),


                       # Static Content (images, CSS, video, etc.)
#                       (r'^site_media/(?P<path>.*)$', 'django.views.static.serve', {'document_root': '/home/abossy/projects/fitness/media', 'show_indexes': True}),

)

# The following conditional block is to test the JSON being passed through in the calls to "template_editor/init"
if settings.DEBUG:
    urlpatterns += patterns ('',
                             (r'^template_editor/view_save_form/$', 'iflex.template_editor.views.view_save_form'),
                             (r'^template_editor/view_exercise_list/$', 'iflex.template_editor.views.view_exercise_list'),
#                             (r'^template_editor/view_workout_template_list/(?P<collection_id>\d+)/$', 'iflex.template_editor.views.view_workout_template_list'),
                             (r'^template_editor/view_workout_template_list/$', 'iflex.template_editor.views.view_workout_template_list'),
                             (r'^template_editor/view_serialized_form/$', 'iflex.template_editor.views.view_serialized_form'),
                             (r'^template_editor/view_load/$', 'iflex.template_editor.views.view_load'),
                             )


if settings.DEBUG:
    urlpatterns += patterns ('',
                             (r'^media/(?P<path>.*)$', 'django.views.static.serve', {'document_root': settings.MEDIA_ROOT, 'show_indexes': True}),
                             )

if settings.DEBUG:
    urlpatterns += patterns ('',
                             (r'^admin_media/(?P<path>.*)$', 'django.views.static.serve', {'document_root': settings.SITE_ROOT + settings.ADMIN_MEDIA_PREFIX, 'show_indexes': True}),
                             )

#if settings.DEBUG:
#    urlpatterns += patterns ('',
                             # Static Content (images, CSS, video, etc.)
#                             (r'^media/(?P<path>.*)$', 'django.views.static.serve',
#                              {'document_root': '/home/abossy/projects/fitness/media',
#                               'show_indexes': True
#                               }),
#                             )


 
