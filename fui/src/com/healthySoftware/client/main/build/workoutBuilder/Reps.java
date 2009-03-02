package com.healthySoftware.client.main.build.workoutBuilder;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class Reps extends HorizontalPanel { // RepsTextBox {

	// TODO Change VerticalPanel parent to a proper "RepsContainer" object
	// that inherits from VerticalPanel
	Reps(final RepsList parent, String defaultNum) {
		final Reps self = this;

		RepsTextBox in = new RepsTextBox(defaultNum);
		in.addStyleName("reps-text-box");
		
		Button delete = new Button();
		delete.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				if (parent.getWidgetCount() > 1)
					parent.remove(self);
			}
		});
		delete.setTabIndex(-1);
		delete.setText("x");
		
		add(in);
		add(delete);
	}

	public String getReps() {
		return getTextBox().getText();
	}

	public TextBox getTextBox() {
		return (RepsTextBox) getWidget(0);
	}
	
	public Button getDeleteButton() {
		return (Button) getWidget(1);
	}
}
