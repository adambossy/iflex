package com.healthySoftware.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.healthySoftware.client.FUIContainer;

/*
 * Don't know if this will be a useful abstraction. The third argument in getJson could cause the method 
 * not to be overridden for each specific class, and additional arguments will be unaccounted for (although
 * they could all by default take in container as the last element)
 */
public abstract class AJAXObject {
	
	public abstract void handleJsonResponse(JavaScriptObject jso, FUIContainer container);
	
	public native static void getJson(int requestId, String url, Object handler, FUIContainer container)/*-{}-*/;

}
