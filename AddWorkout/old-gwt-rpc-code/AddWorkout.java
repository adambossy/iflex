package com.healthySoftware.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONException;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.healthySoftware.client.util.workout.Sets;
import com.healthySoftware.client.util.workout.Workout;
import com.healthySoftware.client.util.workout.WorkoutItemDAO;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AddWorkout/* extends AJAXObject*/ implements EntryPoint {

	MyLoadWorkoutServiceAsync loadWorkoutService = (MyLoadWorkoutServiceAsync) GWT.create(MyLoadWorkoutService.class);

//	final private String ROOT_URL = "http://localhost:8000/";
	
//	final private String JSON_URL = "workout/fetch_workout_template/1/";
	
	public void onModuleLoad() {
		System.out.println("Running...");
		startupCommandLoadWorkout();
	}

	private void onModuleLoad2(JSONObject json) {
		Workout workout = new Workout(json.get("workout_item_list"));

		FlexTable workoutItemsPanel = new FlexTable();
		int c = 0;
		workoutItemsPanel.setHTML(0, c++, "Exercise");
		workoutItemsPanel.setHTML(0, c++, "Warmup Sets");
		workoutItemsPanel.setHTML(0, c++, "Warmup Reps");
		workoutItemsPanel.setHTML(0, c++, "Your Warmup");
		workoutItemsPanel.setHTML(0, c++, "Workout Sets");
		workoutItemsPanel.setHTML(0, c++, "Workout Reps");
		workoutItemsPanel.setHTML(0, c++, "Your Workout");
		workoutItemsPanel.setHTML(0, c++, "Tempo");
		workoutItemsPanel.setHTML(0, c++, "Rest");
		workoutItemsPanel.setHTML(0, c++, "Notes");

		final DeckPanel displayPanel = new DeckPanel();
		displayPanel.setWidth("200px");
		VerticalPanel[] exercisePanels = new VerticalPanel[workout.getWorkoutItems().size()]; 
		for (WorkoutItemDAO workoutItem: workout.getWorkoutItems()) {
			VerticalPanel exercisePanel = new VerticalPanel();
			exercisePanel.setWidth("100%");
			exercisePanel.add(new HTML("<h3>"+workoutItem.getExerciseType()+"</h3>"));
			exercisePanel.add(new HTML("<h5>WARMUP</h5>"));

			for (int i = 0; i < Integer.parseInt(workoutItem.getWarmupSets()); i++) {
				HorizontalPanel el = new HorizontalPanel();
				el.setWidth("100%");

				TextBox in = new TextBox();
				in.setWidth("2em");
				in.setText(workoutItem.getWarmupReps());

				el.add(in);
				el.add(new HTML("reps"));
			
				in = new TextBox();
				in.setWidth("2em");
				in.setText("140");
				
				el.add(in);
				el.add(new HTML("lbs"));

				exercisePanel.add(el);
			}

			exercisePanel.add(new HTML("<br /><h5>WORK</h5>"));

			for (int i = 0; i < Integer.parseInt(workoutItem.getWorkoutSets()); i++) {
				HorizontalPanel el = new HorizontalPanel();
//				el.setBorderWidth(1);
				el.setWidth("100%");

				TextBox in = new TextBox();
				in.setWidth("2em");
				in.setText(workoutItem.getWorkoutReps());

				el.add(in);
				el.add(new HTML("reps"));
			
				in = new TextBox();
				in.setWidth("2em");
				in.setText("140");
				
				el.add(in);
				el.add(new HTML("lbs"));

				exercisePanel.add(el);
			}

			displayPanel.add(exercisePanel);
		}
		
		displayPanel.showWidget(0);

		DockPanel controlPanel = new DockPanel();
//		controlPanel.setBorderWidth(1);
		HTML next = new HTML("next >");
		controlPanel.add(next, DockPanel.EAST);
		controlPanel.setCellHorizontalAlignment(next, HasHorizontalAlignment.ALIGN_RIGHT); 
		next.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				System.out.println("clicked next");
				if (displayPanel.getVisibleWidget() < displayPanel.getWidgetCount()-1)
					displayPanel.showWidget(displayPanel.getVisibleWidget()+1);
			}
		});
		HTML prev = new HTML("< prev");
		controlPanel.add(prev, DockPanel.WEST);
		prev.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				System.out.println("clicked prev");
				if (displayPanel.getVisibleWidget() > 0)
					displayPanel.showWidget(displayPanel.getVisibleWidget()-	1);
			}
		});
		controlPanel.setWidth("200px");
		
		RootPanel.get().add(displayPanel);
		RootPanel.get().add(new HTML("<br />"));
		RootPanel.get().add(controlPanel);
		RootPanel.get().setHeight("300px");
		
		int r = 1;
		for (WorkoutItemDAO workoutItem: workout.getWorkoutItems()) {
			c = 0;
			workoutItemsPanel.setHTML(r, c++, workoutItem.getExerciseType());
			workoutItemsPanel.setHTML(r, c++, workoutItem.getWarmupSets());
			workoutItemsPanel.setHTML(r, c++, workoutItem.getWarmupReps());

			// Ideally this would be a function called "getUpperBounds(String range)" for
			// ranges denoted as "2-4"
			HorizontalPanel textBoxes = new HorizontalPanel();
			for (int i = 0; i < Integer.parseInt(workoutItem.getWarmupSets()); i++)
				textBoxes.add(new Sets("0"));
			workoutItemsPanel.setWidget(r, c++, textBoxes);

			workoutItemsPanel.setHTML(r, c++, workoutItem.getWorkoutSets());
			workoutItemsPanel.setHTML(r, c++, workoutItem.getWorkoutReps());

			// Ideally this would be a function called "getUpperBounds(String range)" for
			// ranges denoted as "2-4"
			textBoxes = new HorizontalPanel();
			for (int i = 0; i < Integer.parseInt(workoutItem.getWorkoutSets()); i++)
				textBoxes.add(new Sets("0"));
			workoutItemsPanel.setWidget(r, c++, textBoxes);

			workoutItemsPanel.setHTML(r, c++, workoutItem.getTempo());
			workoutItemsPanel.setHTML(r, c++, workoutItem.getRest());
			r++;
		}
