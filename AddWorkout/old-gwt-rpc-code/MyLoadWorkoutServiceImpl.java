package com.healthySoftware.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.healthySoftware.client.MyLoadWorkoutService;

public class MyLoadWorkoutServiceImpl extends RemoteServiceServlet implements MyLoadWorkoutService {

	public String loadWorkout() {
		return "{'str':'str_value','int':102}";
	}
}
