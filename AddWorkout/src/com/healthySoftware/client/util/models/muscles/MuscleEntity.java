package com.healthySoftware.client.util.models.muscles;

import com.google.gwt.core.client.JavaScriptObject;

import com.healthySoftware.client.util.models.muscles.MuscleEntity;


public class MuscleEntity extends JavaScriptObject {

    protected MuscleEntity() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    public static native MuscleEntity fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;


    final public native int getLf() /*-{
        return this.fields.lf;
    }-*/;

    final public native void setLf(int lf) /*-{
        this.fields.lf = lf;
    }-*/;

    final public native int getRt() /*-{
        return this.fields.rt;
    }-*/;

    final public native void setRt(int rt) /*-{
        this.fields.rt = rt;
    }-*/;

    final public native String getName() /*-{
        return this.fields.name;
    }-*/;

    final public native void setName(String name) /*-{
        this.fields.name = name;
    }-*/;

    final public native MuscleEntity getParent() /*-{
        return this.fields.parent;
    }-*/;

    final public native void setParent(MuscleEntity parent) /*-{
        this.fields.parent = parent;
    }-*/;

    final public native int getPk() /*-{
        return this.pk;
    }-*/;

    final public native void setPk(int pk) /*-{
        this.pk = pk;
    }-*/;

    final public native int getId() /*-{
        return this.fields.id;
    }-*/;

    final public native void setId(int id) /*-{
        this.fields.id = id;
    }-*/;

    final public native boolean getPrimary() /*-{
        return this.fields.primary;
    }-*/;

    final public native void setPrimary(boolean primary) /*-{
        this.fields.primary = primary;
    }-*/;

}
