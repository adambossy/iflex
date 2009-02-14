package com.healthySoftware.client.util.services;

import com.google.gwt.json.client.JSONObject;

/* Change to LoadExerciseTemplatesServiceImpl */
class ServiceLoadExerciseTemplatesImpl extends DjangoService {
	
	private static String url = "http://localhost:8000/template_editor/service_load_exercise_templates";
	
	@Override
	public void handleJsonResponse(JSONObject json) {
		
	}

	private void displayError(String error) {
        
    }
}