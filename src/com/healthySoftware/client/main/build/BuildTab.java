package com.healthySoftware.client.main.build;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.healthySoftware.client.FUIContainer;
import com.healthySoftware.client.main.build.controlPanel.ControlPanel;
import com.healthySoftware.client.main.build.exerciseSelector.ExerciseSelectorContainer;
import com.healthySoftware.client.main.build.muscleGroupSelector.MuscleGroupSelectorPanel;
import com.healthySoftware.client.main.build.workoutBuilder.WorkoutBuilderPanel;

public class BuildTab extends VerticalPanel {
	
	// TODO: Possibly move these to TabContainer
	WorkoutBuilderPanel workoutBuilderPanel = null;

	ExerciseSelectorContainer exerciseSelectorContainer = null;

	MuscleGroupSelectorPanel muscleGroupSelectorPanel = null;

	ControlPanel controlPanel = null;
	
//	BuildTab(JSONArray exerciseList, ExerciseSelectorPanel[] exerciseSelectionPanels, FUIContainer container) {
	public BuildTab(FUIContainer container) {
		
		/* UPPER HALF */
		HorizontalPanel upperHalf = new HorizontalPanel();
		upperHalf.add(muscleGroupSelectorPanel = new MuscleGroupSelectorPanel());
		upperHalf.add(exerciseSelectorContainer = new ExerciseSelectorContainer());
		// TODO Move to CSS file
		upperHalf.setWidth("100%");
		upperHalf.setCellWidth(muscleGroupSelectorPanel, "150px");
		upperHalf.setCellWidth(exerciseSelectorContainer, "100%");
		upperHalf.setBorderWidth(1);
		
		/* LOWER HALF */
		VerticalPanel lowerHalf = new VerticalPanel();
		lowerHalf.add(workoutBuilderPanel = new WorkoutBuilderPanel(container));
		lowerHalf.add(controlPanel = new ControlPanel(container));
		lowerHalf.setWidth("100%");
//		workoutBuilderPanel.setWidth("100%");
		
		/* CONSOLIDATE */
		add(upperHalf);
		add(lowerHalf);

		setWidth("100%");
		addStyleName("build-tab");
	}

	public WorkoutBuilderPanel getWorkoutBuilderPanel() {
		return workoutBuilderPanel;
	}

	public void setWorkoutBuilderPanel(WorkoutBuilderPanel workoutBuilderPanel) {
		this.workoutBuilderPanel = workoutBuilderPanel;
	}

	public ExerciseSelectorContainer getExerciseSelectorContainer() {
		return exerciseSelectorContainer;
	}

	public void setExerciseSelectorContainer(ExerciseSelectorContainer exerciseSelectorContainer) {
		this.exerciseSelectorContainer = exerciseSelectorContainer;
	}

	public MuscleGroupSelectorPanel getMuscleGroupSelectorPanel() {
		return muscleGroupSelectorPanel;
	}

	public void setMuscleGroupSelectorPanel(MuscleGroupSelectorPanel muscleGroupSelectorPanel) {
		this.muscleGroupSelectorPanel = muscleGroupSelectorPanel;
	}

	public ControlPanel getControlPanel() {
		return controlPanel;
	}

	public void setControlPanel(ControlPanel controlPanel) {
		this.controlPanel = controlPanel;
	}
}
