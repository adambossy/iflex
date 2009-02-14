package com.healthySoftware.client.main.build.controlPanel.save;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONException;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.healthySoftware.client.FUIContainer;
import com.healthySoftware.client.fitnessUI;
import com.healthySoftware.client.main.build.workoutBuilder.BuilderItem;
import com.healthySoftware.client.util.AJAXObject;

public class SaveAction extends AJAXObject {

	private SaveButton saveButton = null;
	
	private SaveAsButton saveAsButton = null;
	
	private SaveDialog saveDialog = null;
	
//	private ClickListener clickListener = null;
	
	private boolean isSaved = false;
	
	private int jsonRequestId = 0;
	
	private String JSON_URL = "template_editor/save/1/";
	
//	private String name = null;
	
//	private String collection = null;
	
	public SaveAction(final FUIContainer container) {
		saveButton = new SaveButton(this, container);
		saveAsButton = new SaveAsButton(this);
		saveDialog = new SaveDialog(this, container);
//		clickListener = createClickListener(saveDialog, container);
	}
	
	/**
	 * If we get this back, then display the message to the user (whether is be success or failure).
	 */
	@Override
	public void handleJsonResponse(JavaScriptObject jso, FUIContainer container) throws JSONException {
		if (jso == null) {
			Window.alert("Fitness UI timed out. Your file was not saved. Please try again later.");
			return;
		}

		JSONObject jsonObject = new JSONObject(jso);

		if (jsonObject != null) {
			SaveCallback callback = new SaveCallback(jsonObject);
			if (callback.success) {
//				fitnessUI.properties.setSaved(true);
				fitnessUI.properties.setTemplateId(callback.id);
				fitnessUI.properties.setTemplateName(callback.name);
				container.getHeader().setName(callback.name); //, callback.collection);
//				container.getErrorConsole().add("Saved! To Template Collection " + callback.collection + " as Workout '" + callback.name + "'");
				container.getErrorConsole().add("Saved! Workout named '" + callback.name + "'");
			}
			else
				for (String message: callback.messages) {
					container.getErrorConsole().add(message);
					Window.alert("Error!\n" + message);
				}
		} else {
			throw new JSONException();
		}
	}

	public native static void getJson(int requestId, String url, SaveAction handler, FUIContainer container) /*-{	
		var callback = "_save_template_callback" + requestId;
		
		var script = document.createElement("script");
		script.setAttribute("src", url+callback);
		script.setAttribute("type", "text/javascript");
		
		window[callback] = function(jsonObj) {
			handler.@com.healthySoftware.client.main.build.controlPanel.save.SaveAction::handleJsonResponse(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/healthySoftware/client/FUIContainer;)(jsonObj, container);
			window[callback + "done"] = true;
		}
		
		// JSON download has 5 second timeout
		setTimeout(function() {
			if (!window[callback + "done"]) {
				handler.@com.healthySoftware.client.main.build.controlPanel.save.SaveAction::handleJsonResponse(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/healthySoftware/client/FUIContainer;)(null, container);
				window.alert ("Timeout");
			}
	
			// cleanup
			document.body.removeChild(script);
			delete window[callback];
			delete window[callback + "done"];
		}, 5000);
		
		document.body.appendChild(script);
	}-*/;

//	public ClickListener createClickListener(final SaveDialog self, final FUIContainer container) {
//		return new ClickListener() {
//			public void onClick(Widget sender) {
//				String url = fitnessUI.ROOT_URL + JSON_URL;
//				String templateStream = serializeTemplate(
////						container.getWorkoutBuilderPanel().getExerciseList(),
//						fitnessUI.properties.getExerciseList(),
//						fitnessUI.properties.getTemplateName(),
////						saveDialog.getName().getText(),
//						null,
//						null
////						saveDialog.getPosition().getValue(saveDialog.getPosition().getSelectedIndex()),
////						saveDialog.getCollection().getValue(saveDialog.getCollection().getSelectedIndex())
//				);
//				url = URL.encode(url) + "?" + templateStream + "&callback=";
//				System.out.println(url);
//				getJson(jsonRequestId++, url, container.getControlPanel().getSaveAction(), container);
//				self.hide();
//			}
//		};
//	}

