package com.asu.ser.authentication;

import java.util.ArrayList;
import java.util.List;
/**
 * @author akhilesh
 * @author Ashwin
 * @author Srinivasan
 */

public class AuthenticationConstants {

	public static final String ATTR_NAME_USER_TOKEN = "USER_TOKEN";
	public static final String ATTR_NAME_USERNAME = "USERNAME";
	public static final int AUTHENTICATION_FAILED_CODE = 601;
	public static final List<String> EXCLUDED_URLS;
	
	static {
		EXCLUDED_URLS = new ArrayList<>();
		EXCLUDED_URLS.add("jsp");
		EXCLUDED_URLS.add("css");
		EXCLUDED_URLS.add("js");
		EXCLUDED_URLS.add("html");
	}
}
