package com.asu.ser.authentication;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationUtil {

	private static final Map<String, String> USER_TOKENS = new HashMap<>();
	private static final String ATTR_NAME_USER_TOKEN = "USER_TOKEN";
	
	public static String setTokenForUser(String username, HttpServletRequest request) {
		String token = TokenGenerator.generateToken();
		USER_TOKENS.put(username, token);
		request.setAttribute(ATTR_NAME_USER_TOKEN, token);
		return token;
	}
	
	public static void reomveTokenForUser(String username) {
		USER_TOKENS.remove(username);
	}
	public static boolean validateUser(String userName, String token) {
		String storedToken = USER_TOKENS.getOrDefault(userName, "");
		return storedToken.equals(token);
	}

}