	public void saveTemplate(FUIContainer container) {
		String url = fitnessUI.ROOT_URL + JSON_URL;
		String templateStream = serializeTemplate(
				fitnessUI.properties.getExerciseList(),
				fitnessUI.properties.getTemplateName()
		);
		url = URL.encode(url) + "?" + templateStream + "&callback=";
		System.out.println(url);
//		getJson(jsonRequestId++, url, container.getControlPanel().getSaveAction(), container);
		getJson(jsonRequestId++, url, this, container);
	}
	
	/**
	 * @return a String containing the serialized json in a format the can be read as a URL
	 */
	private String serializeTemplate(List<BuilderItem> exerciseList, String name) {//, String position, String collection) {
		JSONObject json = new JSONObject();
		json.put("exercise_list", serializeExerciseList(exerciseList));
//		json.put("metadata", serializeMetadata(name, position, collection));
//		return "template="+json.toString();
		System.out.println("exercise_list: " + json.toString().replace(" ", ""));
//		return ("template="+json.toString()+serializeMetadata(name, position, collection)).replace(" ", "");
		return ("template="
				+ json.toString()
				+ serializeMetadata(name)
				+ (fitnessUI.properties.getTemplateId() == -1 ? "" : "&workout_template_id="+fitnessUI.properties.getTemplateId())
				).replace(" ", "");
	}
	
	/**
	 * 
	 * @param exerciseList
	 * @return JSON data
	 */
	private JSONArray serializeExerciseList(List<BuilderItem> exerciseList) {
		JSONArray exerciseTemplates = new JSONArray();
		for (BuilderItem item : exerciseList) {
			JSONObject json = new JSONObject();
			json.put("typeId", new JSONNumber(item.getTypeId()));
			json.put("warmup_reps", serializeReps(item.getWarmupReps()));
			json.put("workout_reps", serializeReps(item.getWorkoutReps()));
			json.put("rest", new JSONString(item.getRest()));
			json.put("notes", new JSONString(item.getNotes()));
			exerciseTemplates.set(exerciseTemplates.size(), json);
		}
		return exerciseTemplates;
	}
	
	private JSONArray serializeReps(String[] reps) {
		JSONArray jsonReps = new JSONArray(); 
		for (int i = 0; i < reps.length; i++)
			jsonReps.set(i, new JSONString(reps[i]));
		return jsonReps;
	}

	/**
	 * 
	 * @return String containing metadata in querystring format
	 */
//	private String serializeMetadata(JSONFormObject form) {
	private String serializeMetadata(String name) { //, String position, String collection) {	
		// Make dictionary so that it's easily validated in Django's ModelForm 
		StringBuffer sb = new StringBuffer();
		sb.append("&name="+name);
//		sb.append("&position="+position);
//		sb.append("&collection="+collection);
//		sb.append('&'+form.getHTML("name.html_name")+'='+);
		return sb.toString();
	}

	public SaveButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(SaveButton saveButton) {
		this.saveButton = saveButton;
	}

	public SaveAsButton getSaveAsButton() {
		return saveAsButton;
	}

	public void setSaveAsButton(SaveAsButton saveAsButton) {
		this.saveAsButton = saveAsButton;
	}

	public SaveDialog getSaveDialog() {
		return saveDialog;
	}

	public void setSaveDialog(SaveDialog saveDialog) {
		this.saveDialog = saveDialog;
	}
	
	public boolean isSaved() {
		return isSaved;
	}

	public void setSaved(boolean isSaved) {
		this.isSaved = isSaved;
	}
	
	private class SaveCallback {

		public boolean success;
		public String[] messages;
		public int id;
		public String name;
//		public String collection;
		
		SaveCallback(JSONObject jsonObject) {
			success = jsonObject.get("success").isBoolean().booleanValue();
			messages = arrayValue(jsonObject.get("success").isArray());
			id = (int) jsonObject.get("id").isNumber().doubleValue();
			name = jsonObject.get("name").isString().stringValue();
//			collection = jsonObject.get("collection").isString().stringValue();
		}
		
		String[] arrayValue(JSONArray array) {
			if (array == null)
				return null;
			messages = new String[array.size()];
			for (int index = 0; index < array.size(); index++)
				messages[index] = array.get(index).isString().stringValue();
			return messages;
		}
	}
}
