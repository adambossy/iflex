package com.healthySoftware.client.util.models.journal;

import com.google.gwt.core.client.JavaScriptObject;

import com.healthySoftware.client.util.models.journal.JournalEntry;


public class Pic extends JavaScriptObject {

    protected Pic() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    public static native Pic fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
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

    final public native JournalEntry getJournalEntry() /*-{
        return this.fields.journal_entry;
    }-*/;

    final public native void setJournalEntry(JournalEntry journal_entry) /*-{
        this.fields.journal_entry = journal_entry;
    }-*/;

}
