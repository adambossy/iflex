function processJavascript() {
	jsonObj = json.stringify({'a':1,'b':2});
	out = Document.getElementById("out");
	out.innerHTML("json:"+jsonObj);
		
//		wt = WorkoutTemplate
//			.fromJSONString("{\"pk\": 1, \"model\": \"template_editor.workouttemplate\", \"fields\": {\"position\": 2, \"author\": 1, \"name\": \"null\", \"collection\": null, \"description\": null}}");
//        return eval('(' + jsonString + ')');
}