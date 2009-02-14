package com.healthySoftware.client.main.build.workoutBuilder;

import java.util.Arrays;

public class BuilderItemDAO {

	final private BuilderItem parent;
	
	private int typeId;
	private String exerciseName;
	// TODO: Ultimately change this to a custom object that allows for both shorthand ranges 
	// (e.g. 2-4 sets, 10 reps each, or 3 sets, 10/8/6 reps) and just plain numbers
	private String[] warmupReps;
	private String[] workoutReps;
//	private String tempo;
	private String rest;
	private String notes;
	
	public BuilderItemDAO (
			int typeId,
			String exerciseName,
			String[] warmupReps,
			String[] workoutReps,
//			String tempo,
			String rest,
			String notes,
			BuilderItem parent)
	{
		// Currently calling exercise type identifier "exerciseName" to denote that it's a string, not yet a database id
		this.typeId = typeId;
		this.exerciseName = exerciseName;
		this.warmupReps = warmupReps;
		this.workoutReps = workoutReps;
//		this.tempo = tempo;
		this.rest = rest;
		this.parent = parent;
		this.notes = notes;
	}

	/**
	 * All the method in this class are protected so that we enforce limited access of getters and setters so that BuilderItem has
	 * to access them instead of other classes (e.g. SaveAction). 
	 */
	String getExerciseName() {
		return this.exerciseName;
	}
	
	void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	int getTypeId() {
		return typeId;
	}

	void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	String[] getWarmupReps() {
		return warmupReps;
	}

	void setWarmupReps(String[] warmupReps) {
		this.warmupReps = warmupReps;
	}

	String[] getWorkoutReps() {
		return workoutReps;
	}

	void setWorkoutReps(String[] workoutReps) {
		this.workoutReps = workoutReps;
	}
/*
	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
*/
	String getRest() {
		return rest;
	}

	void setRest(String rest) {
		this.rest = rest;
	}

	public BuilderItem getParent() {
		return parent;
	}

	String getNotes() {
		return notes;
	}

	void setNotes(String notes) {
		this.notes = notes;
	}

	public String toString () {
		return "['"
			+ typeId + "', '"
			+ exerciseName + "', '"
			+ Arrays.toString(warmupReps) + "', '"
			+ Arrays.toString(workoutReps) + "', '"
//			+ tempo + "', '"
			+ rest
			+ "']";
	}
}
