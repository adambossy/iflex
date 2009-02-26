package com.healthySoftware.client.main.build.exerciseSelector;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.healthySoftware.client.FUIContainer;

public class ExerciseItem extends HorizontalPanel {

	// String name = new String();

	ExerciseItem(final int id, final String name, final FUIContainer container) {

//		this.setBorderWidth(1);
		
		addStyleName("exercise-selector-panel-element");

		Image thumbnail = new Image("http://localhost:8000/media/images/exercises/barbell-bench-press-incline-small.png");
		thumbnail.addStyleName("exercise-selector-panel-element-thumbnail");
//		thumbnail.setSize("66%", "66%");
		add(thumbnail);
//		setCellWidth(thumbnail, thumbnail.getWidth()+"px");
		
		// this.name = name;
		HTML label = new HTML("<div id=\"wrapper\">" + name + "</div>");
		label.addStyleName("exercise-selector-panel-element-label");
		setCellVerticalAlignment(label, HorizontalPanel.ALIGN_MIDDLE);
		add(label);
		setCellWidth(label, "100%");

		setWidth("100%");

		// Somehow make this a button
		// HTML add = new HTML("[+]");
		// TODO: Make the entire HorizontalPanel a PushButton
		AddButton addButton; 
		add(addButton = new AddButton(id, name, container));
		addButton.setHTML("<img src=\"http://localhost:8000/media/images/icons/add.png\" />");
		setCellVerticalAlignment(addButton, HorizontalPanel.ALIGN_MIDDLE);
		setCellWidth(addButton, "32px");
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
