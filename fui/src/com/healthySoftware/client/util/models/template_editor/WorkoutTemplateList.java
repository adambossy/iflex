package com.healthySoftware.client.util.models.template_editor;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;

public class WorkoutTemplateList /*extends JavaScriptObject*/ {

	// TODO: What to do about internal ForeignKey references? Can we cast these as Java objects? Should we keep
	// a partial JsonObject with typical JSON information and Java objects with the ForeignKey references? Should
	// we write all of this in JavaScript and cast it somehow (probably the best approach)?
	
	WorkoutTemplate[] workoutTemplateList;
/*	
    protected WorkoutTemplateList() {
    }
*/
	public WorkoutTemplateList(String jsonString) {
    	JSONArray jsonArray = JSONParser.parse(jsonString).isArray();
		WorkoutTemplate[] workoutTemplateList = new WorkoutTemplate[jsonArray.size()];
    	for (int i = 0; i < jsonArray.size(); i++) {
    		workoutTemplateList[i] = jsonArray.get(i).isObject().getJavaScriptObject().cast();
    	}
    	this.workoutTemplateList = workoutTemplateList; 
	}
    
    public WorkoutTemplate get(int index) {
    	return this.workoutTemplateList[index]; 
    }
    
    public static native WorkoutTemplateList fromJSONArrayJsni(String jsonString) /*-{
    	var jsonArray = eval('(' + jsonString + ')');
    	var workoutTemplateList = new Array();
    	for (var i = 0; i < jsonArray.length; i++) {
    		// Call non-native WorkoutTemplate factory method: WorkoutTemplate.fromJSONString(jsonString)
			workoutTemplateList[i] = handler.@com.healthySoftware.client.util.models.template_editor.WorkoutTemplate::fromJSONString(Ljava/lang/String;)(jsonArray[i]);
    	}
    	return jsonArray;
    }-*/;
    
//    public WorkoutTemplate getWorkoutTemplateFromJson(String jsonString) {
//    	return WorkoutTemplate.fromJSONString(jsonString);
//    }
}

/*
public static WorkoutTemplate[] generateList(String jsonString) { 
	String json = "[{\"pk\": 1, \"model\": \"template_editor.workouttemplate\", \"fields\": {\"position\": 2, \"author\": 1, \"name\": \"null\", \"collection\": null, \"description\": null}}]";
//	JavaScriptObject jsObj = evaluate(json);
//	JavaScriptObject jsonArray = JavaScriptObject.createArray();
	JSONArray jsonArray = JSONParser.parse(json).isArray();
	WorkoutTemplate[] wtList = new WorkoutTemplate[jsonArray.size()];
	for (int i = 0; i < jsonArray.size(); i++) {
//		wtList[i] = new WorkoutTemplate(jsonArray.get(i).isObject().getJavaScriptObject().cast<WorkoutTemplate>());
		wtList[i] = jsonArray.get(i).isObject().getJavaScriptObject().cast();
	}
	return wtList;
};
*/
