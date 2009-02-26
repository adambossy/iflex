package com.healthySoftware.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.healthySoftware.client.util.GlassPanel;
import com.healthySoftware.client.util.services.ServicePopulator;
import com.healthySoftware.client.util.services.template_editor.InitTemplateEditorServiceImpl;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class fitnessUI implements EntryPoint, ServicePopulator {

	// TODO: Create build process for Django incorporation to GWT projects. Blog
	// about this.
	// TODO (old): Add "Load" panel
	// TODO (old): Add "Existing templates" panel (for loading)
	// TODO (old): Add form (grabbed from Django ModelForm) that has Workout and
	// TemplateCollection names (and other such info)

	// DAO for storing rudimentary template information at a high-level (name,
	// id, etc.)
	public static TemplateProperties properties;

	DialogBox loading;

	GlassPanel glassPanel;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// All portlet AJAX retrieval calls should be defined at the top level
		// and propagated downward..?

		FUIContainer container = new FUIContainer();
		container.setVisible(false);

//		RootPanel.get().add(container);
		RootPanel.get("body").add(container);

		glassPanel = new GlassPanel();
		// properties.setGlassPanel(glassPanel);
		glassPanel.show();

		loading = new DialogBox();
		// properties.setLoading(loading);
		loading.setText("Loading...");
		// Not an actual hourglass, but has the same effect, nonetheless
		Image hourglass = new Image(
				"http://localhost:8000/media/images/loading_animation.gif");
		loading.setWidget(hourglass);
		loading.setAnimationEnabled(true);
		loading.center();
		loading.show();

		InitTemplateEditorServiceImpl init = new InitTemplateEditorServiceImpl();

		init.setServicePopulatorInstance(this);

		init.makeRequest(null, container); // Dispatches to populate service

		// String url = ROOT_URL + JSON_URL;
		// url = URL.encode(url) + "&callback=";
		// getJson(jsonRequestId++, url, this, container);
	}

	// public void populateTemplateEditor(JSONObject json, FUIContainer
	// container) {
	public void execute(String jsonArray, FUIContainer container) {
		glassPanel.hide();
		loading.hide();
		container.setVisible(true);

		properties = new TemplateProperties(container, null, /* false, */null);

		// JSONObject jsonObj = jsonArray.get(0).isObject();
		JSONObject jsonObj = JSONParser.parse(jsonArray).isObject();

		// System.out.println()

		JSONArray exerciseList = jsonObj.get("exercise_list").isArray();
		JSONArray workoutTemplateList = jsonObj.get("workout_template_list")
				.isArray();

		// TODO: Figure out whether the initial AJAX calls get called wholesale
		// or individually. RESOLUTION: Wholesale.

		container.getMuscleGroupSelectorPanel().populate(exerciseList,
				container);
		container.getExerciseSelectorContainer().populate(exerciseList,
				container);
		container.getControlPanel().getLoadAction().populate(
				workoutTemplateList);
	}
}