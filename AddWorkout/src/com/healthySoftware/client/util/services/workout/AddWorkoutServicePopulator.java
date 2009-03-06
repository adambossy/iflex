package com.healthySoftware.client.util.services.workout;

//import com.google.gwt.json.client.JSONArray;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.healthySoftware.client.util.models.template_editor.LiftTemplate;
import com.healthySoftware.client.util.models.template_editor.RepsTemplate;
import com.healthySoftware.client.util.models.template_editor.WorkoutTemplate;
import com.healthySoftware.client.util.models.template_editor.WorkoutTemplateList;
import com.healthySoftware.client.util.services.ServicePopulator;

public class AddWorkoutServicePopulator implements ServicePopulator {

	public void execute(String/*JSONArray*/ jsonArray) {
//		WorkoutTemplateList workoutTemplateList = WorkoutTemplateList.fromJSONArrayJsni(jsonArray);
		WorkoutTemplateList workoutTemplateList = new WorkoutTemplateList(jsonArray);
		
		WorkoutTemplate workoutTemplate = workoutTemplateList.get(0);

//		FlexTable workoutItemsPanel = new FlexTable();
//		labelPanel(workoutItemsPanel);
		
		final DeckPanel parentPanel = new DeckPanel();
		parentPanel.addStyleName("parent-panel");
		
//		VerticalPanel[] exercisePanelList = new VerticalPanel[workoutTemplateList.length()];
		
		for (LiftTemplate liftTemplate: workoutTemplate.getLiftTemplateList().getList()) {
			ExercisePanel exercisePanel = new ExercisePanel(liftTemplate, parentPanel);
			System.out.println ("LiftTemplate: " + liftTemplate.toString());
			parentPanel.add(exercisePanel);
		}
		
		parentPanel.showWidget(0);
		
		RootPanel.get().add(parentPanel);
		
	}
	
	static int generateRow(RepsTemplate repsTemplate, int row, FlexTable table) {
		TextBox weight = new TextBox();
		weight.addStyleName("text-box");
		weight.setMaxLength(12);
		table.setWidget(row, 0, weight);
		table.setWidget(row, 1, generateRepsLabel());
		// Subclass this
		TextBox repsBox = new TextBox();
		repsBox.addStyleName("text-box");
		repsBox.setText(repsTemplate.getReps());
		repsBox.setMaxLength(12);
		table.setWidget(row, 2, repsBox);
		table.setWidget(row, 3, generateUnitsLabel());
//		table.setHTML(row, 4, "stub");
//		table.getCellFormatter().setWidth(row, 4, "100%");
//		table.setWidth("100%");
		return ++row;
	}
	
	static Label generateRepsLabel() {
		Label label = new Label("reps");
		label.addStyleName("data-label");
		return label;
	}

	static Label generateUnitsLabel() {
		// TODO: Grab these units from the user's preferences, once preferences are implemented
		Label label = new Label("lbs");
		label.addStyleName("data-label");
		return label;
	}
	
	/* 
	 * TODO: Probably a bad idea to duplicate all the elements for each workout
	 * and store them in memory on a mobile device. Reuse type, next/prev buttons,
	 * text boxes.
	 */
	private static class /*Mobile*/ExercisePanel extends VerticalPanel {
		
		HorizontalPanel header;
		HTML type;
		PushButton save;
		PushButton complete;
		
		public ExercisePanel(LiftTemplate liftTemplate, DeckPanel parentPanel)
		{
			add(this.header = createHeader(liftTemplate.getType().getName(), parentPanel));

			// TODO: Find a way to flexibly and consistently set the height; otherwise,
			// space between the header and the FlexTable could show up
//			this.setCellHeight(header, "51px"/*header.getOffsetHeight()+"px"*/);
//			System.out.println("offset height: " + header.getOffsetHeight()+"px");
			
			add(new HTML("<h2>Warmup</h2>"));
			
			add(populateSets(false, liftTemplate));
			
			add(new HTML("<h2>Work</h2>"));

			add(populateSets(true, liftTemplate));
			
			add(this.save = new PushButton());
			this.save.setText("Save Progress");

			add(this.complete = new PushButton());
			this.complete.setText("Completed");

			addStyleName("exercise-panel");
			this.setBorderWidth(1);
			this.setSpacing(0);
		}

