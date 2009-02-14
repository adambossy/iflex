package com.healthySoftware.client.util.workout;

import com.google.gwt.user.client.ui.TextBox;

public class WorkoutTextBox extends TextBox {

	WorkoutTextBox(int defaultNum) {
		this("" + defaultNum);
	}

	WorkoutTextBox(String defaultNum) {
		setText("" + defaultNum);
		setMaxLength(4);
	}
}
