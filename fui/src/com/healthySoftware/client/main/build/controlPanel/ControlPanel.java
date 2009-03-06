package com.healthySoftware.client.main.build.controlPanel;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.healthySoftware.client.FUIContainer;
import com.healthySoftware.client.fitnessUI;
import com.healthySoftware.client.main.build.controlPanel.load.LoadAction;
import com.healthySoftware.client.main.build.controlPanel.save.SaveAction;
import com.healthySoftware.client.main.build.controlPanel.save.SaveButton;
import com.healthySoftware.client.main.build.controlPanel.save.SaveDialog;

public class ControlPanel extends HorizontalPanel {

	PrintButton printButton = null;
	
	SaveAction saveAction = null;
	
	LoadAction loadAction = null;
	
//	SaveButton saveButton = null;

//	SaveDialog saveDialog = null;
	
	// Called by FUIContainer->TabContainer->BuildTab->ControlPanel
	// TODO: Having a pointer to the parent may be useful
	public ControlPanel (FUIContainer container) {
		// TODO: Can make a shortcut to exerciseList if I pass in TemplateProperties instead; EDIT: Is a global template properties a hack?
		add(printButton = new PrintButton(container)); //fitnessUI.properties.getExerciseList()));
		saveAction = new SaveAction(container);
		add(saveAction.getSaveButton());
		add(saveAction.getSaveAsButton());
		loadAction = new LoadAction(container);
		add(loadAction.getLoadButton());
//		add(saveAction.getSaveDialog());
//		add(saveButton = new SaveButton());
//		add(new WorkoutTemplateForm(container, container.getErrorConsole()));
	}

	public PrintButton getPrintButton() {
		return printButton;
	}

	public void setPrintButton(PrintButton printButton) {
		this.printButton = printButton;
	}

	public SaveButton getSaveButton() {
		return saveAction.getSaveButton();
	}

	public void setSaveButton(SaveButton saveButton) {
		saveAction.setSaveButton(saveButton);
	}

	public SaveDialog getSaveDialog() {
		return saveAction.getSaveDialog();
	}

	public void setSaveDialog(SaveDialog saveDialog) {
		saveAction.setSaveDialog(saveDialog);
	}

	public SaveAction getSaveAction() {
		return saveAction;
	}

	public void setSaveAction(SaveAction saveAction) {
		this.saveAction = saveAction;
	}

	public LoadAction getLoadAction() {
		return loadAction;
	}

	public void setLoadAction(LoadAction loadAction) {
		this.loadAction = loadAction;
	}
}
