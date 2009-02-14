package com.healthySoftware.client.util.models.template_editor;

import com.google.gwt.core.client.JavaScriptObject;

import com.healthySoftware.client.util.models.members.Member;


public class TemplateCollection extends JavaScriptObject {

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


    final public native int getPk() /*-{
        return this.pk;
    }-*/;

    final public native void setPk(int pk) /*-{
        this.pk = pk;
    }-*/;

    final public native Member getAuthor() /*-{
        return this.fields.author;
    }-*/;

    final public native void setAuthor(Member author) /*-{
        this.fields.author = author;
    }-*/;

    final public native int getId() /*-{
        return this.fields.id;
    }-*/;

    final public native void setId(int id) /*-{
        this.fields.id = id;
    }-*/;

    final public native String getName() /*-{
        return this.fields.name;
    }-*/;

    final public native void setName(String name) /*-{
        this.fields.name = name;
    }-*/;

}
