package com.healthySoftware.client.main.build.workoutBuilder;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.healthySoftware.client.FUIContainer;

public class RepsContainer extends HorizontalPanel {

	RepsList repsList;
	
	public RepsContainer(String[] reps, FUIContainer container) {
		repsList = new RepsList();
		// REPS NEED DELETE FUNCTIONALITY
		if (reps != null && reps.length > 0)
			for (String numReps: reps)
				repsList.add(new Reps(repsList, numReps));
		else
			repsList.add(new Reps(repsList, null));
		super.add(repsList);
		super.add(new AddRepsButton(repsList, container));
		addStyleName("reps-container");
	}
	
	public String[] getReps() { // int index) {
//		RepsContainer repsContainer = (RepsContainer) this.getWidget(index);
		String[] reps = new String[repsList.getWidgetCount()];
		for (int i = 0; i < repsList.getWidgetCount(); i++)
			reps[i] = repsList.getReps(i);
		return reps;
	}

	// TODO Make AddRepsButton a subclass of this class ? (should probably be constructed in RepsContainer constructor)

	public void add(AddRepsButton addRepsButton) {
		try {
			getWidget(1);
			throw new IllegalArgumentException("Cannot add more than a single AddRepsButton to a RepsContainer.");
		} catch (IndexOutOfBoundsException ioobe) {
			super.add(addRepsButton);
		}
	}

	class AddRepsButton extends Button {
		
		AddRepsButton (final RepsList parent, final FUIContainer container) {
			addClickListener(new ClickListener() {
				public void onClick(Widget sender) {
					parent.add(new Reps(parent, parent.getLastReps()));
				}
			});
//			setHTML(new HTML("[+]").toString());
			setHTML("<img src=\"http://localhost:8000/media/images/icons/add.png\" />");
			addStyleName("add-reps");
			setTabIndex(-1);
		}
	}
}
