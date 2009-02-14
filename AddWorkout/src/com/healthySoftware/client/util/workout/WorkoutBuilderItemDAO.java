package com.healthySoftware.client.util.workout;

public class WorkoutBuilderItemDAO {

//	final private FUIContainer container;
//	final private WorkoutBuilderItem parent;
	
	// TODO: Replace with exercise type id from database
//	private int exerciseType;
	private int exerciseTypeId;
	private String exerciseType;
	private String warmupSets;
	private String warmupReps;
	private String workoutSets;
	private String workoutReps;
	private String tempo;
	private String rest;

	public WorkoutBuilderItemDAO (
			int exerciseTypeId,
			String exerciseName,
			String warmupSets,
			String warmupReps,
			String workoutSets,
			String workoutReps,
			String tempo,
			String rest)
//			FUIContainer container)
//			WorkoutBuilderItem parent)
	{
		// Currently calling exercise type identifier "exerciseName" to denote that it's a string, not yet a database id
		this.exerciseTypeId = exerciseTypeId;
		this.exerciseType = exerciseName;
		this.warmupSets = warmupSets;
		this.warmupReps = warmupReps;
		this.workoutSets = workoutSets;
		this.workoutReps = workoutReps;
		this.tempo = tempo;
		this.rest = rest;
//		this.container = container;
//		this.parent = parent;
	}

	public int getExerciseTypeId() {
		return exerciseTypeId;
	}

	public void setExerciseTypeId(int exerciseTypeId) {
		this.exerciseTypeId = exerciseTypeId;
	}

	public String getExerciseType() {
		return exerciseType;
	}

	public void setExerciseType(String exerciseType) {
		this.exerciseType = exerciseType;
	}

	public String getWarmupSets() {
		return warmupSets;
	}

	public void setWarmupSets(String warmupSets) {
		this.warmupSets = warmupSets;
	}

	public String getWarmupReps() {
		return warmupReps;
	}

	public void setWarmupReps(String warmupReps) {
		this.warmupReps = warmupReps;
	}

	public String getWorkoutSets() {
		return workoutSets;
	}

	public void setWorkoutSets(String workoutSets) {
		this.workoutSets = workoutSets;
	}

	public String getWorkoutReps() {
		return workoutReps;
	}

	public void setWorkoutReps(String workoutReps) {
		this.workoutReps = workoutReps;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public String toString () {
		return "['"
			+ exerciseType + "', '"
			+ warmupSets + "', '" 
			+ warmupReps + "', '"
			+ workoutSets + "', '"
			+ workoutReps + "', '"
			+ tempo + "', '"
			+ rest
			+ "']";
	}
}
