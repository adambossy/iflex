package com.healthySoftware.client.main.build.workoutBuilder;

import com.google.gwt.user.client.ui.TextBox;

public class Notes extends TextBox {
	
	Notes(String defaultNotes) {
		super();
		this.setText(defaultNotes);
		this.addStyleName("notes");
	}
	
}
