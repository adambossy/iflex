package com.healthySoftware.client.util.models.members;

import com.google.gwt.core.client.JavaScriptObject;



public class Member extends JavaScriptObject {

    protected Member() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    public static native Member fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;


    final public native int getWeight() /*-{
        return this.fields.weight;
    }-*/;

    final public native void setWeight(int weight) /*-{
        this.fields.weight = weight;
    }-*/;

    final public native String getFirstname() /*-{
        return this.fields.firstName;
    }-*/;

    final public native void setFirstname(String firstName) /*-{
        this.fields.firstName = firstName;
    }-*/;

    final public native String getLastname() /*-{
        return this.fields.lastName;
    }-*/;

    final public native void setLastname(String lastName) /*-{
        this.fields.lastName = lastName;
    }-*/;

    final public native int getPk() /*-{
        return this.pk;
    }-*/;

    final public native void setPk(int pk) /*-{
        this.pk = pk;
    }-*/;

    final public native int getAge() /*-{
        return this.fields.age;
    }-*/;

    final public native void setAge(int age) /*-{
        this.fields.age = age;
    }-*/;

    final public native String getPassword() /*-{
        return this.fields.password;
    }-*/;

    final public native void setPassword(String password) /*-{
        this.fields.password = password;
    }-*/;

    final public native int getId() /*-{
        return this.fields.id;
    }-*/;

    final public native void setId(int id) /*-{
        this.fields.id = id;
    }-*/;

    final public native int getHeight() /*-{
        return this.fields.height;
    }-*/;

    final public native void setHeight(int height) /*-{
        this.fields.height = height;
    }-*/;

}
