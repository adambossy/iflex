package com.healthySoftware.client.util.models.template_editor;

import com.google.gwt.core.client.JavaScriptObject;

import com.healthySoftware.client.util.models.template_editor.WorkoutTemplate;
import com.healthySoftware.client.util.models.exercises.ExerciseType;
import com.healthySoftware.client.util.models.template_editor.ExerciseTemplate;


public class LiftTemplate extends JavaScriptObject {

    protected LiftTemplate() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    final public static native LiftTemplate fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;


    final public native WorkoutTemplate getWorkoutTemplate() /*-{
        return this.fields.workout_template;
    }-*/;

    final public native void setWorkoutTemplate(WorkoutTemplate workout_template) /*-{
        this.fields.workout_template = workout_template;
    }-*/;

    final public native ExerciseTemplate getExerciseTemplate() /*-{
        return this.fields.exercise_template;
    }-*/;

    final public native void setExerciseTemplate(ExerciseTemplate exercise_template) /*-{
        this.fields.exercise_template = exercise_template;
    }-*/;

    final public native int getPk() /*-{
        return this.pk;
    }-*/;

    final public native void setPk(int pk) /*-{
        this.pk = pk;
    }-*/;

    final public native ExerciseType getType() /*-{
        return this.fields.type;
    }-*/;

    final public native void setType(ExerciseType type) /*-{
        this.fields.type = type;
    }-*/;

    final public native int getId() /*-{
        return this.fields.id;
    }-*/;

    final public native void setId(int id) /*-{
        this.fields.id = id;
    }-*/;

    final public native String getRest() /*-{
        return this.fields.rest;
    }-*/;

    final public native void setRest(String rest) /*-{
        this.fields.rest = rest;
    }-*/;

    /* TODO: Add these functions to the Django generator somehow */
	final public RepsTemplateList getRepsTemplateList() {
		return new RepsTemplateList(getRepsTemplateJsni());
	}
    
	final private native JavaScriptObject getRepsTemplateJsni() /*-{
		return this.fields.RepsTemplate;
	}-*/;
}
