package com.healthySoftware.client;

import java.util.List;

import com.google.gwt.user.client.ui.DialogBox;
import com.healthySoftware.client.main.build.workoutBuilder.BuilderItem;
import com.healthySoftware.client.util.GlassPanel;

// TODO Should be a singleton
public class TemplateProperties {
	
	private FUIContainer container = null;
	
	private int templateId = -1;
	
	private String templateName = null;
	
//	private boolean isSaved = false;
	
	private List<BuilderItem> exerciseList = null;

//	DialogBox loading;
	
//	GlassPanel glassPanel;

	TemplateProperties(FUIContainer container, String templateName, /*boolean isSaved,*/ List<BuilderItem> exerciseList) {
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

	public List<BuilderItem> getExerciseList() {
		setExerciseList(container.getWorkoutBuilderPanel().getExerciseList());
		return exerciseList;
	}

	private void setExerciseList(List<BuilderItem> exerciseList) {
		this.exerciseList = exerciseList;
	}
}
