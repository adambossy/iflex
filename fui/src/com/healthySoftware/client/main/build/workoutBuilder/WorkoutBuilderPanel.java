 package com.healthySoftware.client.main.build.workoutBuilder;

import java.util.ArrayList;
import java.util.LinkedList;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.healthySoftware.client.FUIContainer;

//public class WorkoutBuilderPanel extends VerticalPanel {
public class WorkoutBuilderPanel extends FlexTable {

	// TODO: Keeping this as a list may be intuitive
	ArrayList<BuilderItemDAO> exerciseList;
	
	public WorkoutBuilderPanel(FUIContainer container) {
		// Abstract loop away to a superclass object or make the code inside the
		// loop part of a subclass object
		addStyleName("workout-builder-panel");
	
//		HTML placeHolder = new HTML("&nbsp;");
//		placeHolder.addStyleName("workout-builder-panel-placeholder");

//		this.setWidget(1, 0, placeHolder);
		for (int i = 1; i < 9; i++) 
			this.setWidget(1, i, new HTML("&nbsp;"));

//		HTML heading = new HTML("My Workout");
//		HorizontalPanel heading = new HorizontalPanel();
		this.setBorderWidth(0);
//		heading.addStyleName("workout-builder-panel-heading");
		
		HTML title = new HTML("My Workout");
		this.setWidget(0, 0, title);
		
		HTML warmupReps = new HTML("Warmup Reps");
		warmupReps.addStyleName("reps-label");
		this.setWidget(0, 1, warmupReps);

		HTML workoutReps = new HTML("Workout Reps");
		workoutReps.addStyleName("reps-label");
		this.setWidget(0, 2, workoutReps);

		HTML rest = new HTML("Rest in secs");
		rest.addStyleName("rest-label");
		this.setWidget(0, 3, rest);

		HTML notes = new HTML("Notes");
		notes.addStyleName("notes-label");
		this.setWidget(0, 4, notes);

		FlexCellFormatter cellFormatter = this.getFlexCellFormatter();
		cellFormatter.setWidth(0, 0, "100%");
		
		// TODO Alternative: Make a subclass of HTML that applies the following style in the constructor
		for (int i = 0; i < 5; i++) 
			cellFormatter.setStyleName(0, i, "workout-builder-panel-heading");

		this.setWidth("100%");
		this.setCellSpacing(0);
		this.setCellPadding(0);

		// TODO: Should container be a global? There are no instances when we
		// would access a different "container"

		exerciseList = new ArrayList<BuilderItemDAO>();

		// TODO Format the heading properly; probably not necessary until the first item is added
		cellFormatter.setColSpan(0, 0, 4);
//		cellFormatter.setWidth(0, 0, "100%");
		cellFormatter.setColSpan(0, 1, 1);
		cellFormatter.setColSpan(0, 2, 1);
		cellFormatter.setColSpan(0, 3, 2);
		cellFormatter.setColSpan(0, 4, 1);
	}

	
	public void addItem(FUIContainer container, int id, String name) {
		// There are two widgets in container by default, the heading and the stub at the bottom
		// TODO: "Save as template..." functionality
		// TODO: Focus on newly built workout item when it is created? (for ease-of-use)
		// TODO: Allow strings and ranges to be input into any of these fields
		if (this.exerciseList.size() > 0) {
			BuilderItemDAO item = this.getLastItem();
			addItem(container,
					id,
					name,
					item.getWarmupReps(),
					item.getWorkoutReps(),
					item.getRest(),
					item.getNotes()
			);
		}
		else
			addItem(container, id, name, null, null, null, null);
	}

	public BuilderItemDAO getLastItem() {
		return this.exerciseList.get(this.exerciseList.size()-1);
	}
	
	// TODO: Wrap up all these parameters into a DAO (i.e., a Java "tuple")
	public void addItem(FUIContainer container, int id, String name, String[] warmupReps,
			String[] workoutReps, String rest, String notes) {
		addItem(container, new BuilderItem(container, id, name, warmupReps, workoutReps, rest, notes));
	}

	public void addItem(FUIContainer container, BuilderItem builderItem) {
		insertItem(exerciseList.size(), builderItem); // The offset of 1 is the heading of the FlexTable
	}

//	public void insertItem(int row, FUIContainer container, BuilderItem builderItem) {
////		int row = exerciseList.size() + 1; // The offset of 1 is the heading of the FlexTable 
////		this.insertRow(row);
////		this.setWidget(activeRow, 0, new BuilderItem(container, this, id, name, warmupReps, workoutReps, rest, notes));
////		BuilderItem item = new BuilderItem(container, this, activeRow, id, name, warmupReps, workoutReps, rest, notes); // Should be a factory method
//	exerciseList.add(builderItem);
//	}

