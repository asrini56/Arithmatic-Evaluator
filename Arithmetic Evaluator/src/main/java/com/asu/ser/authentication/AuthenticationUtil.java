package com.asu.ser.authentication;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class AuthenticationUtil {

	private static final Map<String, String> USER_TOKENS = new HashMap<>();
	
	
	public static String setTokenForUser(String userName) {
		String token = TokenGenerator.generateToken();
		USER_TOKENS.put(userName, token);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute(AuthenticationConstants.ATTR_NAME_USERNAME, userName);
		session.setAttribute(AuthenticationConstants.ATTR_NAME_USER_TOKEN, token);
		return token;
	}
	
	public static void reomveTokenForUser(String userName) {
		USER_TOKENS.remove(userName);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute(AuthenticationConstants.ATTR_NAME_USER_TOKEN);
	}
	
	public static boolean validateUser(String userName) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String token = (String) session.getAttribute(AuthenticationConstants.ATTR_NAME_USER_TOKEN);
		String storedToken = USER_TOKENS.getOrDefault(userName, "");
		return storedToken.equals(token);
	}

	public static String getLoggedInUser() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		return (String) session.getAttribute(AuthenticationConstants.ATTR_NAME_USERNAME);
	}
}
