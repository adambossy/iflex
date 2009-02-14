package com.healthySoftware.client.util.models;
import com.google.gwt.core.client.JavaScriptObject;

class WorkoutTemplate extends JavaScriptObject {

    private String name;
    private None author;
    private int position;
    private int id;
    private None collection;
    private String description;

    protected WorkoutTemplate() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    public static native WorkoutTemplate fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;


    public String getName() /*-{
        return this.name;
    }-*/

    public void setName(String name) /*-{
        this.name = name;
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
