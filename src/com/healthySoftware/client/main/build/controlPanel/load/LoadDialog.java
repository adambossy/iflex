package com.healthySoftware.client.main.build.controlPanel.load;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.healthySoftware.client.FUIContainer;
import com.healthySoftware.client.fitnessUI;

public class LoadDialog extends DialogBox {

	ListBox workoutListBox = null;
	
	LoadDialog(LoadAction loadAction, final FUIContainer container) {
		// Sets header
		setText("Load Template");
		
		// Construct body
		FlexTable flexTable = new FlexTable();
		flexTable.setWidth("100%");

		// Template name
		flexTable.setHTML(0, 0, "<label for=\"id_name\">Template Name:</label>");

		workoutListBox = new ListBox(false);
		workoutListBox.addItem("stub");
		flexTable.setWidget(0, 1, workoutListBox);
		
		// Buttons
		HorizontalPanel buttons = createButtons(flexTable, loadAction, container);
		// Set the contents of the Widget
		flexTable.setWidget(3, 0, buttons);
		flexTable.getFlexCellFormatter().setColSpan(3, 0, 2);
		setWidget(flexTable);
	}

	private HorizontalPanel createButtons(FlexTable flexTable, final LoadAction loadAction, final FUIContainer container) { //, final SaveButton saveButton) {
		Button loadButton = new Button("Load"); // NON-NLS
		Button closeButton = new Button("Close"); // NON-NLS
		HorizontalPanel buttons = new HorizontalPanel();
		final LoadDialog self = this;
//		loadButton.addClickListener(loadAction.createLoadButtonClickListener(self, container));

		loadButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				fitnessUI.properties.setTemplateId(Integer.parseInt(self.workoutListBox.getValue(self.workoutListBox.getSelectedIndex())));
				loadAction.loadTemplate(container);
				self.hide();
			}
		});
		buttons.add(loadButton);

		closeButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				self.hide();
			}
		});
		buttons.add(closeButton);

		return buttons;
	}
	
	// TODO This needs to be updated when a file is saved
	// Make the AJAX call when the dialog is loaded, not at init time
	public void populate(JSONArray workoutTemplateList) {
		System.out.println("w="+workoutTemplateList);
		workoutListBox = new ListBox();
		for (int index = 0; index < workoutTemplateList.size(); index++) {
			JSONObject value = (JSONObject) workoutTemplateList.get(index);
			workoutListBox.addItem(value.get("name").isString().stringValue(), ""
					+ (int) value.get("pk").isNumber().doubleValue());
		}
		((FlexTable) this.getWidget()).setWidget(0, 1, workoutListBox);
	}

	public ListBox getWorkoutListBox() {
		return workoutListBox;
	}

	public void setWorkoutListBox(ListBox workoutListBox) {
		this.workoutListBox = workoutListBox;
	}
}