package com.asu.ser.usermanagement;
/**
 * @author akhilesh
 */
/**
 * Generates the password for the user during account creation
 */

public class PasswordGenerator {
	public static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
	
	/**
	 * Function generates a randome password by using the above AlphaNumerString
	 * @return
	 */
	public static String generatePassword() {
		int n = 8;
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (ALPHA_NUMERIC_STRING.length() * Math.random()); 
			sb.append(ALPHA_NUMERIC_STRING.charAt(index));
		}
		return sb.toString();
	}

}