	public void insertItem(int row, BuilderItem item) {
		exerciseList.add(row, item);
		insertItemIntoTable(row, item);
	}

	public void insertItemIntoTable(int row, BuilderItem item) {
		this.insertRow(++row);
		System.out.println("adding row in grid: " + row);
		
		Image thumbnail = new Image("http://localhost:8000/media/images/exercises/barbell-bench-press-incline-64x32.png");
		setWidget(row, 0, thumbnail);
		thumbnail.addStyleName("thumbnail");
		getCellFormatter().setWidth(row, 0, "48px");
//		getCellFormatter().setWidth(row, 0, thumbnail.getWidth()+"px");
		
		HTML type = new HTML(item.getExerciseName()); // index = 0;
		type.addStyleName("workout-builder-panel-element-label");
//		getCellFormatter().setWidth(row, 1, "100%");
		setWidget(row, 1, item.getUpButton());
		setWidget(row, 2, item.getDownButton());

		setWidget(row, 3, type);

//		setWidget(row, 4, new HTML("&nbsp;"));
		getCellFormatter().setWidth(row, 3, "100%");

		/* TODO: divide sets, reps, tempo, rest, into mini-subclasses */
		setWidget(row, 4, item.getWarmupRepsContainerWidget());
		setWidget(row, 5, item.getWorkoutRepsContainerWidget());

		setWidget(row, 6, item.getRestWidget());

		setWidget(row, 7, item.getDeleteButton());
		
		setWidget(row, 8, item.getNotesWidget());
		
		for (int i = 0; i < 9; i++) { 
			getCellFormatter().setVerticalAlignment(row, i, HasVerticalAlignment.ALIGN_TOP);
		}
	}

	public void clearList() {
	}
	
//	public void deleteItem(Widget item) {}
	public void deleteItem(BuilderItem item) {
//		this.removeRow(item.getRow());
		int index = getRow(item);
		System.out.println("deleteItem :: index: " + index);
		removeRow(index + 1);
		exerciseList.remove(index);
		System.out.println("Removing row in array " + index + ", in grid: " + (index + 1));
	}

//	public void shiftItemUp(Widget item) {}
	public void shiftItemUp(BuilderItem item) {
		int index = getRow(item);
		System.out.println("shiftItemUp :: index: " + index);
		if (index > 0) { // Not the first element
//			BuilderItem temp = item;
			deleteItem(item);
//			exerciseList.add(index+1, item);
			insertItem(index-1, item);
		}
	}

//	public void shiftItemDown(Widget item) {}
	public void shiftItemDown(BuilderItem item) {
		int index = getRow(item);
		System.out.println("shiftItemDown :: index: " + index);
		if (index < exerciseList.size() - 1) { // Not the last element
//			BuilderItem temp = item;
			deleteItem(item);
//			exerciseList.add(index, item);
			insertItem(index+1, item);
		}
	}

	private int getRow(BuilderItem item) {
		for (int index = 0; index < exerciseList.size(); index++)
			if (item.equals(this.exerciseList.get(index)))
				return index;
		return -1;
	}
	
	public ArrayList<BuilderItemDAO> getExerciseList() {
		return this.exerciseList;
	}
	
/*	
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
			String[] workoutReps, String rest, String notes) {
		insert(new BuilderItem(id, name, container, warmupReps,
				workoutReps, rest, notes), this.getWidgetCount() - 1);
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

//	public ArrayList<BuilderItemDAO> getExerciseList() {
//		ArrayList<BuilderItemDAO> exerciseList = new ArrayList<BuilderItemDAO>();
//		for (int i = 1; i < getWidgetCount() - 1; i++)
//			exerciseList.add(((BuilderItem) this.getWidget(i)).getDAO());
//		return exerciseList;	
//	}

	public ArrayList<BuilderItem> getExerciseList() {
		ArrayList<BuilderItem> exerciseList = new ArrayList<BuilderItem>();
		for (int i = 1; i < getWidgetCount() - 1; i++)
			exerciseList.add(((BuilderItem) this.getWidget(i)));
		return exerciseList;
	}
*/	
}
