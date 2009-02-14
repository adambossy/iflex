package com.healthySoftware.client.main.build.workoutBuilder;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class RepsList extends VerticalPanel {

	public void validate() {
		if (getWidgetCount() > 0)
			((Reps) getWidget(0)).getDeleteButton().setEnabled(getWidgetCount() != 1);
	}

	public boolean remove(Widget w) {
		boolean remove = super.remove(w);
		validate();
		return remove;
	}

	public void add(Widget w) {
		super.add(w);
		validate();
	}

	public int getWidgetCount() { 
		return super.getWidgetCount();
	}

	// TODO Find a way to avoid all these casts and Integer.parseInts (with objects, most likely)
	public String getReps(int index) {
		return ((Reps) getWidget(index)).getReps();
	}
	
	// TODO See above
	public String getLastReps() {
		return ((Reps) getWidget(getWidgetCount()-1)).getReps();
	}
}
