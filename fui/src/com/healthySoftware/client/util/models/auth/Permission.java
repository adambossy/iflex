package com.healthySoftware.client.util.models.auth;

import com.google.gwt.core.client.JavaScriptObject;

import com.healthySoftware.client.util.models.contenttypes.ContentType;


public class Permission extends JavaScriptObject {

    protected Permission() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    public static native Permission fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;


    final public native int getPk() /*-{
        return this.pk;
    }-*/;

    final public native void setPk(int pk) /*-{
        this.pk = pk;
    }-*/;

    final public native String getCodename() /*-{
        return this.fields.codename;
    }-*/;

    final public native void setCodename(String codename) /*-{
        this.fields.codename = codename;
    }-*/;

    final public native int getId() /*-{
        return this.fields.id;
    }-*/;

    final public native void setId(int id) /*-{
        this.fields.id = id;
    }-*/;

    final public native ContentType getContentType() /*-{
        return this.fields.content_type;
    }-*/;

    final public native void setContentType(ContentType content_type) /*-{
        this.fields.content_type = content_type;
    }-*/;

    final public native String getName() /*-{
        return this.fields.name;
    }-*/;

    final public native void setName(String name) /*-{
        this.fields.name = name;
    }-*/;

}
