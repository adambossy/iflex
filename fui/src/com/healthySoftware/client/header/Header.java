package com.healthySoftware.client.header;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.healthySoftware.client.FUIContainer;
import com.healthySoftware.client.main.build.controlPanel.ControlPanel;

public class Header extends HorizontalPanel {
	
	HTML title;
	
	HTML author;
	
	ControlPanel controlPanel = null;

	public Header(FUIContainer container) {
//		setBorderWidth(1);
		addStyleName("fui-header");
//		add(new HTML("<div style='font-weight: bold; font-size: 1.2em;'>fUI</div>"));
		HorizontalPanel info = new HorizontalPanel();
		info.add(title = new HTML("Untitled"));
		title.addStyleName("title");
		info.add(author = new HTML("by Unnamed"));
		author.addStyleName("author");
		add(info);
		
		add(controlPanel = new ControlPanel(container));
		setCellHorizontalAlignment(controlPanel, HorizontalPanel.ALIGN_RIGHT);
	}
	
	public Header(String name, String collection, String author) {
//		add(new HTML("<div style='font-weight: bold; font-size: 1.2em;'>fUI</div>"));
		add(this.title = new HTML(name + " in collection " + collection));
		this.title.addStyleName("title");
		add(this.author = new HTML(author));
		this.author.addStyleName("author");
		addStyleName("header");
		setWidth("100%");
	}

	public void setName(String name) { //, String collection) {
		title.setHTML(name); // + " in collection " + collection);
	}
	
	public void setAuthor(String author) {
		this.author.setHTML(author);
	}

	public ControlPanel getControlPanel() {
		return controlPanel;
	}

	public void setControlPanel(ControlPanel controlPanel) {
		this.controlPanel = controlPanel;
	}
}
