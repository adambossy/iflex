package com.healthySoftware.client.util.models.template_editor;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

public class RepsTemplateList /*extends JavaScriptObject*/ {

	RepsTemplate[] repsTemplateList;

	public RepsTemplateList(JavaScriptObject jsObj) {
//    	JSONArray jsonArray = JSONParser.parse(jsonString).isArray();
		JSONArray jsonArray = new JSONArray(jsObj);
		RepsTemplate[] repsTemplateList = new RepsTemplate[jsonArray.size()];
    	for (int i = 0; i < jsonArray.size(); i++) {
    		repsTemplateList[i] = jsonArray.get(i).isObject().getJavaScriptObject().cast();
    	}
    	this.repsTemplateList = repsTemplateList; 
	}
	
	/* TODO: Make a superclass method that abstracts these to remove repetition */    
    public RepsTemplate get(int index) {
    	return this.repsTemplateList[index]; 
    }
    
    public int length() {
    	return this.repsTemplateList.length;
    }
    
    /* TDDO: This would ideally be a collection */
    public RepsTemplate[] getList() {
    	return this.repsTemplateList;
    }
}