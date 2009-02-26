 package com.healthySoftware.client.main.build.workoutBuilder;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.healthySoftware.client.FUIContainer;

public class WorkoutBuilderPanel extends VerticalPanel {

	// TODO: Keeping this as a list may be intuitive
//	ArrayList<BuilderItemDAO> exerciseList = new ArrayList<BuilderItemDAO>();
	
	public WorkoutBuilderPanel(FUIContainer container) {
		// Abstract loop away to a superclass object or make the code inside the
		// loop part of a subclass object
		addStyleName("workout-builder-panel");
		
//		HTML heading = new HTML("My Workout");
		HorizontalPanel heading = new HorizontalPanel();
		heading.setBorderWidth(1);
		heading.addStyleName("workout-builder-panel-heading");
		
		HTML title = new HTML("My Workout");
		heading.add(title);
		
		HTML warmupReps = new HTML("Warmup Reps");
		warmupReps.addStyleName("reps-label");
		heading.add(warmupReps);

		HTML workoutReps = new HTML("Workout Reps");
		workoutReps.addStyleName("reps-label");
		heading.add(workoutReps);

		HTML rest = new HTML("Rest in secs");
		rest.addStyleName("rest-label");
		heading.add(rest);

		HTML notes = new HTML("Notes");
		notes.addStyleName("notes-label");
		heading.add(notes);

		add(heading);

		heading.setWidth("100%");
		heading.setCellWidth(title, "100%");

		// TODO: Should container be a global? There are no instances when we
		// would access a different "container"
//		add(new BuilderItem("Barbell Bench Press", container));
//		add(new BuilderItem("Lying Triceps Pullover, 1 Weight In 2 Hands", container));

		HTML placeHolder = new HTML();
		placeHolder.addStyleName("workout-builder-panel-placeholder");
		add(placeHolder);

//		container.setWorkoutBuilderPanel(this);
	}

	public void addItem(int id, String name, FUIContainer container) {
//		insert(new BuilderItem(name, container), this.getWidgetCount() - 1);
		// There are two widgets in container by default, the heading and the stub at the bottom
		// TODO: "Save as template..." functionality
		// TODO: Focus on newly built workout item when it is created? (for ease-of-use)
		// TODO: Allow strings and ranges to be input into any of these fields 
		if (getWidgetCount() > 2) {
			BuilderItem item = getLastWidget();
			addItem(id,
					name,
					container,
//					item.dao.getWarmupSets(),
					item.getWarmupReps(),
//					item.dao.getWorkoutSets(),
					item.getWorkoutReps(),
//					item.getTempo(),
					item.getRest(),
					item.getNotes()
					);
		}
		else {
//			BuilderItem item = new BuilderItem(name, container);
//			exerciseList.add(item.dao);
			insert(new BuilderItem(id, name, container, "", ""), this.getWidgetCount()-1);
		}
	}

	public BuilderItem getLastWidget() {
//		System.out.println("last widget: " + getWidget(getWidgetCount()-2));
		return (BuilderItem) getWidget(getWidgetCount()-2);
	}
	
	// TODO: Wrap up all these parameters into a DAO (i.e., a Java "tuple")
	public void addItem(int id, String name, FUIContainer container, String[] warmupReps,
			String[] workoutReps, /*String tempo,*/ String rest, String notes) {
		insert(new BuilderItem(id, name, container, warmupReps,
				workoutReps, /*tempo,*/ rest, notes), this.getWidgetCount() - 1);
	}

	public void clearList() {
		for (int index=0; index<getWidgetCount(); index++)
			remove(index);			
	}
	
	public void deleteItem(Widget item) {
		this.remove(item);
	}

	public void shiftItemUp(Widget item) {
		int index = this.getWidgetIndex(item);
		if (index > 1) {
			this.deleteItem(item);
			this.insert(item, index-1);
		}
	}

	public void shiftItemDown(Widget item) {
		int index = this.getWidgetIndex(item);
		if (index < this.getWidgetCount() - 2) {
			this.deleteItem(item);
			this.insert(item, index+1);
		}
	}
/*	
	public ArrayList<BuilderItemDAO> getExerciseList() {
		ArrayList<BuilderItemDAO> exerciseList = new ArrayList<BuilderItemDAO>();
		for (int i = 1; i < getWidgetCount() - 1; i++)
			exerciseList.add(((BuilderItem) this.getWidget(i)).getDAO());
		return exerciseList;	
	}
*/
	public ArrayList<BuilderItem> getExerciseList() {
		ArrayList<BuilderItem> exerciseList = new ArrayList<BuilderItem>();
		for (int i = 1; i < getWidgetCount() - 1; i++)
			exerciseList.add(((BuilderItem) this.getWidget(i)));
		return exerciseList;
	}
	
}
