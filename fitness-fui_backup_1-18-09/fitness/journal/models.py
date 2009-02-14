import os
import tempfile 

from django.db import models
from django.core.files.storage import FileSystemStorage

from iflex.members.models import Member

IMAGES_ROOT = 'images'

#FS = FileSystemStorage(location='/media/' + IMAGES_ROOT)

class JournalEntry (models.Model):

    member = models.ForeignKey(Member)

    notes = models.CharField(max_length=256)

    date = models.DateTimeField()

    time_created = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return (str(self.id) + ', ' + str(self.member.id) + ', ' +
                self.notes + ', ' + str(self.date) + ', ' + str(self.time_created))

class Pic (models.Model):

    journal_entry = models.ForeignKey(JournalEntry)

    # TODO: Change 'file_name' to pic
    # TODO: Rename files based on unique id
    try:
        # If PIL is available, try testing PIL.
        # Checking for the existence of Image is enough for CPython, but
        # for PyPy, you need to check for the underlying modules
        # If PIL is not available, this test is equivalent to TextFile above.
        from PIL import Image, _imaging
        image = models.ImageField(upload_to='images/%Y/%m/%d')
    except ImportError:
        image = models.FileField(upload_to='images/%Y/%m/%d')
#    image_field = models.ImageField(upload_to=IMAGES_ROOT) #, storage=FS) #'photos/%Y/%m/%d')

    def __unicode__(self):
        return (str(self.id) + ', ' + str(self.journal_entry) + ', url = ' + self.image.url + ', path = ' + self.image.path)
