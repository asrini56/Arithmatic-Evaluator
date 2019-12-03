package com.asu.ser.usermanagement;
/**
 * @author akhilesh
 */

public class PasswordGenerator {
	public static final String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
	
	public static String generatePassword() {
		int n = 8;
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random()); 
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

}
