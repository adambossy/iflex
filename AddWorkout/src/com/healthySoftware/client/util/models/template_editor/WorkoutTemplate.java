package com.healthySoftware.client.util.models.template_editor;

import com.google.gwt.core.client.JavaScriptObject;

import com.healthySoftware.client.util.models.members.Member;
import com.healthySoftware.client.util.models.template_editor.TemplateCollection;


public class WorkoutTemplate extends JavaScriptObject {

    protected WorkoutTemplate() {
    }

    /**
     * Factory method to generate this overlay from a JavaScript-compatible JSON String
     * Taken from the tech talk, "GWT and Client-Server Communication", by Miguel Mendez
     * http://sites.google.com/site/io/gwt-and-client-server-communication
     */
    final public static native WorkoutTemplate fromJSONString(
            JavaScriptObject jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;

    final public static native WorkoutTemplate fromJavaScriptObject(
            JavaScriptObject javaScriptObject) /*-{
        alert("In fromJavaScriptObject(\"" + javaScriptObject + "\")");
        return javaScriptObject;
    }-*/;

    final public native String getName() /*-{
        return this.fields.name;
    }-*/;

    final public native void setName(String name) /*-{
        this.fields.name = name;
    }-*/;

    final public native int getPosition() /*-{
        return this.fields.position;
    }-*/;

    final public native void setPosition(int position) /*-{
        this.fields.position = position;
    }-*/;

    final public native int getPk() /*-{
        return this.pk;
    }-*/;

    final public native void setPk(int pk) /*-{
        this.pk = pk;
    }-*/;

    final public native Member getAuthor() /*-{
        return this.fields.author;
    }-*/;

    final public native void setAuthor(Member author) /*-{
        this.fields.author = author;
    }-*/;

    final public native int getId() /*-{
        return this.fields.id;
    }-*/;

    final public native void setId(int id) /*-{
        this.fields.id = id;
    }-*/;

    final public native TemplateCollection getCollection() /*-{
        return this.fields.collection;
    }-*/;

    final public native void setCollection(TemplateCollection collection) /*-{
        this.fields.collection = collection;
    }-*/;

    final public native String getDescription() /*-{
        return this.fields.description;
    }-*/;

    final public native void setDescription(String description) /*-{
        this.fields.description = description;
    }-*/;
    
    final public native ExerciseTemplate getExerciseTemplate() /*-{
	    return this.fields.ExerciseTemplate;
	}-*/;
	
	final public native void setExerciseTemplate(ExerciseTemplate exerciseTemplate) /*-{
	    this.fields.ExerciseTemplate = exerciseTemplate;
	}-*/;

	final public LiftTemplateList getLiftTemplateList() {
//		return LiftTemplateList.fromJSONArrayJsni(getLiftTemplateJsni());
		return new LiftTemplateList(getLiftTemplateJsni());
	}
	
	final private native JavaScriptObject getLiftTemplateJsni() /*-{
		return this.fields.LiftTemplate;
	}-*/;
	
	final public native void setLiftTemplate(LiftTemplate liftTemplate) /*-{
		this.fields.LiftTemplate = liftTemplate;
	}-*/;
}
