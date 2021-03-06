package com.healthySoftware.client.util;

public class Constants {

	// NOTE The trailing slash is included in the service implementation class
	public static String LOCAL_URL_ROOT = "http://localhost:8000"; 
	
//	public static String WEB_URL_ROOT = "http://173.54.234.154"; 
	public static String WEB_URL_ROOT = "http://iflex.adambossy.com"; 
	
	// Determines whether to use localhost for service requests or Web server.
	public static boolean LOCAL = true;
	
	// Determines whether services should be mocked (fakeRequest()) or actually made
	public static boolean DEBUG = true;

	public static boolean REFLECTION = false;
	
}