/*		
		VerticalPanel workoutItemsPanel = new VerticalPanel();
		HorizontalPanel workoutItemPanel = new HorizontalPanel(); 
		workoutItemPanel.add(new HTML("Exercise"));
		workoutItemPanel.add(new HTML("Warmup Sets"));
		workoutItemPanel.add(new HTML("Warmup Reps"));
		workoutItemPanel.add(new HTML("Your Warmup"));
		workoutItemPanel.add(new HTML("Workout Sets"));
		workoutItemPanel.add(new HTML("Workout Reps"));
		workoutItemPanel.add(new HTML("Your Workout"));
		workoutItemPanel.add(new HTML("Tempo"));
		workoutItemPanel.add(new HTML("Rest"));
		workoutItemsPanel.add(workoutItemPanel);

		for (WorkoutItemDAO workoutItem: workout.getWorkoutItems()) {
			workoutItemPanel = new HorizontalPanel(); 
			workoutItemPanel.add(new HTML(workoutItem.getExerciseType()));
			workoutItemPanel.add(new HTML(workoutItem.getWarmupSets()));
			workoutItemPanel.add(new HTML(workoutItem.getWarmupReps()));
			workoutItemPanel.add(new HTML("stub"));
			workoutItemPanel.add(new HTML(workoutItem.getWorkoutSets()));
			workoutItemPanel.add(new HTML(workoutItem.getWorkoutReps()));
			workoutItemPanel.add(new HTML("stub"));
			workoutItemPanel.add(new HTML(workoutItem.getTempo()));
			workoutItemPanel.add(new HTML(workoutItem.getRest()));
			workoutItemsPanel.add(workoutItemPanel);
		}
*/		
		Button add = new Button("add");
		Button clear = new Button("clear");

//		RootPanel.get().add(workoutItemsPanel);
//		RootPanel.get().add(add);
//		RootPanel.get().add(clear);
	}

	public void handleJsonResponse(/*JsonSerializable */String json) {
  		if (json == null) {
  			// Error
  			return;
  		}
  		
//  		JSONObject json = new JSONObject(jso);
  		
  		if (json != null) {
  			// Success
//  			final JsonSerializer serializer = (JsonSerializer) GWT.create(HasIntField.class);
//  			final JSONObject jsonObject = (JSONObject) serializer.writeJson(json); // json is of type HasIntField
  			System.out.println (json);
//  			onModuleLoad2(jsonObject);
  		} else {
  			throw new JSONException();
  		}
  	}
  	
	public void startupCommandLoadWorkout() {
		loadWorkoutService.loadWorkout(new AsyncCallback</*HasIntField*/String>() {
			public void onSuccess(/*HasIntField */String result) {
				Window.alert("result:"+result);
				JSONObject jsonObj = new JSONObject(fromJSONString(result));
				Window.alert(jsonObj.get("str") + " | " + jsonObj.get("int"));
				handleJsonResponse(result);
			}

			public void onFailure(Throwable caught) {
				System.out.println();
			}
		});

		// (3) Make the call. Control flow will continue immediately and later
		// 'callback' will be invoked when the RPC completes.
		//
	}

    public static native JavaScriptObject fromJSONString(
            String jsonString) /*-{
        return eval('(' + jsonString + ')');
    }-*/;
}
