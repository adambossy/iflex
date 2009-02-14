package com.healthySoftware.client.util.models.sessions;

import com.google.gwt.core.client.JavaScriptObject;

import java.util.Date;


public class Session extends JavaScriptObject {

    protected Session() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    public static native Session fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;


    final public native int getPk() /*-{
        return this.pk;
    }-*/;

    final public native void setPk(int pk) /*-{
        this.pk = pk;
    }-*/;

    final public native String getSessionKey() /*-{
        return this.fields.session_key;
    }-*/;

    final public native void setSessionKey(String session_key) /*-{
        this.fields.session_key = session_key;
    }-*/;

    final public native Date getExpireDate() /*-{
        return this.fields.expire_date;
    }-*/;

    final public native void setExpireDate(Date expire_date) /*-{
        this.fields.expire_date = expire_date;
    }-*/;

    final public native String getSessionData() /*-{
        return this.fields.session_data;
    }-*/;

    final public native void setSessionData(String session_data) /*-{
        this.fields.session_data = session_data;
    }-*/;

}
