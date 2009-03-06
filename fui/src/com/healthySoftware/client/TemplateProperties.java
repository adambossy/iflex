package com.healthySoftware.client;

import java.util.List;

import com.google.gwt.user.client.ui.DialogBox;
import com.healthySoftware.client.main.build.workoutBuilder.BuilderItem;
import com.healthySoftware.client.main.build.workoutBuilder.BuilderItemDAO;
import com.healthySoftware.client.util.GlassPanel;

// TODO Should be a singleton
public class TemplateProperties {
	
	private FUIContainer container = null;
	
	private int templateId = -1;
	
	private String templateName = null;
	
//	private boolean isSaved = false;
	
	private List<BuilderItemDAO> exerciseList = null;

//	DialogBox loading;
	
//	GlassPanel glassPanel;

	TemplateProperties(FUIContainer container, String templateName, /*boolean isSaved,*/ List<BuilderItemDAO> exerciseList) {
		this.container = container;
		this.templateName = templateName;
//		this.isSaved = isSaved;
		this.exerciseList = exerciseList;
	}
	
//	public DialogBox getLoading() {
//		return loading;
//	}
//
//	public void setLoading(DialogBox loading) {
//		this.loading = loading;
//	}
//
//	public GlassPanel getGlassPanel() {
//		return glassPanel;
//	}
//
//	public void setGlassPanel(GlassPanel glassPanel) {
//		this.glassPanel = glassPanel;
//	}

	public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public boolean isSaved() {
		return templateId != -1;
	}

//	public void setSaved(boolean isSaved) {
//		this.isSaved = isSaved;
//	}

	public List<BuilderItemDAO> getExerciseList() {
//		setExerciseList(container.getWorkoutBuilderPanel().getExerciseList());
		return exerciseList;
	}

	private void setExerciseList(List<BuilderItemDAO> exerciseList) {
		this.exerciseList = exerciseList;
	}
}
