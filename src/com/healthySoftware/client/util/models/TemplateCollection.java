package com.healthySoftware.client.util.models;
import com.google.gwt.core.client.JavaScriptObject;

class TemplateCollection extends JavaScriptObject {

    private None author;
    private int id;
    private String name;

    protected TemplateCollection() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    public static native TemplateCollection fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;


    public None getAuthor() /*-{
        return this.author;
    }-*/

    public void setAuthor(None author) /*-{
        this.author = author;
    }-*/

    public int getId() /*-{
        return this.id;
    }-*/

    public void setId(int id) /*-{
        this.id = id;
    }-*/

    public String getName() /*-{
        return this.name;
    }-*/

    public void setName(String name) /*-{
        this.name = name;
    }-*/

}
