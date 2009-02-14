package com.healthySoftware.client.util.models.workout;

import com.google.gwt.core.client.JavaScriptObject;

import com.healthySoftware.client.util.models.workout.Workout;
import com.healthySoftware.client.util.models.exercises.ExerciseType;
import com.healthySoftware.client.util.models.workout.Exercise;


public class Cardio extends JavaScriptObject {

    protected Cardio() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    public static native Cardio fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;


    final public native float getDist() /*-{
        return this.fields.dist;
    }-*/;

    final public native void setDist(float dist) /*-{
        this.fields.dist = dist;
    }-*/;

    final public native int getTime() /*-{
        return this.fields.time;
    }-*/;

    final public native void setTime(int time) /*-{
        this.fields.time = time;
    }-*/;

    final public native String getUnits() /*-{
        return this.fields.units;
    }-*/;

    final public native void setUnits(String units) /*-{
        this.fields.units = units;
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

    final public native Exercise getExercise() /*-{
        return this.fields.exercise;
    }-*/;

    final public native void setExercise(Exercise exercise) /*-{
        this.fields.exercise = exercise;
    }-*/;

}
