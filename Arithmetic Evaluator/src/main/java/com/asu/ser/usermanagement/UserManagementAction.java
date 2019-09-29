package com.asu.ser.usermanagement;

import com.asu.ser.db.DataSource;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Conversion()
public class UserManagementAction {

    private static String emailID;
    private static String password;
    private static String firstName;
    private static String lastName;
    private static String message;
    private static String institutionName;

    public String signUp(){
        UserManagementHandler userManagementHandler = new UserManagementHandler();
        try {
            if(!validEmailID(emailID)){
                message = "Invalid Email ID. Please enter a valid Email ID.";
                return Action.ERROR;
            } else if(!validPassword(password)){
                message = "Invalid Password. Please enter a valid Password.";
                return Action.ERROR;
            } else if(isInstitutionPresent(institutionName)){
                message = "Institution is already created. Please login using Email ID and Password, or Click Reset Password.";
                return Action.ERROR;
            } else {
                userManagementHandler.signUpAdminUser(emailID, password, null, null, StringUtils.trimToNull(institutionName));
            }
        } catch (Exception e) {
            this.message = "Failed to create Admin Account!!!";
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }

    private boolean validEmailID(String emailID) {
        return true;
    }

    private boolean validPassword(String password) {
        return true;
    }

    public boolean isInstitutionPresent(String institutionName) throws Exception {
        List<Integer> institutionIdList = DataSource.selectInstitutionID(institutionName);
        return !institutionIdList.isEmpty();
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
}
