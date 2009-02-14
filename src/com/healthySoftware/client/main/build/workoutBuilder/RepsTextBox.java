package com.healthySoftware.client.main.build.workoutBuilder;

import com.google.gwt.user.client.ui.TextBox;

public class RepsTextBox extends TextBox {

//	RepsTextBox(int defaultNum) {
//		this(defaultNum == -1 ? "" : "" + defaultNum);
//	}

	RepsTextBox(String defaultNum) {
		setText(defaultNum == null ? "" : "" + defaultNum);
		setMaxLength(12);
	}
}
