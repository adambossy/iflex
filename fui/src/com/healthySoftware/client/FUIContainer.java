package com.healthySoftware.client;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.healthySoftware.client.errorConsole.ErrorConsole;
import com.healthySoftware.client.header.Header;
import com.healthySoftware.client.main.TabContainer;
import com.healthySoftware.client.main.build.controlPanel.ControlPanel;
import com.healthySoftware.client.main.build.exerciseSelector.ExerciseSelectorContainer;
import com.healthySoftware.client.main.build.muscleGroupSelector.MuscleGroupSelectorPanel;
import com.healthySoftware.client.main.build.workoutBuilder.WorkoutBuilderPanel;

public class FUIContainer extends VerticalPanel { // implements WindowResizeListener {

	Header header = null;
	
	TabContainer tabContainer = null;
	
	ErrorConsole errorConsole = null;
	
//	ControlPanel controlPanel = null;
	
//	final int MUSCLE_GROUP_SELECTION_PANEL = 0;

//	final int EXERCISE_SELECTION_PANEL = 1;

//	final int WORKOUT_BUILDER_PANEL = 2;
	
	FUIContainer() {
		add((header = new Header(this)));
		add((tabContainer = new TabContainer(this)));
//		if (DEBUG_MODE_ENABLED)
			add((errorConsole = new ErrorConsole()));
		this.setWidth("100%");
	}

	public ControlPanel getControlPanel() {
//		return tabContainer.getBuildTab().getControlPanel();
		return getHeader().getControlPanel();
	}

	// ExerciseSelectionPanel getExerciseSelectionPanel() {
	// // TODO: Initialize this as empty and set the indices as constants
	// return (ExerciseSelectionPanel) getWidget(1);
	// }

//	public void setExerciseSelectorPanel(ExerciseSelectorPanel newPanel) {
	public void setExerciseSelectorPanel(int index) {
		// TODO: Initialize this as empty and set the indices as constants
		// TODO: Instead of having infinite getX().getY()... etc, make pointers to these
//		tabContainer.getBuildTab().getExerciseSelectorContainer().swap(newPanel);
		tabContainer.getBuildTab().getExerciseSelectorContainer().swap(index);
		
//		this.remove(EXERCISE_SELECTION_PANEL);
//		this.insert(newPanel, EXERCISE_SELECTION_PANEL);
//		exerciseSelectionPanel = (ExerciseSelectorPanel) this.getWidget(EXERCISE_SELECTION_PANEL);
	}

	// TODO: Set the indices as constants
//	public WorkoutBuilderPanel getWorkoutBuilderPanel() {
		// This index should be 2, but the first index hasn't been created yet
		// when this function is call, so we use 1
		// return (WorkoutBuilderPanel) this.getWidget(WORKOUT_BUILDER_PANEL);
//		return workoutBuilderPanel;
//	}

//	public void setWorkoutBuilderPanel(WorkoutBuilderPanel workoutBuilderPanel) {
//		this.workoutBuilderPanel = workoutBuilderPanel;
//	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public TabContainer getTabContainer() {
		return tabContainer;
	}

	public void setTabContainer(TabContainer tabContainer) {
		this.tabContainer = tabContainer;
	}

	public ErrorConsole getErrorConsole() {
		return errorConsole;
	}

	public void setErrorConsole(ErrorConsole errorConsole) {
		this.errorConsole = errorConsole;
	}

	/* THE FOLLOWING FUNCTIONS EXIST AT THE TOP-LEVEL SOLELY FOR KEEPING N-LEVEL CALLS THROUGH THE TREE SHORT */
	public WorkoutBuilderPanel getWorkoutBuilderPanel() {
		return getTabContainer().getBuildTab().getWorkoutBuilderPanel();
	}

//	public void setWorkoutBuilderPanel(WorkoutBuilderPanel workoutBuilderPanel) {
//		this.getTabContainer().getBuildTab().setWorkoutBuilderPanel(workoutBuilderPanel);
//	}

	public ExerciseSelectorContainer getExerciseSelectorContainer() {
		return getTabContainer().getBuildTab().getExerciseSelectorContainer();
	}

//	public void setExerciseSelectorPanel(ExerciseSelectorContainer exerciseSelectorContainer) {
//		getTabContainer().getBuildTab().setExerciseSelectorContainer(exerciseSelectorContainer);
//	}

	public MuscleGroupSelectorPanel getMuscleGroupSelectorPanel() {
		return getTabContainer().getBuildTab().getMuscleGroupSelectorPanel();
	}

//	public void setMuscleGroupSelectorPanel(MuscleGroupSelectorPanel muscleGroupSelectorPanel) {
//		getTabContainer().getBuildTab().setMuscleGroupSelectorPanel(muscleGroupSelectorPanel);
//	}
}
