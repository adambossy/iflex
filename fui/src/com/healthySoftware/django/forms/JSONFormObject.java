package com.healthySoftware.django.forms;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class JSONFormObject extends JSONObject {
	JSONObject _object = null;
	
	public JSONFormObject(JSONObject object) {
		this._object = object;
	}

	public JSONValue get(String path) {
		String[] nodes = path.split("[.]");
		JSONObject el = _object;
		for (String node : nodes) {
			if (el.get(node) == null)
				throw new NullPointerException("Path does not exist in JSON object. Failed at node \"" + node + "\".");
			if (el.get(node).getClass() == JSONObject.class)
				el = (JSONObject) el.get(node);
			else 
				return el.get(node);
		}
		return null;
	}

	public String getHTML(String path) throws ClassCastException {
		JSONValue get = get(path);
		if (get(path).isString() == null)
			throw new ClassCastException("Trying to get a String value from a non-String path.");
		return get.isString().stringValue();
	}
	
	public JSONArray getErrors(String path) {
		JSONValue get = get(path);
		if (get(path).isArray() == null)
			throw new ClassCastException("Trying to get an Array value from a non-Array path.");
		return get.isArray();
	}
}

