package com.healthySoftware.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GwtLayout implements EntryPoint {

	// Turns on all borders
	private static boolean BORDERS = false;
	
  public void onModuleLoad() {
	  VerticalPanel container = new VerticalPanel();
//	  container.setWidth("830px");
	  container.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
	  
	  HorizontalPanel header = new HorizontalPanel();
	  header.addStyleName("header");
	  if (BORDERS) header.setBorderWidth(1);
	  
	  HTML logo = new HTML("iFlex Fitness");
	  logo.addStyleName("logo");
//	  header.add(logo);
	  
	  HorizontalPanel nav = new HorizontalPanel();
	  nav.addStyleName("nav");
	  if (BORDERS) nav.setBorderWidth(1);
	  
	  nav.add(createLink("Home"));
	  nav.add(createLink("About"));
	  nav.add(createLink("Workout Editor"));
	  nav.add(createLink("Contact"));
//	  nav.add("Blog");
	  
	  header.add(logo);
	  header.setCellHorizontalAlignment(logo, HorizontalPanel.ALIGN_LEFT);
	  header.setCellVerticalAlignment(logo, HorizontalPanel.ALIGN_BOTTOM);
	  header.add(nav);
//	  header.setWidth("830px");
	  header.setCellHorizontalAlignment(nav, HorizontalPanel.ALIGN_RIGHT);
	  header.setCellVerticalAlignment(nav, HorizontalPanel.ALIGN_BOTTOM);
	  
	  VerticalPanel contents = new VerticalPanel();
	  contents.addStyleName("contents");
	  
	  HTML largeText = new HTML("Welcome to the world's easiest way to stay fit.");
	  largeText.addStyleName("large-text");
	  contents.add(largeText);
	  
	  HTML smallText = new HTML("Say goodbye to the false promises of infomercials and diet programs, and say hello to the first no-gimmicks way to keep a healthy lifestyle.");
	  smallText.addStyleName("small-text");
	  contents.add(smallText);
	  
	  Anchor launch = new Anchor("Launch My Workout Routine >");
	  contents.add(launch);
	  contents.addStyleName("launch");
	  if (BORDERS) contents.setBorderWidth(1);
	  contents.setCellHorizontalAlignment(launch, VerticalPanel.ALIGN_RIGHT);

	  HorizontalPanel stepsContainer = new HorizontalPanel();
	  if (BORDERS) stepsContainer.setBorderWidth(1);
	  stepsContainer.addStyleName("steps-container");
	  stepsContainer.setWidth("100%");
	  HorizontalPanel steps = new HorizontalPanel();
	  if (BORDERS) steps.setBorderWidth(1);
	  steps.addStyleName("steps");
	  steps.setHorizontalAlignment(HorizontalPanel.ALIGN_CENTER);
	  steps.add(createStep("Plan"));
	  steps.add(createStep("Track"));
	  steps.add(createStep("Visualize"));
//	  steps.setWidth("100%");
	  
	  stepsContainer.add(steps);
	  stepsContainer.setCellHorizontalAlignment(steps, HorizontalPanel.ALIGN_CENTER);

	  HorizontalPanel footer = new HorizontalPanel();
	  footer.addStyleName("footer");
	  
	  HTML copyright = new HTML("(C) Copyright 2009 healthySoftware");
	  
	  HorizontalPanel footerNav = new HorizontalPanel(); 
	  footerNav.add(createLink("Home"));
	  footerNav.add(createLink("About"));
	  footerNav.add(createLink("Workout Editor"));
	  footerNav.add(createLink("Contact"));
	  
	  footer.add(copyright);
	  footer.add(footerNav);
//	  footer.setWidth("100%");
	  if (BORDERS) footer.setBorderWidth(1);
	  footer.setCellHorizontalAlignment(footerNav, HorizontalPanel.ALIGN_RIGHT);
	  
//	  container.add(header);
//	  container.add(contents);
//	  container.add(stepsContainer);
//	  container.add(footer);
	  
//	  wrapper.add(container);
//	  wrapper.setWidth("100%");
//	  wrapper.setCellHorizontalAlignment(container, VerticalPanel.ALIGN_CENTER);

//	  RootPanel.get().add(wrapper);
	  VerticalPanel wrapperTop = new VerticalPanel();
	  wrapperTop.addStyleName("wrapper");
	  wrapperTop.add(header);
	  wrapperTop.add(contents);
	  wrapperTop.setCellHorizontalAlignment(header, VerticalPanel.ALIGN_CENTER);
	  wrapperTop.setCellHorizontalAlignment(contents, VerticalPanel.ALIGN_CENTER);

	  VerticalPanel wrapperBottom = new VerticalPanel();
	  wrapperBottom.addStyleName("wrapper");
	  wrapperBottom.add(footer);
	  wrapperBottom.setCellHorizontalAlignment(footer, VerticalPanel.ALIGN_CENTER);
	  
	  RootPanel.get().add(wrapperTop);
	  RootPanel.get().add(stepsContainer);
	  RootPanel.get().add(wrapperBottom);
  }
  
  // TODO: Subclass this?
  Anchor createLink(String name) {
	  Anchor anchor = new Anchor(name);
	  anchor.addStyleName("nav-link");
	  anchor.setHref("/"+name.toLowerCase());
	  return anchor;
  }
  
  VerticalPanel createStep(String name) {
	  VerticalPanel step = new VerticalPanel();
	  HTML label = new HTML(name);
	  label.addStyleName("step-label");
//	  Image pic = new Image();
//	  pic.addStyleName("pic");
	  HTML placeholder = new HTML("<p>Pic placeholder</p>");
	  step.add(label);
	  step.add(placeholder);
	  return step;
  }
}
