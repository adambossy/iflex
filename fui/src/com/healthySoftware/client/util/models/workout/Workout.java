package com.healthySoftware.client.util.models.workout;

import com.google.gwt.core.client.JavaScriptObject;

import com.healthySoftware.client.util.models.members.Member;
import java.util.Date;


public class Workout extends JavaScriptObject {

    protected Workout() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    public static native Workout fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;


    final public native Member getMember() /*-{
        return this.fields.member;
    }-*/;

    final public native void setMember(Member member) /*-{
        this.fields.member = member;
    }-*/;

    final public native Date getDate() /*-{
        return this.fields.date;
    }-*/;

    final public native void setDate(Date date) /*-{
        this.fields.date = date;
    }-*/;

    final public native int getPk() /*-{
        return this.pk;
    }-*/;

    final public native void setPk(int pk) /*-{
        this.pk = pk;
    }-*/;

    final public native String getNotes() /*-{
        return this.fields.notes;
    }-*/;

    final public native void setNotes(String notes) /*-{
        this.fields.notes = notes;
    }-*/;

    final public native int getId() /*-{
        return this.fields.id;
    }-*/;

    final public native void setId(int id) /*-{
        this.fields.id = id;
    }-*/;

    final public native Date getTimeCreated() /*-{
        return this.fields.time_created;
    }-*/;

    final public native void setTimeCreated(Date time_created) /*-{
        this.fields.time_created = time_created;
    }-*/;

}
