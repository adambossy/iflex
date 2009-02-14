package com.healthySoftware.client.main.build.exerciseSelector;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.healthySoftware.client.FUIContainer;

public class ExerciseSelectorPanel extends VerticalPanel {

	// Type "Map" because it's an associative array
	// TODO: Come up with a better naming convention. Done for these panels and such.
	// Come up with one for the Exercise Items (and all their DAOs)
	public ExerciseSelectorPanel(JSONObject muscleGroupMap, FUIContainer container) {

		// Abstract loop away to a superclass object or make the code inside the
		// loop part of a subclass object
		addStyleName("exercise-selector-panel");
		addHeading(muscleGroupMap.get("name").isString().stringValue());

		ScrollPanel scrollPanel = new ScrollPanel();
		
		VerticalPanel contents = new VerticalPanel();
		contents.setWidth("100%");
		
		// TODO Create unit tests for this JSON passing and clean up this method a bit
		JSONArray typeNamesList = (JSONArray) muscleGroupMap.get("type_names_list");
		JSONArray typeIdsList = (JSONArray) muscleGroupMap.get("type_ids_list");
		for (int i = 0; i < typeNamesList.size(); i++) {
			// TODO: Check if "isString()" is null, and throw error if soy
			int id = (int) typeIdsList.get(i).isNumber().doubleValue();
			String name = typeNamesList.get(i).isString().stringValue();
			contents.add(new ExerciseItem(id, name, container));
		}
		scrollPanel.add(contents);
//		scrollPanel.setHeight("10em");
		scrollPanel.setHeight(""+container.getMuscleGroupSelectorPanel().getOffsetHeight()+"px");
		add(scrollPanel);
	}

	private void addHeading(String name) {
		HTML heading = new HTML(name);
		heading.addStyleName("exercise-selector-panel-heading");
		add(heading);
	}
}
