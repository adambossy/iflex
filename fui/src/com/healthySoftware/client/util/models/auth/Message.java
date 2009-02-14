package com.healthySoftware.client.util.models.auth;

import com.google.gwt.core.client.JavaScriptObject;

import com.healthySoftware.client.util.models.auth.User;


public class Message extends JavaScriptObject {

    protected Message() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    public static native Message fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;


    final public native int getPk() /*-{
        return this.pk;
    }-*/;

    final public native void setPk(int pk) /*-{
        this.pk = pk;
    }-*/;

    final public native String getMessage() /*-{
        return this.fields.message;
    }-*/;

    final public native void setMessage(String message) /*-{
        this.fields.message = message;
    }-*/;

    final public native int getId() /*-{
        return this.fields.id;
    }-*/;

    final public native void setId(int id) /*-{
        this.fields.id = id;
    }-*/;

    final public native User getUser() /*-{
        return this.fields.user;
    }-*/;

    final public native void setUser(User user) /*-{
        this.fields.user = user;
    }-*/;

}
