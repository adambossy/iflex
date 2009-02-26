/*
 * Copyright 2008 Fred Sauer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.healthySoftware.client.main.build.muscleGroupSelector;

import java.util.ArrayList;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.healthySoftware.client.FUIContainer;
import com.healthySoftware.client.main.build.exerciseSelector.ExerciseSelectorPanel;
import com.healthySoftware.client.util.StringUtil;

public class MuscleGroupSelectorPanel extends VerticalPanel {

	final int QUADRICEPS_BUTTON = 0;
	final int HAMSTRINGS_BUTTON = 1;
	final int CALVES_BUTTON = 2;

	// final int LOWER_BACK_BUTTON = 3;
	// final int LATS_BUTTON = 4;
	// final int UPPER_BACK_BUTTON = 5;
	// final int TRAPS_BUTTON = 6;
	// final int PECS_BUTTON = 7;
	// final int SHOULDERS_BUTTON = 8;
	// final int TRICEPS_BUTTON = 9;
	// final int BICEPS_BUTTON = 10;
	// final int ABS_BUTTON = 11;

//	private static final String CSS_DEMO_BEHAVIOR_HEADING = "demo-behavior-heading";

	private static final String MUSCLE_GROUP_SELECTOR_PANEL = "muscle-group-selector-panel";

	public MuscleGroupSelectorPanel() { //String muscleGroupName) {
		addStyleName(MUSCLE_GROUP_SELECTOR_PANEL);
//		HTML heading = new HTML(muscleGroupName);
//		heading.addStyleName(CSS_DEMO_BEHAVIOR_HEADING);
//		heading.setTitle(tooltip);
//		add(heading);
	}
	
	public void populate(JSONArray exerciseList, final FUIContainer container) {

		// Using ArrayList to try to emulate Python-style coding in Java
		final ArrayList<RadioButton> muscleGroupButtons = new ArrayList<RadioButton>(exerciseList.size());

		for (int i = 0; i < exerciseList.size(); i++) {
			JSONObject map = (JSONObject) exerciseList.get(i); 
			muscleGroupButtons.add(newButton(map.get("name").isString().stringValue(), null));
			add(muscleGroupButtons.get(muscleGroupButtons.size() - 1));
		}

		// Set first item in list to checked
		muscleGroupButtons.get(0).setChecked(true);

		for (int group = 1; group < muscleGroupButtons.size(); group++)
			muscleGroupButtons.get(group).setChecked(false);

		ClickListener listener = new ClickListener() {
			public void onClick(Widget sender) {
				int index = -1;
				for (int group = 0; index == -1 && group < muscleGroupButtons.size(); group++) {
					if (muscleGroupButtons.get(group).isChecked())
						index = group;
				}
//				container.setExerciseSelectorPanel(exerciseSelectorPanels[index]);
				container.setExerciseSelectorPanel(index);
			}
		};

		for (int group = 0; group < muscleGroupButtons.size(); group++)
			muscleGroupButtons.get(group).addClickListener(listener);
	}

	protected RadioButton newButton(String description, String tooltip) {
		RadioButton radioButton = new RadioButton(StringUtil.getShortTypeName(this), description, true);
		radioButton.setTitle(tooltip);
		return radioButton;
	}
}
