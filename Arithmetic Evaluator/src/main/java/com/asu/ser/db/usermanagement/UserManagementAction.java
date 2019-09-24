package com.asu.ser.db.usermanagement;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.conversion.annotations.Conversion;

@Conversion()
public class UserManagementAction {

    private String password;
    private String emailID;
    private String firstName;
    private String lastName;
    private String dob;
    private String message;

    public String signUp(){
        UserManagementHandler userManagementHandler = new UserManagementHandler();
        try {
            userManagementHandler.signUpUser(firstName, lastName, dob, emailID, password);
        } catch (Exception e) {
            this.message = "Failed to create Admin Account!!!";
            return Action.ERROR;
        }
        return Action.SUCCESS;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
