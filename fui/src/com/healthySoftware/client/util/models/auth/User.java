package com.healthySoftware.client.util.models.auth;

import com.google.gwt.core.client.JavaScriptObject;

import java.util.Date;


public class User extends JavaScriptObject {

    protected User() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    public static native User fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;


    final public native String getUsername() /*-{
        return this.fields.username;
    }-*/;

    final public native void setUsername(String username) /*-{
        this.fields.username = username;
    }-*/;

    final public native String getFirstName() /*-{
        return this.fields.first_name;
    }-*/;

    final public native void setFirstName(String first_name) /*-{
        this.fields.first_name = first_name;
    }-*/;

    final public native String getLastName() /*-{
        return this.fields.last_name;
    }-*/;

    final public native void setLastName(String last_name) /*-{
        this.fields.last_name = last_name;
    }-*/;

    final public native boolean getIsActive() /*-{
        return this.fields.is_active;
    }-*/;

    final public native void setIsActive(boolean is_active) /*-{
        this.fields.is_active = is_active;
    }-*/;

    final public native String getEmail() /*-{
        return this.fields.email;
    }-*/;

    final public native void setEmail(String email) /*-{
        this.fields.email = email;
    }-*/;

    final public native boolean getIsSuperuser() /*-{
        return this.fields.is_superuser;
    }-*/;

    final public native void setIsSuperuser(boolean is_superuser) /*-{
        this.fields.is_superuser = is_superuser;
    }-*/;

    final public native boolean getIsStaff() /*-{
        return this.fields.is_staff;
    }-*/;

    final public native void setIsStaff(boolean is_staff) /*-{
        this.fields.is_staff = is_staff;
    }-*/;

    final public native Date getLastLogin() /*-{
        return this.fields.last_login;
    }-*/;

    final public native void setLastLogin(Date last_login) /*-{
        this.fields.last_login = last_login;
    }-*/;

    final public native int getPk() /*-{
        return this.pk;
    }-*/;

    final public native void setPk(int pk) /*-{
        this.pk = pk;
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

    final public native Date getDateJoined() /*-{
        return this.fields.date_joined;
    }-*/;

    final public native void setDateJoined(Date date_joined) /*-{
        this.fields.date_joined = date_joined;
    }-*/;

}
