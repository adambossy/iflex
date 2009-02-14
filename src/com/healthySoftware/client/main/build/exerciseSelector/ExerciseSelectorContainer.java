package com.healthySoftware.client.main.build.exerciseSelector;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.DeckPanel;
import com.healthySoftware.client.FUIContainer;

public class ExerciseSelectorContainer extends DeckPanel { // TODO: Investigate why DeckPanel doesn't work here

//	SearchBox searchBox = null;

//	ExerciseSelectorPanel activePanel = null;
	
//	AddBox addBox = null;
	
	ExerciseSelectorPanel[] panels = null;
	
	private static final String CSS_EXERCISE_SELECTOR_CONTAINER = "exercise-selector-container";
	
	public ExerciseSelectorContainer() {
		super();
//		add(new HTML("placeholder"));
		addStyleName(CSS_EXERCISE_SELECTOR_CONTAINER);
	}

//	public void populate(ExerciseSelectorPanel defaultPanel) {
//		add(defaultPanel);
//		xsactivePanel = defaultPanel;
	public void populate(JSONArray exercises, FUIContainer container) {
//		private ExerciseSelectorPanel[] createExerciseSelectionPanels(JSONArray exercises, FUIContainer container) {
		// Weird design choice, I know. Trying to make Java feel more like Python here.
		for (int i = 0; i < exercises.size(); i++)
//				JSONObject muscleGroupMap = (JSONObject) exercises.get(i);
			add(new ExerciseSelectorPanel((JSONObject) exercises.get(i), container));
		this.showWidget(0);
//		setWidth("100%");
//		setHeight("100%");
	}
	
	/**
	 * @param container - container which contains WorkoutBuilderPanel object that these
	 *            panel objects will ultimately be added to
	 * @return
	 */
//	public void swap(ExerciseSelectorPanel newPanel) {
//		remove(activePanel);
//		add(newPanel);
//		activePanel = newPanel;
//	}
	
	public void swap(int index) {
		showWidget(index);
//		remove(activePanel);
//		add(panels[index]);
//		activePanel = panels[index];
	}

//	public ExerciseSelectorPanel getActivePanel() {
//		return activePanel;
//	}
/*
	public int getActivePanel() {
		return getVisibleWidget();
	}

	public void setActivePanel(int index) {
		showWidget(index);
	}
*/
//	public void setActivePanel(ExerciseSelectorPanel activePanel) {
//		this.activePanel = activePanel;
//	}

	public ExerciseSelectorPanel[] getPanels() {
		return panels;
	}

	public void setPanels(ExerciseSelectorPanel[] panels) {
		this.panels = panels;
	}
}
