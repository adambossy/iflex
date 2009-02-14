package com.healthySoftware.client.main.build.controlPanel;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONException;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.healthySoftware.client.FUIContainer;

public class WorkoutTemplateForm extends HTML {
	private int jsonRequestId = 0;
	
	// TODO: ErrorPanel should be gettable() from the container
	public WorkoutTemplateForm(FUIContainer container, Panel errorPanel) {
		this.setText("");
		
		String url = "http://localhost:8000/template_editor/workout_template_form/";
		url = URL.encode(url) + "?callback=";
		fetchWorkoutTemplateForm(jsonRequestId++, url, this, container, errorPanel);
	}
	
//	private void confirmSave(JSONArray template, Panel errorPanel) {
//		errorPanel.add(new HTML("Saved! To Template Collection ... as Workout ' '"));
//	}

//	@handleJsonResponse SuppressWarnings
	private void handleJsonResponse(JavaScriptObject jso, FUIContainer container, Panel errorPanel) {
		System.out.println("wtf hjr called correctly.");
		if (jso == null) {
//			errorPanel.add(new HTML("Couldn't retrieve JSON");
			Window.alert("Fetching workout template form failed.");
			return;
		}
		
		JSONArray jsonArray = new JSONArray(jso);
//		JSONObject jsonObject = new JSONObject(jso);
		JSONString jsonString = jsonArray.get(0).isString();
		// TODO: Throw some error if this is not a string (it always should be)
		
		System.out.println ("jso: " + jsonString);

		if (jso != null) {
//			Window.alert("wtf JSON response succeeded.");
			errorPanel.add(new HTML("wtf Fetched!"));
			// TODO: Create a "proper" procedure by which to add this
			ControlPanel controlPanel = container.getControlPanel();  
//			Window.alert(controlPanel.toString());
			HTML table = new HTML(jsonString.stringValue());
			table.addStyleName("print-button");
//			Window.alert(table.toString());
			controlPanel.add(table);
//			Window.alert("table added");
//			confirmSave(jsonArray, errorPanel);			
		} else {
			throw new JSONException();
		}
		
	}
	
	private native static void fetchWorkoutTemplateForm(int requestId, String url, WorkoutTemplateForm handler, FUIContainer container, Panel errorPanel) /*-{	
		var callback = "_fetch_workout_template_form_callback" + requestId;
		
		var script = document.createElement("script");
		script.setAttribute("src", url+callback);
		script.setAttribute("type", "text/javascript");
		
		window[callback] = function(jsonObj) {
			handler.@com.healthySoftware.client.controlPanel.WorkoutTemplateForm::handleJsonResponse(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/healthySoftware/client/FUIContainer;Lcom/google/gwt/user/client/ui/Panel;)(jsonObj, container, errorPanel);
			window[callback + "done"] = true;
		}
		
		// JSON download has 2 second timeout
		setTimeout(function() {
			if (!window[callback + "done"]) {
				handler.@com.healthySoftware.client.controlPanel.WorkoutTemplateForm::handleJsonResponse(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/healthySoftware/client/FUIContainer;Lcom/google/gwt/user/client/ui/Panel;)(null, container, errorPanel);
				window.alert ("Timeout");
			}
	
			// cleanup
			document.body.removeChild(script);
			delete window[callback];
			delete window[callback + "done"];
		}, 2000);
		
		document.body.appendChild(script);
	}-*/;
}
