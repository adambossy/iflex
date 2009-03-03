package com.healthySoftware.client.main.build.workoutBuilder;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;
import com.healthySoftware.client.FUIContainer;

/* TODO: Have this share a superclass with the empty placeholder div at the bottom of the "My Workout" panel */
public class BuilderItem extends BuilderItemDAO /*HorizontalPanel */ {

//	private BuilderItemDAO dao;
	
//	int row;
	
	RepsContainer warmupRepsContainer;
	RepsContainer workoutRepsContainer;
	Rest rest;
	Notes notes;
	UpButton upButton;
	DownButton downButton;
	DeleteButton deleteButton;
	
	/**
	 * Constructor that generates random numbers for the sake of dev and testing
	 */

	public BuilderItem(FUIContainer container, int id, String name, String rest, String notes) {
		this(container, id, name, null, null, rest, notes);
	}

	public BuilderItem(FUIContainer container, int id, String name, String[] warmupReps,
			String[] workoutReps, String rest, String notes) {
		super(
				id,
				name,
				warmupReps,
				workoutReps,
				rest,
				notes
		);
		this.warmupRepsContainer = new RepsContainer(warmupReps, container);
		this.workoutRepsContainer = new RepsContainer(workoutReps, container);
		this.rest = new Rest(rest);
		this.notes = new Notes(notes);
		this.upButton = new UpButton(this, container);
		this.downButton = new DownButton(this, container);
		this.deleteButton = new DeleteButton(this, container);
	}

	public String getExerciseName() {
		return super.getExerciseName();
	}
	
	public void setExerciseName(String exerciseName) {
		super.setExerciseName(exerciseName);
	}

	public int getTypeId() {
		return super.getTypeId();
	}

//	public void setTypeId(int typeId) {
//		super.setTypeId(typeId);
//	}

	public String[] getWarmupReps() {
		super.setWarmupReps(warmupRepsContainer.getReps());
		return super.getWarmupReps();
	}

//	public void setWarmupReps(String[] warmupReps) {
//		super.setWarmupReps(warmupReps);
//	}

	public String[] getWorkoutReps() {
		super.setWarmupReps(workoutRepsContainer.getReps());
		return super.getWarmupReps();
	}

//	public void setWorkoutReps(String[] workoutReps) {
//		super.setWorkoutReps(workoutReps);
//	}

	public String getRest() {
		super.setRest(rest.getText());
		return super.getRest();
	}

//	public void setRest(String rest) {
//		super.setRest(rest);
//	}
	
	public String getNotes() {
		super.setNotes(notes.getText());
		return super.getNotes();
	}
	
//	public void setNotes(String notes) {
//		super.setNotes(notes);
//	}

//	public BuilderItemDAO getDAO() {
//		return this.
//	}

//	public int getRow() {
//		return row;
//	}

//	public void setRow(int row) {
//		this.row = row;
//	}

	protected RepsContainer getWarmupRepsContainerWidget() {
		return warmupRepsContainer;
	}

	protected RepsContainer getWorkoutRepsContainerWidget() {
		return workoutRepsContainer;
	}
	
	protected Notes getNotesWidget() {
		return notes;
	}
	
	protected Rest getRestWidget() {
		return rest;
	}

	protected UpButton getUpButton() {
		return upButton;
	}

	protected DownButton getDownButton() {
		return downButton;
	}

	protected DeleteButton getDeleteButton() {
		return deleteButton;
	}

	//	public void setDAO(BuilderItemDAO super) {
//		this.super = super;
//	}
/*
	private RepsContainer createRepsContainer(String[] reps, HorizontalPanel inputContainer, FUIContainer container) {
		RepsContainer repsContainer = new RepsContainer(container);
		// REPS NEED DELETE FUNCTIONALITY
		if (reps != null && reps.length > 0)
			for (String numReps: reps)
				repsContainer.add(new Reps(repsContainer, numReps));
		else
			repsContainer.add(new Reps(repsContainer, null));
//		repsContainer.add(new AddRepsButton(repsContainer, container));
		return repsContainer; //inputContainer.add(warmupRepsPanel);
//		inputContainer.add(new AddRepsButton(warmupRepsPanel, container));
	}
*/	
	private class DeleteButton extends PushButton {
		/**
		 * @param parent - BuilderItem containing this DeleteButton
		 */
		DeleteButton(final BuilderItem parent, final FUIContainer container) {
			addClickListener(new ClickListener() {
				public void onClick(Widget sender) {
					// Action to add exercise type to My Workout
					// TODO: Send the deleted BuilderItem back to the
					// containing ExerciseSelectionPanel where it should be
					// removed
					container.getWorkoutBuilderPanel().deleteItem(parent);
				}
			});
//			setHTML(new HTML("[x]").toString());
			setHTML("<img src=\"http://localhost:8000/media/images/icons/delete.png\" />");
			setTabIndex(-1);
			// TODO: Create new style
			addStyleName("delete");
		}
	}

	private class UpButton extends PushButton {
		UpButton(final BuilderItem parent, final FUIContainer container) {
			addClickListener(new ClickListener() {
				public void onClick(Widget sender) {
					container.getWorkoutBuilderPanel().shiftItemUp(parent);
				}
			});
//			setHTML(new HTML("[^]").toString());
			setHTML("<img src=\"http://localhost:8000/media/images/icons/arrow_up.png\" />");
			setTabIndex(-1);
			// TODO: Create new style
//			addStyleName("exercise-selector-panel-element-move");
			addStyleName("up");
		}
	}

	private class DownButton extends PushButton {
		DownButton(final BuilderItem parent, final FUIContainer container) {
			addClickListener(new ClickListener() {
				public void onClick(Widget sender) {
					container.getWorkoutBuilderPanel().shiftItemDown(parent);
				}
			});
//			setHTML(new HTML("[v]").toString());
			setHTML("<img src=\"http://localhost:8000/media/images/icons/arrow_down.png\" />");
			setTabIndex(-1);
			// TODO: Create new style
//			addStyleName("exercise-selector-panel-element-add");
			addStyleName("down");
		}
	}
}
