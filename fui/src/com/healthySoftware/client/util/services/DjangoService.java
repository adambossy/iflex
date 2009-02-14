package com.healthySoftware.client.util.services;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONException;
import com.healthySoftware.client.FUIContainer;
import com.healthySoftware.client.util.Constants;

public abstract class DjangoService {
     
    public void makeRequest(String path, final FUIContainer container) {
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
                URL.encode(Constants.DEBUG ? 
        				Constants.LOCAL_URL_ROOT + path :
        				Constants.WEB_URL_ROOT + path));

        try {
            Request request = builder.sendRequest(null, new RequestCallback() {
                public void onError(Request request, Throwable exception) {
                    // Couldn't connect to server (could be timeout, SOP violation, etc.)
                    displayError ("Couldn't connect to server (could be timeout, SOP violation, etc.)");
                }

                public void onResponseReceived(Request request, Response response) {
                    if (200 == response.getStatusCode()) {
                        try {
                            handleJsonResponse(response.getText(), container);
                        } catch (JSONException e) {
                          displayError("Could not parse JSON");
                        }
                    } else {
                        displayError("Couldn't retrieve JSON (" + response.getStatusText() + ")");
                    }
                }       
            });
        } catch (RequestException e) {
            // Couldn't connect to server
            displayError("Server encountered an exception: \n" + e.getMessage());
            e.printStackTrace();
        }
    }

    public abstract void displayError(String error);

	public void handleJsonResponse(String jsonArray, FUIContainer container) {
  		if (jsonArray== null) {
  			displayError("Json value is null");
  			return;
  		}

  		if (jsonArray!= null) {
  			if (Constants.REFLECTION) {}
  				// Apparently this is unnecessary because interfaces don't allow static methods to be defined.
  				// Didn't know that. Create an instance of a ServicePopulator class instead. TODO: Investigate
  				// if enforcement of singletons is necessary.
  				// EDIT: Reflection not even implemented in GWT anyway. Yikes.
/*  				try {
  					getServicePopulateClass().getMethod("execute", new Class[] { String.class }).invoke(jsonArray);
  				} catch (Exception e) {
  					displayError("Error on reflection invokation: " + e.getMessage());
  					e.printStackTrace();
  				}
*/
  			else
  				getServicePopulatorInstance().execute(jsonArray, container);
  		} else {
  			throw new JSONException();
  		}
	}

	public abstract ServicePopulator getServicePopulatorInstance();
}
