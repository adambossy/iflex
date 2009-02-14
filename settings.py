# Django settings for iflex project.

DEBUG = True
TEMPLATE_DEBUG = DEBUG

ADMINS = (
    ('Adam Bossy', 'adambossy@gmail.com'),
)

MANAGERS = ADMINS

DATABASE_ENGINE = 'sqlite3'           # 'postgresql_psycopg2', 'postgresql', 'mysql', 'sqlite3' or 'ado_mssql'.
DATABASE_NAME = '/Users/adambossy/Documents/workspace/iflex/database/iflex.db'
DATABASE_USER = ''             # Not used with sqlite3.
DATABASE_PASSWORD = ''         # Not used with sqlite3.
DATABASE_HOST = ''             # Set to empty string for localhost. Not used with sqlite3.
DATABASE_PORT = ''             # Set to empty string for default. Not used with sqlite3.

# Local time zone for this installation. Choices can be found here:
# http://www.postgresql.org/docs/8.1/static/datetime-keywords.html#DATETIME-TIMEZONE-SET-TABLE
# although not all variations may be possible on all operating systems.
# If running in a Windows environment this must be set to the same as your
# system time zone.
TIME_ZONE = 'America/Chicago'

# Language code for this installation. All choices can be found here:
# http://www.w3.org/TR/REC-html40/struct/dirlang.html#langcodes
# http://blogs.law.harvard.edu/tech/stories/storyReader$15
LANGUAGE_CODE = 'en-us'

SITE_ID = 1

# If you set this to False, Django will make some optimizations so as not
# to load the internationalization machinery.
USE_I18N = True

#DMIGRATIONS_DIR = 'C:/Documents and Settings/Administrator/workspace/iflex/dmigrations'

# DEFINED BY ADAM FOR SYNC-GWT
SITE_ROOT = '/Users/adambossy/Documents/workspace/iflex/' 
ROOT_URL = 'http://localhost:8000/'

# Absolute path to the directory that holds media.
# Example: "/home/media/media.lawrence.com/"
MEDIA_ROOT = '/Users/adambossy/Documents/workspace/iflex/site_media'

# URL that handles the media served from MEDIA_ROOT.
# Example: "http://media.lawrence.com"
MEDIA_URL = 'http://localhost:8000/media/' # ??? unknown as of now

# URL prefix for admin media -- CSS, JavaScript and images. Make sure to use a
# trailing slash.
# Examples: "http://foo.com/media/", "/media/".
ADMIN_MEDIA_PREFIX = '/admin_media/'

# Make this unique, and don't share it with anybody.
SECRET_KEY = '*boxr50z%o9%hhh3wlba+rmc*-l#t&sc-nfw46s0w_wejz#%el'

# List of callables that know how to import templates from various sources.
TEMPLATE_LOADERS = (
    'django.template.loaders.filesystem.load_template_source',
    'django.template.loaders.app_directories.load_template_source',
#     'django.template.loaders.eggs.load_template_source',
)

MIDDLEWARE_CLASSES = (
    'django.middleware.common.CommonMiddleware',
    'django.contrib.sessions.middleware.SessionMiddleware',
    'django.contrib.auth.middleware.AuthenticationMiddleware',
    'django.middleware.doc.XViewMiddleware',
)

ROOT_URLCONF = 'iflex.urls'

TEMPLATE_DIRS = (
    # Put strings here, like "/home/html/django_templates" or "C:/www/django/templates".
    # Always use forward slashes, even on Windows.
    # Don't forget to use absolute paths, not relative paths.
    "/Users/adambossy/Documents/workspace/iflex/templates/"
)

INSTALLED_APPS = (
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.sites',
    'django.contrib.admin',
    'iflex.workout',
    'iflex.members',
    'iflex.exercises',
    'iflex.journal',
    'iflex.template_editor',
    'iflex.muscles',
#    'iflex.dmigrations'
)

GWT_MODELS_DIR = '/Users/adambossy/Documents/workspace/iflex/fui/src/com/healthySoftware/client/util/models/'

GWT_SERVICES_DIR = '/Users/adambossy/Documents/workspace/iflex/fui/src/com/healthySoftware/client/util/services/'

SERIALIZATION_MODULES = {
    'json' : 'django.utils.serializers.json',
    'python' : 'django.utils.serializers.python'
} 