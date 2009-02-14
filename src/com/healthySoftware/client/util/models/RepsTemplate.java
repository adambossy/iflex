package com.healthySoftware.client.util.models;
import com.google.gwt.core.client.JavaScriptObject;

class RepsTemplate extends JavaScriptObject {

    private String name;
    private None exercise_template;
    private None author;
    private String notes;
    private boolean work;
    private String reps;
    private None collection;
    private None lift_template;
    private String rest;
    private None workout_template;
    private int position;
    private None type;
    private int id;
    private String description;

    protected RepsTemplate() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    public static native RepsTemplate fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;


    public String getName() /*-{
        return this.name;
    }-*/

    public void setName(String name) /*-{
        this.name = name;
    }-*/

    public None getExerciseTemplate() /*-{
        return this.exercise_template;
    }-*/

    public void setExerciseTemplate(None exercise_template) /*-{
        this.exercise_template = exercise_template;
    }-*/

    public None getAuthor() /*-{
        return this.author;
    }-*/

    public void setAuthor(None author) /*-{
        this.author = author;
    }-*/

    public String getNotes() /*-{
        return this.notes;
    }-*/

    public void setNotes(String notes) /*-{
        this.notes = notes;
    }-*/

    public boolean getWork() /*-{
        return this.work;
    }-*/

    public void setWork(boolean work) /*-{
        this.work = work;
    }-*/

    public String getReps() /*-{
        return this.reps;
    }-*/

    public void setReps(String reps) /*-{
        this.reps = reps;
    }-*/

    public None getCollection() /*-{
        return this.collection;
    }-*/

    public void setCollection(None collection) /*-{
        this.collection = collection;
    }-*/

    public None getLiftTemplate() /*-{
        return this.lift_template;
    }-*/

    public void setLiftTemplate(None lift_template) /*-{
        this.lift_template = lift_template;
    }-*/

    public String getRest() /*-{
        return this.rest;
    }-*/

    public void setRest(String rest) /*-{
        this.rest = rest;
    }-*/

    public None getWorkoutTemplate() /*-{
        return this.workout_template;
    }-*/

    public void setWorkoutTemplate(None workout_template) /*-{
        this.workout_template = workout_template;
    }-*/

    public int getPosition() /*-{
        return this.position;
    }-*/

    public void setPosition(int position) /*-{
        this.position = position;
    }-*/

    public None getType() /*-{
        return this.type;
    }-*/

    public void setType(None type) /*-{
        this.type = type;
    }-*/

    public int getId() /*-{
        return this.id;
    }-*/

    public void setId(int id) /*-{
        this.id = id;
    }-*/

    public String getDescription() /*-{
        return this.description;
    }-*/

    public void setDescription(String description) /*-{
        this.description = description;
    }-*/

}
