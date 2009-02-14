package com.healthySoftware.client.util.models.exercises;

import com.google.gwt.core.client.JavaScriptObject;

import com.healthySoftware.client.util.models.members.Member;
import java.util.Date;
import com.healthySoftware.client.util.models.exercises.ExerciseType;
import com.healthySoftware.client.util.models.muscles.MuscleEntity;


public class ExerciseType extends JavaScriptObject {

    protected ExerciseType() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    public static native ExerciseType fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;


    final public native MuscleEntity getSecondaryMuscle() /*-{
        return this.fields.secondary_muscle;
    }-*/;

    final public native void setSecondaryMuscle(MuscleEntity secondary_muscle) /*-{
        this.fields.secondary_muscle = secondary_muscle;
    }-*/;

    final public native String getName() /*-{
        return this.fields.name;
    }-*/;

    final public native void setName(String name) /*-{
        this.fields.name = name;
    }-*/;

    final public native ExerciseType getParent() /*-{
        return this.fields.parent;
    }-*/;

    final public native void setParent(ExerciseType parent) /*-{
        this.fields.parent = parent;
    }-*/;

    final public native Date getTimeCreated() /*-{
        return this.fields.time_created;
    }-*/;

    final public native void setTimeCreated(Date time_created) /*-{
        this.fields.time_created = time_created;
    }-*/;

    final public native int getPk() /*-{
        return this.pk;
    }-*/;

    final public native void setPk(int pk) /*-{
        this.pk = pk;
    }-*/;

    final public native Member getCreatedBy() /*-{
        return this.fields.created_by;
    }-*/;

    final public native void setCreatedBy(Member created_by) /*-{
        this.fields.created_by = created_by;
    }-*/;

    final public native int getType() /*-{
        return this.fields.type;
    }-*/;

    final public native void setType(int type) /*-{
        this.fields.type = type;
    }-*/;

    final public native int getId() /*-{
        return this.fields.id;
    }-*/;

    final public native void setId(int id) /*-{
        this.fields.id = id;
    }-*/;

    final public native MuscleEntity getPrimaryMuscle() /*-{
        return this.fields.primary_muscle;
    }-*/;

    final public native void setPrimaryMuscle(MuscleEntity primary_muscle) /*-{
        this.fields.primary_muscle = primary_muscle;
    }-*/;

}
