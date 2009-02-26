package com.healthySoftware.client.main.build.controlPanel.load;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Widget;

public class LoadButton extends Button {

//	final private LoadAction loadAction;

	public LoadButton(final LoadAction loadAction) {
		setText("Load");
		addStyleName("load-button");
		addStyleName("button");
		this.setEnabled(false);
//		this.loadAction = loadAction;
		addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				loadAction.getLoadDialog().center();
				loadAction.getLoadDialog().show();
				loadAction.getLoadDialog().getWorkoutListBox().setFocus(true);
			}
		});
	}
	
//	public void populate(final JSONObject json, final FUIContainer container) {
//		setEnabled(true);
//	}
}
