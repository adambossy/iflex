package com.healthySoftware.client.util.models.contenttypes;

import com.google.gwt.core.client.JavaScriptObject;



public class ContentType extends JavaScriptObject {

    protected ContentType() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    public static native ContentType fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;


    final public native int getPk() /*-{
        return this.pk;
    }-*/;

    final public native void setPk(int pk) /*-{
        this.pk = pk;
    }-*/;

    final public native String getModel() /*-{
        return this.fields.model;
    }-*/;

    final public native void setModel(String model) /*-{
        this.fields.model = model;
    }-*/;

    final public native String getAppLabel() /*-{
        return this.fields.app_label;
    }-*/;

    final public native void setAppLabel(String app_label) /*-{
        this.fields.app_label = app_label;
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