		static DecoratorPanel populateSets(boolean work, LiftTemplate liftTemplate) {
			DecoratorPanel decorator = new DecoratorPanel();
			decorator.addStyleName("sets-panel");
			decorator.setWidget(populateSetsHelper(work, liftTemplate));
			return decorator;
		}
		
		static FlexTable populateSetsHelper(boolean work, LiftTemplate liftTemplate) {
			int row = 0;
			FlexTable warmupTable = new FlexTable();
			for (RepsTemplate repsTemplate: liftTemplate.getRepsTemplateList().getList()) {
				// TODO: Subclass this, remove the conditional
				if (repsTemplate.getWork() == work) 
					row = generateRow(repsTemplate, row, warmupTable);
			}
			return warmupTable;
//			FlexTable table = exercisePanel.getSets();
//			FlexCellFormatter formatter = table.getFlexCellFormatter();
/*			
			// TODO Move all this into ExercisePanel code
			int row = 0;
			// Iterate through warmup sets
			table.setWidget(row, 0, new HTML("<h2>Warmup</h2>"));
			formatter.setColSpan(row++, 0, 5);
			for (RepsTemplate repsTemplate: liftTemplate.getRepsTemplateList().getList()) {
				// TODO: Subclass this, remove the conditional
				if (!repsTemplate.getWork()) 
					row = generateRow(repsTemplate, row, table);
			}
			table.setWidget(row, 0, new HTML("<h2>Work</h2>"));
			formatter.setColSpan(row++, 0, 5);
			// Iterate through workout sets
			for (RepsTemplate repsTemplate: liftTemplate.getRepsTemplateList().getList()) {
				if (repsTemplate.getWork())
					row = generateRow(repsTemplate, row, table);
			}
*/
		}		
	
		HorizontalPanel createHeader(String type, final DeckPanel parentPanel) {
			HorizontalPanel header = new HorizontalPanel();
			HTML backButton, forwardButton;
			header.add(backButton = createBackButton(parentPanel));
			header.add(this.type = new HTML("<h1>" + type + "</h1>"));
			header.add(forwardButton = createForwardButton(parentPanel));
			header.setCellHorizontalAlignment(backButton, HorizontalPanel.ALIGN_LEFT);
			header.setCellHorizontalAlignment(this.type, HorizontalPanel.ALIGN_CENTER);
			header.setCellHorizontalAlignment(forwardButton, HorizontalPanel.ALIGN_RIGHT);
			header.addStyleName("header");			
			return header;
		}
		
		HTML createBackButton(final DeckPanel parentPanel) {
			HTML backButton = new HTML("&lt; prev");
			backButton.addStyleName("back-button");
			backButton.addClickListener(new ClickListener() {
				public void onClick(Widget sender) {
					System.out.println("clicked back | " + parentPanel.getVisibleWidget());
					if (parentPanel.getVisibleWidget() > 0)
						parentPanel.showWidget(parentPanel.getVisibleWidget()-1);
				}
			});
			return backButton;
		}

		HTML createForwardButton(final DeckPanel parentPanel) {
			HTML forwardButton = new HTML("next &gt;");
			forwardButton.addStyleName("forward-button");
			forwardButton.addClickListener(new ClickListener() {
				public void onClick(Widget sender) {
					System.out.println("clicked forward | " + parentPanel.getVisibleWidget());
					if (parentPanel.getVisibleWidget() < parentPanel.getWidgetCount())
						parentPanel.showWidget(parentPanel.getVisibleWidget()+1);
				}
			});
			return forwardButton;
		}
		
//		FlexTable getSets() {
//			return this.sets;
//		}
	}
	
/*
	public static void labelPanel(FlexTable workoutItemsPanel) {
		int index = 0;
		workoutItemsPanel.setHTML(0, index++, "Exercise");
		workoutItemsPanel.setHTML(0, index++, "Warmup Sets");
		workoutItemsPanel.setHTML(0, index++, "Warmup Reps");
		workoutItemsPanel.setHTML(0, index++, "Your Warmup");
		workoutItemsPanel.setHTML(0, index++, "Workout Sets");
		workoutItemsPanel.setHTML(0, index++, "Workout Reps");
		workoutItemsPanel.setHTML(0, index++, "Your Workout");
		workoutItemsPanel.setHTML(0, index++, "Tempo");
		workoutItemsPanel.setHTML(0, index++, "Rest");
		workoutItemsPanel.setHTML(0, index++, "Notes");
	}
*/
}
