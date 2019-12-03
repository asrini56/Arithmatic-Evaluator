package com.asu.ser.model;
/**
 * @author Ashwin
 * @author Srinivasan
 */


public class Teacher extends User {

	private int institutionID;

	public int getInstitutionID() {
		return institutionID;
	}

	public void setInstitutionID(int institutionID) {
		this.institutionID = institutionID;
	}
}
