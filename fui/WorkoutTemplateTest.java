package com.healthySoftware.client.util.services.tests;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.healthySoftware.client.util.models.template_editor.WorkoutTemplate;
import junit.framework.*;

public class WorkoutTemplateTest extends TestCase {

//	public static void main(String[] args) {
//		WorkoutTemplateTest();
//	}

	public WorkoutTemplateTest() {
		super();
	}
	
	public void testWorkoutTemplate() {
		WorkoutTemplate wt; 

		wt = WorkoutTemplate
			.fromJSONString("{'pk': 1}"); 
//		wt = WorkoutTemplate
//			.fromJSONString("[{'pk': 1, 'model': 'template_editor.workouttemplate', 'fields': {'name': 'null', 'author': 1, 'ExerciseTemplate': [{'pk': 6, 'model': 'template_editor.exercisetemplate', 'fields': {'position': 0, 'notes': '', 'workout_template': 1}}, {'pk': 7, 'model': 'template_editor.exercisetemplate', 'fields': {'position': 1, 'notes': '', 'workout_template': 1}}], 'LiftTemplate': [{'pk': 6, 'model': 'template_editor.lifttemplate', 'fields': {'rest': '', 'type': 2, 'exercise_template': 6, 'workout_template': 1, 'RepsTemplate': [{'pk': 17, 'model': 'template_editor.repstemplate', 'fields': {'work': false, 'reps': '', 'lift_template': 6}}, {'pk': 18, 'model': 'template_editor.repstemplate', 'fields': {'work': true, 'reps': '', 'lift_template': 6}}]}}, {'pk': 7, 'model': 'template_editor.lifttemplate', 'fields': {'rest': '', 'type': 3, 'exercise_template': 7, 'workout_template': 1, 'RepsTemplate': [{'pk': 19, 'model': 'template_editor.repstemplate', 'fields': {'work': false, 'reps': '', 'lift_template': 7}}, {'pk': 20, 'model': 'template_editor.repstemplate', 'fields': {'work': true, 'reps': '', 'lift_template': 7}}]}}], 'collection': null, 'position': 2, 'description': null}}]");
//		wt = WorkoutTemplate
//			.fromJSONString("[{'pk': 1, 'model': 'template_editor.workouttemplate', 'fields': {'name': 'null', 'author': 1, 'ExerciseTemplate': [{'pk': 6, 'model': 'template_editor.exercisetemplate', 'fields': {'position': 0, 'notes': '', 'workout_template': 1}}, {'pk': 7, 'model': 'template_editor.exercisetemplate', 'fields': {'position': 1, 'notes': '', 'workout_template': 1}}], 'LiftTemplate': [{'pk': 6, 'model': 'template_editor.lifttemplate', 'fields': {'rest': '', 'type': 2, 'exercise_template': 6, 'workout_template': 1, 'RepsTemplate': [{'pk': 17, 'model': 'template_editor.repstemplate', 'fields': {'work': false, 'reps': '', 'lift_template': 6}}, {'pk': 18, 'model': 'template_editor.repstemplate', 'fields': {'work': true, 'reps': '', 'lift_template': 6}}]}}, {'pk': 7, 'model': 'template_editor.lifttemplate', 'fields': {'rest': '', 'type': 3, 'exercise_template': 7, 'workout_template': 1, 'RepsTemplate': [{'pk': 19, 'model': 'template_editor.repstemplate', 'fields': {'work': false, 'reps': '', 'lift_template': 7}}, {'pk': 20, 'model': 'template_editor.repstemplate', 'fields': {'work': true, 'reps': '', 'lift_template': 7}}]}}], 'collection': null, 'position': 2, 'description': null}}]");
//		wt = WorkoutTemplate
//				.fromJSONString("[{'pk': 1, 'model': 'template_editor.workouttemplate', 'fields': {'name': 'null', 'author': 1, 'ExerciseTemplate': [{'pk': 6, 'model': 'template_editor.exercisetemplate', 'fields': {'position': 0, 'notes': '', 'workout_template': 1}}, {'pk': 7, 'model': 'template_editor.exercisetemplate', 'fields': {'position': 1, 'notes': '', 'workout_template': 1}}], 'LiftTemplate': [{'pk': 6, 'model': 'template_editor.lifttemplate', 'fields': {'rest': '', 'type': 2, 'exercise_template': 6, 'workout_template': 1, 'RepsTemplate': [{'pk': 17, 'model': 'template_editor.repstemplate', 'fields': {'work': false, 'reps': '', 'lift_template': 6}}, {'pk': 18, 'model': 'template_editor.repstemplate', 'fields': {'work': true, 'reps': '', 'lift_template': 6}}]}}, {'pk': 7, 'model': 'template_editor.lifttemplate', 'fields': {'rest': '', 'type': 3, 'exercise_template': 7, 'workout_template': 1, 'RepsTemplate': [{'pk': 19, 'model': 'template_editor.repstemplate', 'fields': {'work': false, 'reps': '', 'lift_template': 7}}, {'pk': 20, 'model': 'template_editor.repstemplate', 'fields': {'work': true, 'reps': '', 'lift_template': 7}}]}}], 'collection': null, 'position': 2, 'description': null}}]");

		Assert.assertEquals(wt.getPk(), "1");

		JSONObject jo = JSONParser.parse(
				"{\"pk\": 1, \"model\": \"template_editor.workouttemplate\", \"fields\": {\"name\": \"null\", \"author\": 1, \"ExerciseTemplate\": [{\"pk\": 6, \"model\": \"template_editor.exercisetemplate\", \"fields\": {\"position\": 0, \"notes\": \"\", \"workout_template\": 1}}, {\"pk\": 7, \"model\": \"template_editor.exercisetemplate\", \"fields\": {\"position\": 1, \"notes\": \"\", \"workout_template\": 1}}], \"LiftTemplate\": [{\"pk\": 6, \"model\": \"template_editor.lifttemplate\", \"fields\": {\"rest\": \"\", \"type\": 2, \"exercise_template\": 6, \"workout_template\": 1, \"RepsTemplate\": [{\"pk\": 17, \"model\": \"template_editor.repstemplate\", \"fields\": {\"work\": false, \"reps\": \"\", \"lift_template\": 6}}, {\"pk\": 18, \"model\": \"template_editor.repstemplate\", \"fields\": {\"work\": true, \"reps\": \"\", \"lift_template\": 6}}]}}, {\"pk\": 7, \"model\": \"template_editor.lifttemplate\", \"fields\": {\"rest\": \"\", \"type\": 3, \"exercise_template\": 7, \"workout_template\": 1, \"RepsTemplate\": [{\"pk\": 19, \"model\": \"template_editor.repstemplate\", \"fields\": {\"work\": false, \"reps\": \"\", \"lift_template\": 7}}, {\"pk\": 20, \"model\": \"template_editor.repstemplate\", \"fields\": {\"work\": true, \"reps\": \"\", \"lift_template\": 7}}]}}], \"collection\": null, \"position\": 2, \"description\": null}}]").
						isObject();

		Assert.assertEquals(jo.get("pk"), "1");
//		Assert.assertEquals(wt.getPk(), 1);
//		Assert.assertEquals(wt.getName(), null);
//		Assert.assertEquals(wt.getAuthor(), 1);
//		Assert.assertEquals(wt.getCollection(), null);
//		Assert.assertEquals(wt.getPosition(), 2);
//		Assert.assertEquals(wt.getDescription(), null);
	}

}