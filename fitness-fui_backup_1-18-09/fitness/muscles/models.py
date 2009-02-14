from django.db import models

# A MuscleEntity can be either a muscle group or an individual muscle. 
# Leafs are individual muscles and their ancestors (i.e., parents) 
# comprise various levels of groups.
class MuscleEntity (models.Model):

#     BODY_SEGMENT_CHOICES = (
#         ('0', 'Lower Body'),
#         ('1', 'Upper Body'),
#         )

#     body_segment = models.IntegerField(max_length=1, choices=BODY_SEGMENT_CHOICES)

    name = models.CharField(max_length=64)

    parent = models.ForeignKey('self', null=True, blank=True)

    lf = models.IntegerField(null=True, blank=True);

    rt = models.IntegerField(null=True, blank=True);

    primary = models.BooleanField()

    def __unicode__(self):
        return (self.name + ', ' + str(self.lf) + ', ' + str(self.rt) + ', ' + str(self.primary))

def init_rebuild_tree():
    # underscore denotes a "don't care" variable
    (_, max_node)=rebuild_tree(MuscleEntity.objects.get(id=1),1,0)
    print max_node
    rebuild_tree(MuscleEntity.objects.get(id=2),max_node+1,max_node)

def rebuild_tree(p, left, max_node):
    right=left+1
    muscle_entity_list = MuscleEntity.objects.filter(parent=p)
    for muscle_entity in muscle_entity_list:
        (right, max_node) = rebuild_tree(muscle_entity, right, max_node)
    p.lf=left
    p.rt=right
    p.save()
    return (right+1, max(max_node,right))

# ex: display_tree(MuscleEntity.objects.get(id=1))
def display_tree(root):
    right = []
    descendants = get_children(root)
    for muscle_entity in descendants:
        if len(right)>0:
#            print muscle_entity.name, ',', right, ': ', len(right)-1
            while (right[len(right)-1] < muscle_entity.rt):
                right.pop()
        print ('\t'*len(right))+muscle_entity.name
        right.append(muscle_entity.rt)

def get_children(parent):
    return MuscleEntity.objects.order_by('lf').filter(lf__range=(parent.lf, parent.rt))

# class Muscle (models.Model):

#     name = models.CharField(max_length=64)

#     muscle_group = models.ForeignKey(MuscleGroup)

#     def __unicode__(self):
#         return (str(self.id) + ', ' + self.name + ', ' + str(self.muscle_group) + '\n')
