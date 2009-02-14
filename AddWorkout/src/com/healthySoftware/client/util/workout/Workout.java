package com.healthySoftware.client.util.workout;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class Workout {

	private List<WorkoutItemDAO> workoutItems;
	
	public Workout(JSONValue json) {
		JSONArray _liftTemplateList = json.isArray();
		workoutItems = new ArrayList<WorkoutItemDAO>(_liftTemplateList.size());
		if (_liftTemplateList != null) {
			for (int i = 0; i < _liftTemplateList.size(); i++) {
				JSONObject el = (JSONObject) _liftTemplateList.get(i);
//				System.out.println (el.get("pk"));
				System.out.println (el.get("type_id"));
				System.out.println (el.get("type"));
				System.out.println (el.get("warmup_sets"));
				System.out.println (el.get("warmup_reps"));
				System.out.println (el.get("workout_sets"));
				System.out.println (el.get("workout_reps"));
				System.out.println (el.get("tempo"));
				System.out.println (el.get("rest"));
				workoutItems.add(
						new WorkoutItemDAO(
//								el.get("pk"),
								el.get("type_id"),
								el.get("type"),
								el.get("warmup_sets"),
								el.get("warmup_reps"),
								el.get("workout_sets"),
								el.get("workout_reps"),
								el.get("tempo"),
								el.get("rest")));
			}
		}
	}

	public List<WorkoutItemDAO> getWorkoutItems() {
		return workoutItems;
	}

	public void setWorkoutItems(List<WorkoutItemDAO> workoutItems) {
		this.workoutItems = workoutItems;
	}
}
