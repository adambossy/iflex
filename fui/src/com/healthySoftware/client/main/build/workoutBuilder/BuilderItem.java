package com.healthySoftware.client.main.build.workoutBuilder;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;
import com.healthySoftware.client.FUIContainer;

/* TODO: Have this share a superclass with the empty placeholder div at the bottom of the "My Workout" panel */
public class BuilderItem extends HorizontalPanel {

	private BuilderItemDAO dao;
	
	RepsContainer warmupRepsContainer = null;
	RepsContainer workoutRepsContainer = null;
	Rest rest = null;
	Notes notes = null;
	
	/**
	 * Constructor that generates random numbers for the sake of dev and testing
	 */
	public BuilderItem(int id, String name, FUIContainer container, String rest, String notes) {
		this(id, name, container, null, null, /*"311",*/ rest, notes);
	}

	public BuilderItem(int id, String name, FUIContainer container, String[] warmupReps,
			String[] workoutReps, /*String tempo,*/ String rest, String notes) {
		addStyleName("workout-builder-panel-element");

		this.setBorderWidth(1);
		
		setWidth("100%");
		
		Image thumbnail = new Image("http://localhost:8000/media/images/exercises/barbell-bench-press-incline-64x32.png");
		add(thumbnail);
		
		HTML type = new HTML(name); // index = 0;
		type.addStyleName("workout-builder-panel-element-label");
		add(type);

		HorizontalPanel in = new HorizontalPanel();
		in.addStyleName("workout-builder-panel-element-input");
		in.setBorderWidth(2);
		
		/* TODO: divide sets, reps, tempo, rest, into mini-subclasses */
//		add(new Sets(warmupSets));
//		in.add(warmupRepsContainer = createRepsContainer(warmupReps, in, container)); // index = 1
		in.add(warmupRepsContainer = new RepsContainer(warmupReps, container)); // index = 1

//		add(new Sets(workoutSets));
//		in.add(workoutRepsContainer = createRepsContainer(workoutReps, in, container)); // index = 3
		in.add(workoutRepsContainer = new RepsContainer(workoutReps, container)); // index = 3

//		add(new Tempo(tempo)); 
		in.add(this.rest = new Rest(rest)); // index = 5

		in.add(new UpButton(this, container)); // index = 6
		in.add(new DownButton(this, container)); // index = 7
		in.add(new DeleteButton(this, container)); // index = 8
		
		in.add(this.notes = new Notes()); // index = 9
		
		setCellWidth(type, "100%");
//		in.setBorderWidth(1);
		add(in);
		setCellWidth(in, "480px");
		
//		for (int i = 1; i < 9; i++) 
//			this.setCellWidth(this.getWidget(i), this.getWidget(i).getOffsetWidth()+"px");
		
		dao = new BuilderItemDAO(
			id,
			name,
			warmupReps,
			workoutReps,
			/*tempo,*/
			rest,
			notes,
			this
		);
	}


	public String getExerciseName() {
		return dao.getExerciseName();
	}
	
	public void setExerciseName(String exerciseName) {
		dao.setExerciseName(exerciseName);
	}

	public int getTypeId() {
		return dao.getTypeId();
	}

//	public void setTypeId(int typeId) {
//		dao.setTypeId(typeId);
//	}

	public String[] getWarmupReps() {
		dao.setWarmupReps(warmupRepsContainer.getReps());
		return dao.getWarmupReps();
	}

//	public void setWarmupReps(String[] warmupReps) {
//		dao.setWarmupReps(warmupReps);
//	}

	public String[] getWorkoutReps() {
		dao.setWarmupReps(workoutRepsContainer.getReps());
		return dao.getWarmupReps();
	}

//	public void setWorkoutReps(String[] workoutReps) {
//		dao.setWorkoutReps(workoutReps);
//	}

	public String getRest() {
		dao.setRest(rest.getText());
		return dao.getRest();
	}

//	public void setRest(String rest) {
//		dao.setRest(rest);
//	}
	
	public String getNotes() {
		dao.setNotes(notes.getText());
		return dao.getNotes();
	}
	
//	public void setNotes(String notes) {
//		dao.setNotes(notes);
//	}

	public BuilderItemDAO getDAO() {
		return dao;
	}

//	public void setDAO(BuilderItemDAO dao) {
//		this.dao = dao;
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
		DeleteButton(final Widget parent, final FUIContainer container) {
			addClickListener(new ClickListener() {
				public void onClick(Widget sender) {
					// Action to add exercise type to My Workout
					// TODO: Send the deleted BuilderItem back to the
					// containing ExerciseSelectionPanel where it should be
					// removed
					container.getWorkoutBuilderPanel().deleteItem(parent);
				}
			});
			setHTML(new HTML("[x]").toString());
			setTabIndex(-1);
			// TODO: Create new style
			addStyleName("delete");
		}
	}

	private class UpButton extends PushButton {
		UpButton(final Widget parent, final FUIContainer container) {
			addClickListener(new ClickListener() {
				public void onClick(Widget sender) {
					container.getWorkoutBuilderPanel().shiftItemUp(parent);
				}
			});
			setHTML(new HTML("[^]").toString());
			setTabIndex(-1);
			// TODO: Create new style
//			addStyleName("exercise-selector-panel-element-move");
			addStyleName("move");
		}
	}

	private class DownButton extends PushButton {
		DownButton(final Widget parent, final FUIContainer container) {
			addClickListener(new ClickListener() {
				public void onClick(Widget sender) {
					container.getWorkoutBuilderPanel().shiftItemDown(parent);
				}
			});
			setHTML(new HTML("[v]").toString());
			setTabIndex(-1);
			// TODO: Create new style
//			addStyleName("exercise-selector-panel-element-add");
			addStyleName("down");
		}
	}
}
