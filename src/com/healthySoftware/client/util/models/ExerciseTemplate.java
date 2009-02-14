package com.healthySoftware.client.util.models;
import com.google.gwt.core.client.JavaScriptObject;

class ExerciseTemplate extends JavaScriptObject {

    private String name;
    private None workout_template;
    private None author;
    private int position;
    private String notes;
    private int id;
    private None collection;
    private String description;

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


    public String getName() /*-{
        return this.name;
    }-*/

    public void setName(String name) /*-{
        this.name = name;
    }-*/

    public None getWorkoutTemplate() /*-{
        return this.workout_template;
    }-*/

    public void setWorkoutTemplate(None workout_template) /*-{
        this.workout_template = workout_template;
    }-*/

    public None getAuthor() /*-{
        return this.author;
    }-*/

    public void setAuthor(None author) /*-{
        this.author = author;
    }-*/

    public int getPosition() /*-{
        return this.position;
    }-*/

    public void setPosition(int position) /*-{
        this.position = position;
    }-*/

    public String getNotes() /*-{
        return this.notes;
    }-*/

    public void setNotes(String notes) /*-{
        this.notes = notes;
    }-*/

    public int getId() /*-{
        return this.id;
    }-*/

    public void setId(int id) /*-{
        this.id = id;
    }-*/

    public None getCollection() /*-{
        return this.collection;
    }-*/

    public void setCollection(None collection) /*-{
        this.collection = collection;
    }-*/

    public String getDescription() /*-{
        return this.description;
    }-*/

    public void setDescription(String description) /*-{
        this.description = description;
    }-*/

}
