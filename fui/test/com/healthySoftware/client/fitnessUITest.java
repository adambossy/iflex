package com.healthySoftware.client;

import junit.framework.Assert;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.junit.client.GWTTestCase;
import com.healthySoftware.client.util.models.template_editor.WorkoutTemplate;
import com.healthySoftware.client.util.models.template_editor.WorkoutTemplateList;

/**
 * GWT JUnit tests must extend GWTTestCase.
 */
public class fitnessUITest extends GWTTestCase {

  /**
   * Must refer to a valid module that sources this class.
   */
  public String getModuleName() {
    return "com.healthySoftware.fitnessUI";
  }

  /**
   * Add as many tests as you like.
   */
  public void testSimple() {
    assertTrue(true);
  }
  
	public void testWorkoutTemplate() {
		WorkoutTemplate wt; 
		WorkoutTemplateList wtList;
		
		wt = WorkoutTemplate
			.fromJSONString("{'pk': 1}"); 

		Assert.assertEquals(wt.getPk(), 1);

		wt = WorkoutTemplate
			.fromJSONString("{\"pk\": 1, \"model\": \"template_editor.workouttemplate\", \"fields\": {\"position\": 2, \"author\": 1, \"name\": \"null\", \"collection\": null, \"description\": null}}");
		
		Assert.assertEquals(wt.getPk(), 1);
		Assert.assertEquals(wt.getName(), "null");
//		Assert.assertEquals(wt.getAuthor(), 1);
//		Assert.assertEquals(wt.getCollection(), null);
//		Assert.assertEquals(wt.getPosition(), 2);
//		Assert.assertEquals(wt.getDescription(), null);

		wt.setPk(2);
		Assert.assertEquals(wt.getPk(), 2);
		
		wtList = new WorkoutTemplateList("[{\"pk\": 1, \"model\": \"template_editor.workouttemplate\", \"fields\": {\"position\": 2, \"author\": 1, \"name\": \"null\", \"collection\": null, \"description\": null}}]");

		System.out.println("wtList: " + wtList);
		
		Assert.assertEquals(wtList.get(0).getPk(), 1);
		Assert.assertEquals(wtList.get(0).getName(), null);
//		Assert.assertEquals(wtList.get(0).getAuthor(), 1);
		Assert.assertEquals(wtList.get(0).getCollection(), null);
		Assert.assertEquals(wtList.get(0).getPosition(), 2);
		Assert.assertEquals(wtList.get(0).getDescription(), null);

		//wtList = WorkoutTemplateList
		//	.fromJSONString("[{\"pk\": 1, \"model\": \"template_editor.workouttemplate\", \"fields\": {\"position\": 2, \"author\": 1, \"name\": \"null\", \"collection\": null, \"description\": null}}]");
//		wt = WorkoutTemplate
//			.fromJSONString("[{'pk': 1, 'model': 'template_editor.workouttemplate', 'fields': {'name': 'null', 'author': 1, 'ExerciseTemplate': [{'pk': 6, 'model': 'template_editor.exercisetemplate', 'fields': {'position': 0, 'notes': '', 'workout_template': 1}}, {'pk': 7, 'model': 'template_editor.exercisetemplate', 'fields': {'position': 1, 'notes': '', 'workout_template': 1}}], 'LiftTemplate': [{'pk': 6, 'model': 'template_editor.lifttemplate', 'fields': {'rest': '', 'type': 2, 'exercise_template': 6, 'workout_template': 1, 'RepsTemplate': [{'pk': 17, 'model': 'template_editor.repstemplate', 'fields': {'work': false, 'reps': '', 'lift_template': 6}}, {'pk': 18, 'model': 'template_editor.repstemplate', 'fields': {'work': true, 'reps': '', 'lift_template': 6}}]}}, {'pk': 7, 'model': 'template_editor.lifttemplate', 'fields': {'rest': '', 'type': 3, 'exercise_template': 7, 'workout_template': 1, 'RepsTemplate': [{'pk': 19, 'model': 'template_editor.repstemplate', 'fields': {'work': false, 'reps': '', 'lift_template': 7}}, {'pk': 20, 'model': 'template_editor.repstemplate', 'fields': {'work': true, 'reps': '', 'lift_template': 7}}]}}], 'collection': null, 'position': 2, 'description': null}}]");

		wtList = new WorkoutTemplateList("[{'pk': 1, 'model': 'template_editor.workouttemplate', 'fields': {'name': 'null', 'author': 1, 'ExerciseTemplate': [{'pk': 6, 'model': 'template_editor.exercisetemplate', 'fields': {'position': 0, 'notes': '', 'workout_template': 1}}, {'pk': 7, 'model': 'template_editor.exercisetemplate', 'fields': {'position': 1, 'notes': '', 'workout_template': 1}}], 'LiftTemplate': [{'pk': 6, 'model': 'template_editor.lifttemplate', 'fields': {'rest': '', 'type': 2, 'exercise_template': 6, 'workout_template': 1, 'RepsTemplate': [{'pk': 17, 'model': 'template_editor.repstemplate', 'fields': {'work': false, 'reps': '', 'lift_template': 6}}, {'pk': 18, 'model': 'template_editor.repstemplate', 'fields': {'work': true, 'reps': '', 'lift_template': 6}}]}}, {'pk': 7, 'model': 'template_editor.lifttemplate', 'fields': {'rest': '', 'type': 3, 'exercise_template': 7, 'workout_template': 1, 'RepsTemplate': [{'pk': 19, 'model': 'template_editor.repstemplate', 'fields': {'work': false, 'reps': '', 'lift_template': 7}}, {'pk': 20, 'model': 'template_editor.repstemplate', 'fields': {'work': true, 'reps': '', 'lift_template': 7}}]}}], 'collection': null, 'position': 2, 'description': null}}]");
		
		Assert.assertEquals(wtList.get(0).getPk(), 1);
		Assert.assertEquals(wtList.get(0).getName(), null);
//		Assert.assertEquals(wtList.get(0).getAuthor(), 1);
		Assert.assertEquals(wtList.get(0).getCollection(), null);
		Assert.assertEquals(wtList.get(0).getPosition(), 2);
		Assert.assertEquals(wtList.get(0).getDescription(), null);
	}

}
