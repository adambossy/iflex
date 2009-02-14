package com.healthySoftware.client.util.services.template_editor;

// TODO For auto-generation, deal with imports correctly
// TODO Note: for auto-generated services/views, do not overwrite (ever)

import com.google.gwt.user.client.Window;
import com.healthySoftware.client.FUIContainer;
import com.healthySoftware.client.util.Constants;
import com.healthySoftware.client.util.services.DjangoService;
import com.healthySoftware.client.util.services.ServicePopulator;

/* Change to LoadExerciseTemplatesServiceImpl */
public class InitTemplateEditorServiceImpl extends DjangoService {
	
	private String path = "/template_editor/init";

	private ServicePopulator servicePopulatorInstance = new InitTemplateEditorServicePopulator(); 

	// Make a constructor for this?
	public void setServicePopulatorInstance(ServicePopulator servicePopulatorInstance) {
		this.servicePopulatorInstance = servicePopulatorInstance; 
	}

	@Override
	public ServicePopulator getServicePopulatorInstance() {
		return this.servicePopulatorInstance;
	}

	@Override
    public void displayError(String error) {
        Window.alert("displayError() function overridden. Error message: \"" + error +".\"");
    }

	@Override
    public void makeRequest(String path, FUIContainer container) {
    	if (Constants.DEBUG)
    		this.fakeRequest(/*null, */container); // TODO: Possibly choose from a list of test cases? Could we make this a URI parameter?
    	else
    		super.makeRequest(this.path + "?member_id=1", container);
    }
    
    public void fakeRequest(/*Object self/* De facto "don't care" parameter */FUIContainer container) {
    	// TODO: Find a way of streamlining changes in the database directly to here (in a possibly insecure fashion)
    	// Possibly use urllib2 to download the test case (which consists solely of JSON)? 
    	handleJsonResponse("{\"exercise_list\": [{\"type_ids_list\": [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11], \"name\": \"Pectorals\", \"type_names_list\": [\"Barbell Bench Press\", \"Barbell Bench Press, Incline\", \"Barbell Bench Bench, Wide Grip\", \"Barbell Bench Press, Close Grip\", \"Barbell Bench Press, Very Close Grip\", \"Dumbbell Bench Press\", \"Dumbbell Bench Press, Incline\", \"Dumbbell Bench Press, Neutral Grip\", \"Dumbbell Bench Press, Decline\", \"Dumbbell Fly\", \"Dumbbell Fly, Thumbs In\"]}, {\"type_ids_list\": [], \"name\": \"Biceps\", \"type_names_list\": []}, {\"type_ids_list\": [], \"name\": \"Triceps\", \"type_names_list\": []}, {\"type_ids_list\": [27, 28, 29, 30, 31, 32], \"name\": \"Deltoids\", \"type_names_list\": [\"Dumbbell Seated Shoulder Press\", \"Dumbbell Seated Shoulder Press, Palms In\", \"Dumbbell Seated Arnold Press\", \"Dumbbell Upright row\", \"Barbell Upright Row\", \"Dumbbell Seated Lateral Raise\"]}, {\"type_ids_list\": [], \"name\": \"Forearms\", \"type_names_list\": []}, {\"type_ids_list\": [], \"name\": \"Lower Back\", \"type_names_list\": []}, {\"type_ids_list\": [], \"name\": \"Trapezius\", \"type_names_list\": []}, {\"type_ids_list\": [], \"name\": \"Latissimus Dorsi\", \"type_names_list\": []}, {\"type_ids_list\": [12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 33, 34, 35, 36], \"name\": \"Upper Back\", \"type_names_list\": [\"Dumbbell One-Arm Bent-Over Row\", \"Dumbbell One-Arm Bent-Over Row, Reverse Grip\", \"Barbell Bent-Over Row\", \"Barbell Bent-Over Row, Wide Grip\", \"Barbell Bent-Over Row, Reverse Grip\", \"Dumbbell Lying Row\", \"Reverse Dumbbell Fly\", \"Seated Cable Row\", \"Seated Cable Row, Wide Grip\", \"Seated Cable Row, Reverse Grip\", \"Seated Cable Row, Neutral Grip\", \"Seated Cable Row, High Bar\", \"Barbell Seated Shoulder Press\", \"Barbell Seated Shoulder Press, To Front\", \"Barbell Seated Shoulder Press, Wide Grip\", \"Pullup\", \"Chinup\", \"Wide-Grip Pullup\", \"Neutral-Grip Pullup\"]}, {\"type_ids_list\": [], \"name\": \"Quadriceps\", \"type_names_list\": []}, {\"type_ids_list\": [], \"name\": \"Hamstrings\", \"type_names_list\": []}, {\"type_ids_list\": [], \"name\": \"Gluteals\", \"type_names_list\": []}, {\"type_ids_list\": [], \"name\": \"Calves\", \"type_names_list\": []}], \"workout_template_list\": [{\"pk\": 1, \"name\": \"null\"}]}", container);
    }
}