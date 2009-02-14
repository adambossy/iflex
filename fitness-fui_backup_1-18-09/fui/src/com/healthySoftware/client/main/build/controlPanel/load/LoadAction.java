package com.healthySoftware.client.main.build.controlPanel.load;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONException;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Widget;
import com.healthySoftware.client.FUIContainer;
import com.healthySoftware.client.fitnessUI;
import com.healthySoftware.client.main.build.workoutBuilder.BuilderItem;
import com.healthySoftware.client.util.AJAXObject;

public class LoadAction extends AJAXObject {

	private LoadButton loadButton = null;
	
	private LoadDialog loadDialog = null;
	
	private int jsonRequestId = 0;
	
	private String JSON_URL = "template_editor/load/";

	public LoadAction(FUIContainer container) {
		loadButton = new LoadButton(this);
		loadDialog = new LoadDialog(this, container);
	}
	
	public void populate(JSONArray workoutTemplateList) {
		loadDialog.populate(workoutTemplateList);
		loadButton.setEnabled(true);
	}

	void loadTemplate(FUIContainer container) {
		String url = fitnessUI.ROOT_URL + JSON_URL;
		url = URL.encode(url) + "?workout_template_id=" + fitnessUI.properties.getTemplateId() + "&callback=";
		System.out.println(url);
		getJson(jsonRequestId++, url, container.getControlPanel().getLoadAction(), container);
	}
	
	@Override
	public void handleJsonResponse(JavaScriptObject jso, FUIContainer container) throws JSONException {
		if (jso == null) {
			Window.alert("Fitness UI timed out. Your file was not saved. Please try again later.");
			return;
		}

		JSONObject jsonObject = new JSONObject(jso);

		if (jsonObject != null) {
//			ArrayList<BuilderItem> loadedTemplate = disassemble(jsonObject);
			load(jsonObject, container);
//			SaveCallback callback = new SaveCallback(jsonObject);
//			if (callback.success) {
//				container.getHeader().setName(callback.name); //, callback.collection);
//				container.getErrorConsole().add("Saved! To Template Collection " + callback.collection + " as Workout '" + callback.name + "'");
				container.getErrorConsole().add("Loaded!");
//			}
//			else
//				for (String message: callback.messages) {
//					container.getErrorConsole().add(message);
//					Window.alert("Error!\n" + message);
//				}
		} else {
			throw new JSONException();
		}
	}

	public native static void getJson(int requestId, String url, LoadAction handler, FUIContainer container) /*-{	
		var callback = "_load_template_callback" + requestId;
		
		var script = document.createElement("script");
		script.setAttribute("src", url+callback);
		script.setAttribute("type", "text/javascript");
		
		window[callback] = function(jsonObj) {
			handler.@com.healthySoftware.client.main.build.controlPanel.load.LoadAction::handleJsonResponse(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/healthySoftware/client/FUIContainer;)(jsonObj, container);
			window[callback + "done"] = true;
		}
		
		// JSON download has 5 second timeout
		setTimeout(function() {
			if (!window[callback + "done"]) {
				handler.@com.healthySoftware.client.main.build.controlPanel.load.LoadAction::handleJsonResponse(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/healthySoftware/client/FUIContainer;)(null, container);
				window.alert ("Timeout");
			}
	
			// cleanup
			document.body.removeChild(script);
			delete window[callback];
			delete window[callback + "done"];
		}, 5000);
		
		document.body.appendChild(script);
	}-*/;

	public Button getLoadButton() {
		return loadButton;
	}

	public void setLoadButton(LoadButton loadButton) {
		this.loadButton = loadButton;
	}

	public LoadDialog getLoadDialog() {
		return loadDialog;
	}

	public void setLoadDialog(LoadDialog loadDialog) {
		this.loadDialog = loadDialog;
	}

//	private class TemplateLoader {
		
