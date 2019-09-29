package com.asu.ser.authentication;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class AuthenticationUtil {

	private static final Map<String, String> USER_TOKENS = new HashMap<>();
	
	
	public static String setTokenForUser(String userName) {
		String token = TokenGenerator.generateToken();
		USER_TOKENS.put(userName, token);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute(AuthenticationConstants.ATTR_NAME_USERNAME, userName);
		request.setAttribute(AuthenticationConstants.ATTR_NAME_USER_TOKEN, token);
		return token;
	}
	
	public static void reomveTokenForUser(String userName) {
		USER_TOKENS.remove(userName);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.removeAttribute(AuthenticationConstants.ATTR_NAME_USER_TOKEN);
	}
	
	public static boolean validateUser(String userName) {
		HttpServletRequest request = ServletActionContext.getRequest();
		String token = (String) request.getAttribute(AuthenticationConstants.ATTR_NAME_USER_TOKEN);
		String storedToken = USER_TOKENS.getOrDefault(userName, "");
		return storedToken.equals(token);
	}

	public static String getLoggedInUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return (String) request.getAttribute(AuthenticationConstants.ATTR_NAME_USERNAME);
	}
}
