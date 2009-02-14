package com.healthySoftware.client.errorConsole;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ErrorConsole extends VerticalPanel {

	public ErrorConsole() {
		add(new HTML("Errors: "));
		addStyleName("error-console");
		setPixelSize(1200, 100);
		setWidth("100%");
	}

	public void add(String s) {
		add(new HTML(s));
	}
}
