package com.healthySoftware.client.main.build.controlPanel;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Widget;

public class PrintButton extends Button {

	public PrintButton() {
		addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				Window.open("http://gmail.com/", "_blank", "left=0,right=0,width=320,height=240");				
			}
		});
		setText("Print");
		addStyleName("print-button");
	}
}
