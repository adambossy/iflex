package com.healthySoftware.client.controlPanel;

public class JSONRequestSkeletonNoSOP {
	private int jsonRequestId = 0;
	
	public SaveButton(final FUIContainer container, final FormPanel form,
			final Panel errorPanel) {
		setText("Save As... (will save a new copy)");
		addStyleName("print-button");
		final SaveButton self = this;
		addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				String url = "http://localhost:8000/template_editor/save/1/";
				  
				url = URL.encode(url) + "?" + formatTemplate(container.getWorkoutBuilderPanel().getExerciseList()) + "&callback=";
//				getJson(jsonRequestId++, url, self, errorPanel);
				saveTemplate(jsonRequestId++, url, self, errorPanel);
			}
		});
	}
	
	private void confirmSave(JSONArray template, Panel errorPanel) {
		errorPanel.add(new HTML("Saved! To Template Collection ... as Workout ' '"));
//		errorPanel.add(new HTML(template.get(0)));
	}

//	@SuppressWarnings
	private void handleJsonResponse(JavaScriptObject jso, Panel errorPanel) {
		System.out.println("Called correctly.");
		if (jso == null) {
//			errorPanel.add(new HTML("Couldn't retrieve JSON");
			Window.alert("Saving template failed.");
			return;
		}
		
		JSONArray jsonArray = new JSONArray(jso); // jsonValue.isArray();
		System.out.println ("JSON ARRAY: " + jsonArray);

		if (jsonArray != null) {
//			onModuleLoad2(jsonArray, errorPanel);
			Window.alert("JSON response succeeded.");
			confirmSave(jsonArray, errorPanel);			
		} else {
			throw new JSONException();
		}
		
	}
	
	private native static void saveTemplate(int requestId, String url, SaveButton handler, Panel errorPanel) /*-{	
		var callback = "callback" + requestId;
		
		var script = document.createElement("script");
		script.setAttribute("src", url+callback);
		script.setAttribute("type", "text/javascript");
		
		window[callback] = function(jsonObj) {
			handler.@com.healthySoftware.client.controlPanel.SaveButton::handleJsonResponse(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/user/client/ui/Panel;)(jsonObj, errorPanel);
			window[callback + "done"] = true;
		}
		
		// JSON download has 2 second timeout
		setTimeout(function() {
			if (!window[callback + "done"]) {
				handler.@com.healthySoftware.client.controlPanel.SaveButton::handleJsonResponse(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/user/client/ui/Panel;)(null, errorPanel);
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
