package com.healthySoftware.client.main.build.controlPanel.save;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.healthySoftware.client.FUIContainer;
import com.healthySoftware.client.fitnessUI;

public class SaveDialog extends DialogBox {

	TextBox name = null;
	
//	ListBox collection = null;
	
//	ListBox position = null;
	
	SaveDialog(SaveAction saveAction, final FUIContainer container) {

		// Sets header
		setText("Save Template As...");

		// Construct body
		FlexTable flexTable = new FlexTable();
		flexTable.setWidth("100%");

		// Template name
		flexTable.setHTML(0, 0, "<label for=\"id_name\">Template Name:</label>");

		name = new TextBox();
		name.setName("name");
		name.setMaxLength(64);
		flexTable.setWidget(0, 1, name);

		// Buttons
		HorizontalPanel buttons = createButtons(flexTable, saveAction, container);
		flexTable.setWidget(3, 0, buttons);
		flexTable.getFlexCellFormatter().setColSpan(3, 0, 2);
		
		setWidget(flexTable);
	}

	private HorizontalPanel createButtons(FlexTable flexTable, final SaveAction saveAction, final FUIContainer container) { //, final SaveButton saveButton) {

		Button saveButton = new Button("Save"); // NON-NLS
		Button closeButton = new Button("Close"); // NON-NLS
		
		HorizontalPanel buttons = new HorizontalPanel();
		final SaveDialog self = this;

//		saveButton.addClickListener(saveAction.getClickListener());
//		saveButton.addClickListener(saveAction.createClickListener(this, container));
		saveButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				fitnessUI.properties.setTemplateName(self.name.getText());
				saveAction.saveTemplate(container);
				self.hide();
			}
		});
		closeButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				self.hide();
			}
		});

		buttons.add(saveButton);
		buttons.add(closeButton);

		return buttons;
	}

	public TextBox getName() {
		return name;
	}

	public void setName(TextBox name) {
		this.name = name;
	}
/*
	public ListBox getCollection() {
		return collection;
	}

	public void setCollection(ListBox collection) {
		this.collection = collection;
	}

	public ListBox getPosition() {
		return position;
	}

	public void setPosition(ListBox position) {
		this.position = position;
	}
*/
}
