package com.asu.ser.usermanagement;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.regex.Pattern;

@Conversion()
public class UserManagementAction {

    private String emailID;
    private String password;
    private String firstName;
    private String lastName;
    private String message;
    private String institutionName;
    private List<Teacher> teachers;

    private static final String REGEX = "^(.+)@(.+)$";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public String signUp(){
        try {
            if(!validEmailID(emailID)){
                message = "Invalid Email ID. Please enter a valid Email ID.";
                return Action.ERROR;
            } else if(!validPassword(password)){
                message = "Invalid Password. Please enter a valid Password.";
                return Action.ERROR;
            } else if(UserManagementHandler.isInstitutionPresent(institutionName)){
                message = "Institution is already created. Please login using Email ID and Password, or Click Reset Password.";
                return Action.ERROR;
            } else {
            	UserManagementHandler.signUpAdminUser(emailID, password, null, null, StringUtils.trimToNull(institutionName));
            }
        } catch (Exception e) {
            message = "Failed to create Admin Account!!!";
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }

    public String addTeacher() {
    	try {
    		if(!validEmailID(emailID)){
                message = "Invalid Email ID. Please enter a valid Email ID.";
                return Action.ERROR;
            } else if(!validPassword(password)){
                message = "Invalid Password. Please enter a valid Password.";
                return Action.ERROR;
            } else {
            	UserManagementHandler.addTeacher(firstName, lastName, emailID);
            }
    	} catch (Exception e) {
			e.printStackTrace();
			message = "Failed to add teacher " + e.getMessage();
			return Action.ERROR;
		}
    	return Action.SUCCESS;
    }

    public String fetchTeachers() {
    	try {
    		teachers = UserManagementHandler.fetchTeachers();
    	}catch (Exception e) {
    		e.printStackTrace();
    		message = "Failed to fetch teachers - " + e.getMessage();
		}
    	return Action.SUCCESS;
    }

    private boolean validEmailID(String emailID) {
    	return PATTERN.matcher(emailID).matches();
    }

    private boolean validPassword(String password) {
        return true;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
}
