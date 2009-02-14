package com.healthySoftware.client.util.workout;

import com.google.gwt.json.client.JSONValue;

public class WorkoutItemDAO extends WorkoutBuilderItemDAO {

	WorkoutItemDAO(
		String model,
		int exerciseTypeId,
		String exerciseName,
		String warmupSets,
		String warmupReps,
		String workoutSets,
		String workoutReps,
		String tempo,
		String rest) {
		super(
			exerciseTypeId,
			exerciseName,
			warmupSets,
			warmupReps,
			workoutSets,
			workoutReps,
			tempo,
			rest);
	}

	WorkoutItemDAO(
			JSONValue exerciseTypeId,
			JSONValue exerciseName,
			JSONValue warmupSets,
			JSONValue warmupReps,
			JSONValue workoutSets,
			JSONValue workoutReps,
			JSONValue tempo,
			JSONValue rest) {
			super(
				(int) exerciseTypeId.isNumber().doubleValue(),
				exerciseName.isString().stringValue(),
				warmupSets.isString().stringValue(),
				warmupReps.isString().stringValue(),
				workoutSets.isString().stringValue(),
				workoutReps.isString().stringValue(),
				tempo.isString().stringValue(),
				rest.isString().stringValue());
		}
	
}
