package com.healthySoftware.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

//The RemoteServiceRelativePath annotation automatically calls setServiceEntryPoint()
@RemoteServiceRelativePath("../../fetch/")
public interface MyLoadWorkoutService extends RemoteService {
  public String loadWorkout();
}