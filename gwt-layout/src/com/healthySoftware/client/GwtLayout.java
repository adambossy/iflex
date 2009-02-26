package com.healthySoftware.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.healthySoftware.client.contents.home.Home;
import com.healthySoftware.client.contents.register.GoalsCheckList;
import com.healthySoftware.client.footer.Footer;
import com.healthySoftware.client.header.HeaderFixed;
import com.healthySoftware.client.header.HeaderFull;

public class GwtLayout implements EntryPoint {

	// Turns on all borders
	private static boolean BORDERS = false;

//	private String ROOT_URL = "http://iflex.adambossy.com";
	private String ROOT_URL = "http://localhost:8000/";

	public void onModuleLoad() {

		VerticalPanel container = new VerticalPanel();
		// container.setWidth("830px");
		container.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
		if (BORDERS)
			container.setBorderWidth(1);

		String color = Window.Location.getParameter("color");
		if (color == null
				|| (!color.equals("yellow") && !color.equals("green")
						&& !color.equals("blue") && !color.equals("orange")))
			color = "blue"; // Default
		System.out.println("parameter :: color: " + color);
		
		String draft = Window.Location.getParameter("draft");
		if (draft == null
				|| (!draft.equals("1") && !draft.equals("2") && !draft
						.equals("3")))
			draft = "1";
		System.out.println("parameter :: draft: " + draft);
		
		String space = Window.Location.getParameter("space");
		if (space == null || !(space.equals("spaced") || space.equals("tight")))
			space = "spaced";
		System.out.println("parameter :: space: " + space);

		String width = Window.Location.getParameter("width");
		if (width == null || !(width.equals("full") || width.equals("fixed")))
			width = "fixed";
		System.out.println("parameter :: width: " + width);
		
		RootPanel.get().addStyleName("style-" + color);
		RootPanel.get().addStyleName("style-" + space);
		RootPanel.get().addStyleName("style-" + width);
//		RootPanel.get().addStyleName("style-" + inline);

//		DeckPanel main = new DeckPanel();
//		main.setHeight("400px");

		VerticalPanel wrapper = new VerticalPanel();
		wrapper.addStyleName("wrapper");

		if (width.equals("full"))
			wrapper.add(new HeaderFull(BORDERS, draft, color));
		else
			wrapper.add(new HeaderFixed(BORDERS, draft, color));
		// wrapperTop.add(contents);
//		wrapperTop.setCellHorizontalAlignment(wrapperTop.getWidget(),
//				VerticalPanel.ALIGN_CENTER);

		/* BODY */
		wrapper.add(new HTML("<div id=\"body attachment-point\">Body.</div>")); // For compilation use only
//		main.add(new GoalsCheckList(BORDERS));
//		main.addStyleName("main");
//		main.showWidget(0);
		/* END BODY */

		wrapper.add(new Footer(BORDERS));
		
//		SimplePanel wrapperBottom = new SimplePanel();
//		wrapperBottom.addStyleName("wrapper");
//		wrapperBottom.add(new Footer(BORDERS));
//		wrapperBottom.setCellHorizontalAlignment(wrapperBottom.getWidget(),
//				VerticalPanel.ALIGN_CENTER);

		RootPanel.get().add(wrapper);
		// RootPanel.get().add(stepsContainer);
//		RootPanel.get().add(main);
//		RootPanel.get().add(wrapperBottom);
	}
}
