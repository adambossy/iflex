package com.healthySoftware.client.util.models.template_editor;

import com.google.gwt.core.client.JavaScriptObject;

import com.healthySoftware.client.util.models.template_editor.WorkoutTemplate;


public class ExerciseTemplate extends JavaScriptObject {

    protected ExerciseTemplate() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    public static native ExerciseTemplate fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;


    final public native int getPk() /*-{
        return this.pk;
    }-*/;

    final public native void setPk(int pk) /*-{
        this.pk = pk;
    }-*/;

    final public native String getNotes() /*-{
        return this.fields.notes;
    }-*/;

    final public native void setNotes(String notes) /*-{
        this.fields.notes = notes;
    }-*/;

    final public native int getId() /*-{
        return this.fields.id;
    }-*/;

    final public native void setId(int id) /*-{
        this.fields.id = id;
    }-*/;

    final public native WorkoutTemplate getWorkoutTemplate() /*-{
        return this.fields.workout_template;
    }-*/;

    final public native void setWorkoutTemplate(WorkoutTemplate workout_template) /*-{
        this.fields.workout_template = workout_template;
    }-*/;

    final public native int getPosition() /*-{
        return this.fields.position;
    }-*/;

    final public native void setPosition(int position) /*-{
        this.fields.position = position;
    }-*/;

}
