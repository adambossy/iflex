package com.healthySoftware.client.workoutBuilder;

import com.healthySoftware.client.FUIContainer;

public class WorkoutBuilderItemDAO {

//	final private FUIContainer container;
	final private WorkoutBuilderItem parent;
	
	private int warmupSets;
	private int warmupReps;
	private int workoutSets;
	private int workoutReps;
	private String tempo;
	private String rest;

	public WorkoutBuilderItemDAO (
			int warmupSets,
			int warmupReps,
			int workoutSets,
			int workoutReps,
			String tempo,
			String rest,
//			FUIContainer container)
			WorkoutBuilderItem parent)
	{
		this.warmupSets = warmupSets;
		this.warmupReps = warmupReps;
		this.workoutSets = workoutSets;
		this.workoutReps = workoutReps;
		this.tempo = tempo;
		this.rest = rest;
//		this.container = container;
		this.parent = parent;
	}

	// TODO: need to actually be gotten from the text boxes
	public int getWarmupSets() {
		// TODO: Change these to actual access methods,
		// e.g., getWarmupSets() instead of getWidget(1) with the cast
		// TODO: Change parseInt to a function that can actually parse things
		// like "60-120" or "311" or "Full Recovery" or "10/8/6"
		this.warmupSets = Integer.parseInt(((Sets) parent.getWidget(1)).getText());
		return this.warmupSets;
	}

	public void setWarmupSets(int warmupSets) {
		this.warmupSets = warmupSets;
	}

	public int getWarmupReps() {
		this.warmupReps = Integer.parseInt(((Reps) parent.getWidget(2)).getText());
		return this.warmupReps;
	}

	public void setWarmupReps(int warmupReps) {
		this.warmupReps = warmupReps;
	}

	public int getWorkoutSets() {
		this.workoutSets = Integer.parseInt(((Sets) parent.getWidget(3)).getText());
		return this.workoutSets;
	}

	public void setWorkoutSets(int workoutSets) {
		this.workoutSets = workoutSets;
	}

	public int getWorkoutReps() {
		this.workoutReps = Integer.parseInt(((Reps) parent.getWidget(4)).getText());
		return this.workoutReps;
	}

	public void setWorkoutReps(int workoutReps) {
		this.workoutReps = workoutReps;
	}

	public String getTempo () {
		this.tempo = ((Tempo) parent.getWidget(5)).getText();
		return this.tempo;
	}

	public void setTempo (String tempo) {
		this.tempo = tempo;
	}

	public String getRest () {
		this.rest = ((Rest) parent.getWidget(6)).getText();
		return this.rest;
	}
	
	public void setRest (String rest) {
		this.rest = rest;
	}
}
