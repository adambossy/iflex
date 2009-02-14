package com.healthySoftware.client.util.models.template_editor;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

public class LiftTemplateList /*extends JavaScriptObject*/ {

	LiftTemplate[] liftTemplateList;

//	public LiftTemplateList(String jsonString) {
	public LiftTemplateList(JavaScriptObject jsObj) {
//    	JSONArray jsonArray = JSONParser.parse(jsonString).isArray();
		JSONArray jsonArray = new JSONArray(jsObj);
		LiftTemplate[] liftTemplateList = new LiftTemplate[jsonArray.size()];
    	for (int i = 0; i < jsonArray.size(); i++) {
    		liftTemplateList[i] = jsonArray.get(i).isObject().getJavaScriptObject().cast();
    	}
    	this.liftTemplateList = liftTemplateList; 
	}
    
    public LiftTemplate get(int index) {
    	return this.liftTemplateList[index]; 
    }
    
    public int length() {
    	return this.liftTemplateList.length;
    }
    
    /** TDDO: This would ideally be a collection */
    public LiftTemplate[] getList() {
    	return this.liftTemplateList;
    }
    
//	final public LiftTemplateList getLiftTemplateList() {
//		return LiftTemplateList.fromJSONArrayJsni(getLiftTemplateJsni(, this);
//	}
		
    public static native LiftTemplateList fromJSONArrayJsni(String jsonString) /*-{
    	var jsonArray = eval('(' + jsonString + ')');
    	var liftTemplateList = new Array();
    	for (var i = 0; i < jsonArray.length; i++) {
    		// Call non-native LiftTemplate factory method: LiftTemplate.fromJSONString(jsonString)
			liftTemplateList[i] = @com.healthySoftware.client.util.models.template_editor.LiftTemplate::fromJSONString(Ljava/lang/String;)(jsonArray[i]);
    	}
    	return jsonArray;
    }-*/;

}