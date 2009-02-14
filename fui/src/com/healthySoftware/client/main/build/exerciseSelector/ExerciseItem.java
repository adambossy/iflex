package com.healthySoftware.client.main.build.exerciseSelector;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;
import com.healthySoftware.client.FUIContainer;

public class ExerciseItem extends HorizontalPanel {

	// String name = new String();

	ExerciseItem(final int id, final String name, final FUIContainer container) {

		addStyleName("exercise-selector-panel-element");

		// this.name = name;
		HTML label = new HTML(name);
		label.addStyleName("exercise-selector-panel-element-label");
		add(label);
		setWidth("100%");

		// Somehow make this a button
		// HTML add = new HTML("[+]");
		// TODO: Make the entire HorizontalPanel a PushButton
		AddButton addButton; 
		add(addButton = new AddButton(id, name, container));
		this.setCellWidth(addButton, "32px");
	}

	private class AddButton extends PushButton {
		AddButton(final int id, final String name, final FUIContainer container) {
			addClickListener(new ClickListener() {
				public void onClick(Widget sender) {
					// Action to add exercise type to My Workout
					// TODO: Copy attributes from previous workout
					container.getWorkoutBuilderPanel().addItem(id, name, container);
				}
			});
			setHTML(new HTML("[+]").toString());
			addStyleName("exercise-selector-panel-element-add");
		}
	}
}
