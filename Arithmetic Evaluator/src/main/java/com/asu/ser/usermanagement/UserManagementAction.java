package com.asu.ser.usermanagement;

import com.asu.ser.authentication.AuthenticationUtil;
import com.asu.ser.db.DataSource;
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
    	String returnType = Action.SUCCESS;
        try {
        	System.out.println("Creating admin user  " + emailID + " for institution " + institutionName );
        	
            if(!validEmailID(emailID)){
                message = "Invalid Email ID. Please enter a valid Email ID.";
                System.out.println(message);
                returnType = Action.ERROR;
            } else if(!validPassword(password)){
                message = "Invalid Password. Please enter a valid Password.";
                returnType = Action.ERROR;
            } else if(UserManagementHandler.isInstitutionPresent(institutionName)){
                message = "Institution is already created. Please login using Email ID and Password, or Click Reset Password.";
                returnType = Action.ERROR;
            } else {
            	UserManagementHandler.signUpAdminUser(emailID, password, null, null, StringUtils.trimToNull(institutionName));
            	message = "Account successfully created!";
            }
        } catch (Exception e) {
        	e.printStackTrace();
            message = "Failed to create Admin Account!!!";
            returnType = Action.ERROR;
        }
        System.out.println(message);
        return returnType;
    }

    public String login(){
        try {
            message = UserManagementHandler.loginUser(emailID, password);
            if(StringUtils.equalsIgnoreCase(message, "success")){
                AuthenticationUtil.setTokenForUser(emailID);
                return UserManagementHandler.getRoleNameForUser(emailID);
            }
        } catch (Exception e) {
            message = "Error while logging in. Please try again.";
            return Action.ERROR;
        }
        return Action.ERROR;
    }

    public String addTeacher() {
    	try {
    		if(!validEmailID(emailID)){
                message = "Invalid Email ID. Please enter a valid Email ID.";
                return Action.ERROR;
            } else {
            	UserManagementHandler.addTeacher(firstName, lastName, emailID);
            }
    	} catch (Exception e) {
			e.printStackTrace();
			message = "Failed to add teacher " + e.getMessage();
			if(e.getMessage().equals("No user logged in")) {
				message = "Login as admin to add teacher";
				return Action.LOGIN;
			}
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
