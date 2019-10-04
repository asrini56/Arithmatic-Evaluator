package com.asu.ser.usermanagement;

import com.asu.ser.authentication.AuthenticationUtil;
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
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;

    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

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

    public String logout(){
        if(StringUtils.isEmpty(AuthenticationUtil.getLoggedInUser())){
            return Action.ERROR;
        }
        AuthenticationUtil.reomveTokenForUser(emailID);
        return Action.SUCCESS;
    }

    public String addTeacher() {
        if(StringUtils.isEmpty(AuthenticationUtil.getLoggedInUser())){
            message = "Please log in to access the page.";
            System.out.println(message);
            return Action.LOGIN;
        }
    	try {
    		System.out.println("Creating teacher " + firstName + " " + lastName);
    		if(!validEmailID(emailID)){
                message = "Invalid Email ID. Please enter a valid Email ID.";
                System.out.println(message);
                return Action.ERROR;
            } else {
            	UserManagementHandler.addTeacher(firstName, lastName, emailID);
            	System.out.println("Successfully created teacher! ");
            }
    	} catch (Exception e) {
			e.printStackTrace();
			message = "Failed to add teacher " + e.getMessage();
			if(e.getMessage().equals("No user logged in")) {
				message = "Login as admin to add teacher";
				System.out.println(message);
				return Action.LOGIN;
			}
			System.out.println(message);
			return Action.ERROR;
		}
    	return Action.SUCCESS;
    }

    public String fetchTeachers() {
        if(StringUtils.isEmpty(AuthenticationUtil.getLoggedInUser())){
            message = "Please log in to access the page.";
            return Action.ERROR;
        }
    	try {
    	    teachers = UserManagementHandler.fetchTeachers();
    	}catch (Exception e) {
    		e.printStackTrace();
    		message = "Failed to fetch teachers - " + e.getMessage();
		}
    	return Action.SUCCESS;
    }

    public String resetPassword() throws Exception {
        if(!newPassword.equals(confirmPassword)){
            message = "Passwords does not match. Please re-enter a new password.";
            return Action.ERROR;
        } else if(!validPassword(newPassword)){
            message = "Invalid Password. Please enter a valid Password.";
            return Action.ERROR;
        } else{
            message = UserManagementHandler.loginUser(emailID, oldPassword);
            if(StringUtils.equalsIgnoreCase(message, "success")){
                AuthenticationUtil.setTokenForUser(emailID);
                message = UserManagementHandler.resetPassword(emailID, newPassword);
                if(StringUtils.equalsIgnoreCase(message, "success")){
                    return Action.SUCCESS;
                }
            }
        }
        return Action.ERROR;
    }

    private boolean validEmailID(String emailID) {
    	return EMAIL_PATTERN.matcher(emailID).matches();
    }

    private boolean validPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
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

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
