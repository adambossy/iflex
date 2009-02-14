package com.healthySoftware.client.header;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Header extends VerticalPanel {
	
	HTML title;
	
	HTML author;
	
	public Header() {
		add(new HTML("<div style='font-weight: bold; font-size: 1.2em;'>fUI</div>"));
		add(title = new HTML("Untitled"));
		title.addStyleName("title");
		add(author = new HTML());
		author.addStyleName("author");
	}
	
	public Header(String name, String collection, String author) {
		add(new HTML("<div style='font-weight: bold; font-size: 1.2em;'>fUI</div>"));
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
}
