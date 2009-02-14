package com.healthySoftware.client.main.build.controlPanel.save;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Widget;
import com.healthySoftware.client.fitnessUI;

public class SaveAsButton extends Button {

//	final private SaveAction saveAction;

	// TODO Write web front-end to load these 
	// Apply style to the front end for it to be easily Android-able
	
	public SaveAsButton(final SaveAction saveAction) {
		setText("Save As... (will save a new copy)");
		addStyleName("save-as-button");
//		this.setEnabled(false);
//		this.saveAction = saveAction; 
		addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				fitnessUI.properties.setTemplateId(-1);
				saveAction.getSaveDialog().center();
				saveAction.getSaveDialog().show();
				saveAction.getSaveDialog().getName().setFocus(true);
			}
		});
	}

	/**
	 * This method cannot be created with this object's constructor, because we must wait for Django
	 * to pass us the contents of the DialogBox specified below. We could defer the entire object
	 * construction, but as is, it is acting like a stub (disabled) until a response is received.
	 * 
	 * @param json
	 * @param container
	 */
	/*
	public void populate(final JSONObject json, final FUIContainer container) {
		addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				SaveDialog saveDialog = new SaveDialog(saveAction, container); // json, self, container);
				saveDialog.center();
				saveDialog.show();
				saveAction.setSaveDialog(saveDialog);
				// TODO: Better way of doing this? :)
				((TextBox) ((FlexTable) saveDialog.getWidget()).getWidget(0, 1)).setFocus(true);
			}
		});
		setEnabled(true);
	}
	*/
}
