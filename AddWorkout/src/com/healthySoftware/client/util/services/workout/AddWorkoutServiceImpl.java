package com.healthySoftware.client.util.services.workout;

import com.google.gwt.user.client.Window;
import com.healthySoftware.client.AddWorkout;
import com.healthySoftware.client.util.Constants;
import com.healthySoftware.client.util.services.DjangoService;
import com.healthySoftware.client.util.services.ServicePopulator;

/* Change to LoadExerciseTemplatesServiceImpl */
public class AddWorkoutServiceImpl extends DjangoService {
	
	private String path = "/template_editor/service_load_workout_template";
	
//	private Object self = null;
	
//	private Class servicePopulatorClass = AddWorkoutServicePopulate.class; 

	private AddWorkoutServicePopulator servicePopulatorInstance = new AddWorkoutServicePopulator(); 

//	@Override
//	public void handleJsonResponse(String jsonString) {
//  		if (jsonString == null) {
//  			displayError("Json value is null");
//  			return;
//  		}
//
//  		if (jsonString != null) {
//  			// TODO Fill-in
////  			Window.alert("handleJsonResponse() function overridden. Json value: \"" + jsonString + ".\"");
//  			// ((AddWorkout) self).onModuleLoad2(json);
//  			AddWorkoutServicePopulate.execute(jsonString);
//  		} else {
//  			throw new JSONException();
//  		}
//	}

//	public Class getServicePopulatorClass() {
//		return this.servicePopulateClass;
//	}

	public ServicePopulator getServicePopulatorInstance() {
		return this.servicePopulatorInstance;
	}

	@Override
    public void displayError(String error) {
        Window.alert("displayError() function overridden. Error message: \"" + error +".\"");
    }

    public void makeRequest(Object self) {
//    	this.self = self;
    	if (Constants.DEBUG)
    		this.fakeRequest(/*null*/); // TODO: Possibly choose from a list of test cases? Could we make this a URI parameter?
    	else
    		super.makeRequest(this.path + "?workout_template_id=" + Window.Location.getParameter("workout_template_id"));
    }
    
    public void fakeRequest(/*Object self/* De facto "don't care" parameter */) {
    	// TODO: Find a way of streamlining changes in the database directly to here (in a possibly insecure fashion)
    	// Possibly use urllib2 to download the test case (which consists solely of JSON)? 
    	handleJsonResponse("[{\"pk\": 2, \"model\": \"template_editor.workouttemplate\", \"fields\": {\"name\": \"_test0\", \"author\": 1, \"ExerciseTemplate\": [{\"pk\": 4, \"model\": \"template_editor.exercisetemplate\", \"fields\": {\"position\": 0, \"notes\": \"tempo:311\", \"workout_template\": 2}}, {\"pk\": 5, \"model\": \"template_editor.exercisetemplate\", \"fields\": {\"position\": 1, \"notes\": \"tempo:555\", \"workout_template\": 2}}, {\"pk\": 9, \"model\": \"template_editor.exercisetemplate\", \"fields\": {\"position\": 2, \"notes\": \"tempo:777\", \"workout_template\": 2}}], \"LiftTemplate\": [{\"pk\": 4, \"model\": \"template_editor.lifttemplate\", \"fields\": {\"rest\": \"120-180\", \"type\": {\"pk\": 1, \"model\": \"exercises.exercisetype\", \"fields\": {\"name\": \"Barbell Bench Press\", \"parent\": null, \"type\": 0, \"primary_muscle\": 3, \"created_by\": 1, \"time_created\": \"2008-12-14 16:51:49\", \"secondary_muscle\": null, \"muscle_entities\": [3, 6, 29]}}, \"exercise_template\": 4, \"workout_template\": 2, \"RepsTemplate\": [{\"pk\": 10, \"model\": \"template_editor.repstemplate\", \"fields\": {\"work\": false, \"reps\": \"10\", \"lift_template\": 4}}, {\"pk\": 11, \"model\": \"template_editor.repstemplate\", \"fields\": {\"work\": false, \"reps\": \"8\", \"lift_template\": 4}}, {\"pk\": 12, \"model\": \"template_editor.repstemplate\", \"fields\": {\"work\": true, \"reps\": \"6\", \"lift_template\": 4}}, {\"pk\": 13, \"model\": \"template_editor.repstemplate\", \"fields\": {\"work\": true, \"reps\": \"8\", \"lift_template\": 4}}, {\"pk\": 14, \"model\": \"template_editor.repstemplate\", \"fields\": {\"work\": true, \"reps\": \"10\", \"lift_template\": 4}}]}}, {\"pk\": 5, \"model\": \"template_editor.lifttemplate\", \"fields\": {\"rest\": \"60-120\", \"type\": {\"pk\": 2, \"model\": \"exercises.exercisetype\", \"fields\": {\"name\": \"Barbell Bench Press, Incline\", \"parent\": 1, \"type\": 0, \"primary_muscle\": 3, \"created_by\": 1, \"time_created\": \"2008-12-14 17:20:45\", \"secondary_muscle\": null, \"muscle_entities\": [6, 29, 33]}}, \"exercise_template\": 5, \"workout_template\": 2, \"RepsTemplate\": [{\"pk\": 15, \"model\": \"template_editor.repstemplate\", \"fields\": {\"work\": false, \"reps\": \"10\", \"lift_template\": 5}}, {\"pk\": 16, \"model\": \"template_editor.repstemplate\", \"fields\": {\"work\": true, \"reps\": \"10\", \"lift_template\": 5}}]}}, {\"pk\": 8, \"model\": \"template_editor.lifttemplate\", \"fields\": {\"rest\": \"99\", \"type\": {\"pk\": 13, \"model\": \"exercises.exercisetype\", \"fields\": {\"name\": \"Dumbbell One-Arm Bent-Over Row, Reverse Grip\", \"parent\": 12, \"type\": 0, \"primary_muscle\": 22, \"created_by\": 1, \"time_created\": \"2008-12-15 00:32:14\", \"secondary_muscle\": null, \"muscle_entities\": [21, 31, 34]}}, \"exercise_template\": 9, \"workout_template\": 2, \"RepsTemplate\": [{\"pk\": 24, \"model\": \"template_editor.repstemplate\", \"fields\": {\"work\": true, \"reps\": \"11\", \"lift_template\": 8}}]}}], \"collection\": null, \"position\": 1, \"description\": \"\"}}]");
    }
}