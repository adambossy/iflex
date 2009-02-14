package com.healthySoftware.client.util.models.template_editor;

import com.google.gwt.core.client.JavaScriptObject;

import com.healthySoftware.client.util.models.template_editor.LiftTemplate;


public class RepsTemplate extends JavaScriptObject {

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


    final public native int getPk() /*-{
        return this.pk;
    }-*/;

    final public native void setPk(int pk) /*-{
        this.pk = pk;
    }-*/;

    final public native boolean getWork() /*-{
        return this.fields.work;
    }-*/;

    final public native void setWork(boolean work) /*-{
        this.fields.work = work;
    }-*/;

    final public native String getReps() /*-{
        return this.fields.reps;
    }-*/;

    final public native void setReps(String reps) /*-{
        this.fields.reps = reps;
    }-*/;

    final public native int getId() /*-{
        return this.fields.id;
    }-*/;

    final public native void setId(int id) /*-{
        this.fields.id = id;
    }-*/;

    final public native LiftTemplate getLiftTemplate() /*-{
        return this.fields.lift_template;
    }-*/;

    final public native void setLiftTemplate(LiftTemplate lift_template) /*-{
        this.fields.lift_template = lift_template;
    }-*/;
    
}
