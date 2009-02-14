package com.healthySoftware.client.util.models.admin;

import com.google.gwt.core.client.JavaScriptObject;

import java.util.Date;
import com.healthySoftware.client.util.models.contenttypes.ContentType;
import com.healthySoftware.client.util.models.auth.User;


public class LogEntry extends JavaScriptObject {

    protected LogEntry() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    public static native LogEntry fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;


    final public native int getActionFlag() /*-{
        return this.fields.action_flag;
    }-*/;

    final public native void setActionFlag(int action_flag) /*-{
        this.fields.action_flag = action_flag;
    }-*/;

    final public native Date getActionTime() /*-{
        return this.fields.action_time;
    }-*/;

    final public native void setActionTime(Date action_time) /*-{
        this.fields.action_time = action_time;
    }-*/;

    final public native String getChangeMessage() /*-{
        return this.fields.change_message;
    }-*/;

    final public native void setChangeMessage(String change_message) /*-{
        this.fields.change_message = change_message;
    }-*/;

    final public native User getUser() /*-{
        return this.fields.user;
    }-*/;

    final public native void setUser(User user) /*-{
        this.fields.user = user;
    }-*/;

    final public native ContentType getContentType() /*-{
        return this.fields.content_type;
    }-*/;

    final public native void setContentType(ContentType content_type) /*-{
        this.fields.content_type = content_type;
    }-*/;

    final public native int getPk() /*-{
        return this.pk;
    }-*/;

    final public native void setPk(int pk) /*-{
        this.pk = pk;
    }-*/;

    final public native String getObjectRepr() /*-{
        return this.fields.object_repr;
    }-*/;

    final public native void setObjectRepr(String object_repr) /*-{
        this.fields.object_repr = object_repr;
    }-*/;

    final public native int getId() /*-{
        return this.fields.id;
    }-*/;

    final public native void setId(int id) /*-{
        this.fields.id = id;
    }-*/;

    final public native String getObjectId() /*-{
        return this.fields.object_id;
    }-*/;

    final public native void setObjectId(String object_id) /*-{
        this.fields.object_id = object_id;
    }-*/;

}
