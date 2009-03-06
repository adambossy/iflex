package com.healthySoftware.client.main.build.controlPanel;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Widget;
import com.healthySoftware.client.FUIContainer;
import com.healthySoftware.client.main.build.workoutBuilder.BuilderItemDAO;
import com.healthySoftware.client.util.models.template_editor.ExerciseTemplate;

public class PrintButton extends Button {

	public PrintButton(final FUIContainer container) {
		addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				Window.open("http://localhost:8888/com.healthySoftware.PrintWorkout/PrintWorkout.html?" + serializeForURL(container.getWorkoutBuilderPanel().getExerciseList()), "_blank", "left=0,right=0,width=400,height=320");				
//				Window.open("http://gmail.com/", "_blank", "left=0,right=0,width=320,height=240");				
			}
		});
		setText("Print");
		addStyleName("print-button");
		addStyleName("button");
	}
	
	// TODO: Should I keep this function in client.main.build.workoutBuilder and protect all the getters and setters
	
	String serializeForURL(List<BuilderItemDAO> exerciseList) {
		String queryString = new String();

		/*
		  		List<String> exerciseName = parameters.get("exerciseName");
				List<String> warmupReps = parameters.get("warmupReps");
				List<String> workoutReps = parameters.get("workoutReps");
				List<String> rest = parameters.get("rest");
				List<String> notes = parameters.get("notes");
		 */
		queryString += "&templateName=todo";
//		http://localhost:8888/com.healthySoftware.PrintWorkout/PrintWorkout.html?&exerciseName=Barbell%20Bench%20Press&warmupReps=%5BLjava.lang.String;@87970d&workoutReps=%5BLjava.lang.String;@cdd951&rest=60&notes=a&exerciseName=Barbell%20Bench%20Press,%20Incline&warmupReps=%5BLjava.lang.String;@76595b&workoutReps=%5BLjava.lang.String;@e466a0&rest=60&notes=b
//		http://localhost:8888/com.healthySoftware.PrintWorkout/PrintWorkout.html?&exerciseName=Barbell%20Bench%20Press&warmupReps=1&workoutReps=1&rest=60&notes=abc&exerciseName=Barbell%20Bench%20Press,%20Incline&warmupReps=1&workoutReps=1&rest=60&notes=cde
		for (BuilderItemDAO exercise: exerciseList) {
			queryString += "&exerciseName=" + exercise.getExerciseName();
			queryString += "&warmupReps=" 	+ serializeArray(exercise.getWarmupReps());
			queryString += "&workoutReps="	+ serializeArray(exercise.getWorkoutReps());
			queryString += "&rest=" 		+ exercise.getRest();
			queryString += "&notes=" 		+ exercise.getNotes();
		}
		
		return queryString;
	}
	
	String serializeArray(String[] array) {
		String out = new String();
		for (String string : array)
			out += string + ",";
		out = out.substring(0, out.length()-1);
		return out;
	}
}