		// Terribly inefficient, a better solution is necessary 
//		List<BuilderItem> disassemble(JSONObject jsonObject, FUIContainer container) {
		void load(JSONObject jsonObject, FUIContainer container) {
			// TODO: Ensure Python is passing an actual JSONArray
/*			JSONObject array = jsonObject.isArray();
			if (array == null)
				throw new IllegalArgumentException("cannot load non-array template file");
			
			int templateId = -1;
			String templateName = null;
			
			HashMap<Integer, String> exerciseTemplates = new HashMap<Integer, String>();
			HashMap<Integer, String> exerciseType = new HashMap<Integer, String>();
			HashMap<Integer, Object[]> liftTemplates = new HashMap<Integer, Object[]>();
			HashMap<Integer, LinkedList<Object[]>> repsTemplates = new HashMap<Integer, LinkedList<Object[]>>();

			for (int index=0; index<array.size(); index++) {
				JSONObject object = (JSONObject) array.get(index);
				int pk = (int) object.get("pk").isNumber().doubleValue();
				String model = object.get("model").isString().stringValue();
				JSONObject fields = (JSONObject) object.get("fields");
				
				if (model.equals("template_editor.workouttemplate")) {
					templateId = pk;
					templateName = fields.get("name").isString().stringValue();
					
					fitnessUI.properties.setTemplateId(templateId);
					fitnessUI.properties.setTemplateName(templateName);
//					fields.get("author")
					
				} else if (model.equals("template_editor.exercisetemplate")) {
//					BuilderItem item = new BuilderItem(pk, name, container, rest, notes);
					String notes = fields.get("notes").isString().stringValue();
					exerciseTemplates.put(pk, notes);
					
				} else if (model.equals("exercises.exercisetype")) {
					String typeName = fields.get("name").isString().stringValue();
					exerciseType.put(pk, typeName);
					
				} else if (model.equals("template_editor.lifttemplate")) {
					String rest = fields.get("fields").isString().stringValue();
					int type = (int) fields.get("type").isNumber().doubleValue();
					int exerciseTemplate = (int) fields.get("exercise_template").isNumber().doubleValue();
					liftTemplates.put(pk, new Object[] { rest, type, exerciseTemplate });
					
				} else if (model.equals("template_editor.repstemplate")) {
					boolean work = fields.get("work").isBoolean().booleanValue();
					String reps = fields.get("reps").isString().stringValue();
					int liftTemplate = (int) fields.get("lift_template").isNumber().doubleValue();
//					repsTemplates.put(pk, new Object[] { work, reps, liftTemplate });

					LinkedList<Object[]> repsList = repsTemplates.get(liftTemplate);
					if (repsList == null)
						repsList = new LinkedList<Object[]>();
					repsList.add(new Object[] { work, reps });
					
				}
			}

			List<BuilderItem> builderItemList = new ArrayList<BuilderItem>();

			container.getWorkoutBuilderPanel().clearList();
			for (Map.Entry<Integer, Object[]> entry: liftTemplates.entrySet()) {
				int pk = entry.getKey();
				Object[] values = entry.getValue();

				builderItemList.add(new BuilderItem(pk,
						exerciseType.get(values[1]),
						container,
						getReps(repsTemplates.get(pk), false),
						getReps(repsTemplates.get(pk), true),
						values[0].toString(),
						exerciseTemplates.get(values[2])));

				container.getWorkoutBuilderPanel().addItem(pk,
						exerciseType.get(values[1]),
						container,
						getReps(repsTemplates.get(pk), false),
						getReps(repsTemplates.get(pk), true),
						values[0].toString(),
						exerciseTemplates.get(values[2]));
			}
//			return builderItemList;
*/
		}
			
		private String[] getReps(LinkedList<Object[]> repsList, boolean work) {
			ArrayList<String> newReps = new ArrayList<String>();
			for (Object[] data: repsList) {
				if ((Boolean) data[0] == work)
					newReps.add(data[1].toString());
			}
			String[] res = new String[newReps.size()];
			return newReps.toArray(res);
		}
//	}
}
