package com.healthySoftware.client.util.models.workout;

import com.google.gwt.core.client.JavaScriptObject;

import com.healthySoftware.client.util.models.workout.Workout;


public class Exercise extends JavaScriptObject {

    protected Exercise() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    public static native Exercise fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;


    final public native String getNotes() /*-{
        return this.fields.notes;
    }-*/;

    final public native void setNotes(String notes) /*-{
        this.fields.notes = notes;
    }-*/;

    final public native int getPosition() /*-{
        return this.fields.position;
    }-*/;

    final public native void setPosition(int position) /*-{
        this.fields.position = position;
    }-*/;

    final public native int getPk() /*-{
        return this.pk;
    }-*/;

    final public native void setPk(int pk) /*-{
        this.pk = pk;
    }-*/;

    final public native Workout getWorkout() /*-{
        return this.fields.workout;
    }-*/;

    final public native void setWorkout(Workout workout) /*-{
        this.fields.workout = workout;
    }-*/;

    final public native int getCalories() /*-{
        return this.fields.calories;
    }-*/;

    final public native void setCalories(int calories) /*-{
        this.fields.calories = calories;
    }-*/;

    final public native int getId() /*-{
        return this.fields.id;
    }-*/;

    final public native void setId(int id) /*-{
        this.fields.id = id;
    }-*/;

}
