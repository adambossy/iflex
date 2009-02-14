package com.healthySoftware.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONException;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.healthySoftware.client.util.AJAXObject;
import com.healthySoftware.client.util.GlassPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CopyOffitnessUI implements EntryPoint {

	// TODO: Create build process for Django incorporation. Blog about this.

	// TODO: Abstract all "portlet" calls into subclasses inheriting AJAXObject. OVERWRITE: only important call is the following:
//	public static final String ROOT_URL = "http://173.45.234.154/";
	public static final String ROOT_URL = "http://localhost:8000/";

	public static TemplateProperties properties;
	
//	private static final String JSON_URL = "template_editor/init/?member_id=1";

	private int jsonRequestId = 0;

	DialogBox loading;
	GlassPanel glassPanel;
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// All portlet AJAX retrieval calls should be defined at the top level and propagated downward..? 

		FUIContainer container = new FUIContainer();
		container.setVisible(false);
		
		RootPanel.get().add(container);

		glassPanel = new GlassPanel();
		glassPanel.show();
		
		loading = new DialogBox();
		loading.setText("Loading...");
		// Not an actual hourglass, but has the same effect, nonetheless
		Image hourglass = new Image("http://localhost:8000/media/images/loading_animation.gif");
		loading.setWidget(hourglass);
		loading.setAnimationEnabled(true);
		loading.center();
		loading.show();
		
		String url = ROOT_URL + JSON_URL;
		  
		url = URL.encode(url) + "&callback=";
		InitTemplateEditorService.makeRequest(); // Dispatches to populate service
//		getJson(jsonRequestId++, url, this, container);
	}
	
	public void onModuleLoad2(JSONObject json, FUIContainer container) {
		
		glassPanel.hide();
		loading.hide();
		container.setVisible(true);
		
		properties = new TemplateProperties(container, null, /*false,*/ null);
		
		JSONArray exerciseList = json.get("exercise_list").isArray();
		JSONArray workoutTemplateList = json.get("workout_template_list").isArray();
//		JSONObject saveForm = json.get("save_form").isObject();

		// TODO: Figure out whether the initial AJAX calls get called wholesale or individually. RESOLUTION: Wholesale. 
		// Side-effect: accesses ExerciseSelectionPanel (not modified until next line, currently contains stubs)
//		ExerciseSelectorPanel[] exerciseSelectorPanels = createExerciseSelectionPanels(exerciseList, container); // .getWorkoutBuilderPanel());
		
		container.getMuscleGroupSelectorPanel().populate(exerciseList, container);
//		container.getExerciseSelectorContainer().populate(exerciseSelectorPanels[0]);
		container.getExerciseSelectorContainer().populate(exerciseList, container);
		container.getControlPanel().getLoadAction().populate(workoutTemplateList);
//		container.getControlPanel().getSaveAction().getSaveButton().populate(saveForm, container);
	}		
		// TODO: Add "Load" panel
		// TODO: Add "Exisiting templates" panel (for loading)
		// TODO: Add form (grabbed from Django ModelForm) that has Workout and TemplateCollection names (and other such info)

	public void handleJsonResponse(JavaScriptObject jso, FUIContainer container) {
		if (jso == null) {
			container.getErrorConsole().add("Couldn't retrieve JSON");
			Window.alert("Couldn't retrieve JSON for exercises.");
			return;
		}
		
		// TODO: Include all necessary preliminary information in this single array (not just exercises).
		// They can be aggregated by calling multiple portlets on the Django side. No need for multiple requests.
//		JSONArray data = new JSONArray(jso); // jsonValue.isArray();
		JSONObject json = new JSONObject(jso);
		
		if (json != null) {
			container.getErrorConsole().add("Exercises loaded successfully.");
			onModuleLoad2(json, container);
		} else {
			throw new JSONException();
		}
		
	}
/* 	
	public native static void getJson(int requestId, String url, fitnessUI handler, FUIContainer container) /*-{
		var callback = "_get_json_callback" + requestId;
		
		var script = document.createElement("script");
		script.setAttribute("src", url+callback);
		script.setAttribute("type", "text/javascript");
		
		window[callback] = function(jsonObj) {
			handler.@com.healthySoftware.client.fitnessUI::handleJsonResponse(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/healthySoftware/client/FUIContainer;)(jsonObj, container);
			window[callback + "done"] = true;
		}
		
		// JSON download has 5 second timeout
		setTimeout(function() {
			if (!window[callback + "done"]) {
				handler.@com.healthySoftware.client.fitnessUI::handleJsonResponse(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/healthySoftware/client/FUIContainer;)(null, container);
				window.alert ("Timeout");
			}

			// cleanup
			document.body.removeChild(script);
			delete window[callback];
			delete window[callback + "done"];
		}, 5000);
		
		document.body.appendChild(script);
	}-*/

}
