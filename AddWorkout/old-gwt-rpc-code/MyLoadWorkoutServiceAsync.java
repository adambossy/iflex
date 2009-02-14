package com.healthySoftware.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MyLoadWorkoutServiceAsync {
	public void loadWorkout(
		AsyncCallback</*HasIntField*/String> callback);
}
