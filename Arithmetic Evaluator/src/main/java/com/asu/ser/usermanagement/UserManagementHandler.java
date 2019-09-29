package com.asu.ser.usermanagement;

import com.asu.ser.db.DataSource;
import com.asu.ser.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class UserManagementHandler {

    public void signUpAdminUser(String emailID, String password, String firstName, String lastName, String institutionName) throws Exception {
        Integer userID = DataSource.insertUser(emailID, password, firstName, lastName);
        Integer institutionID = DataSource.insertInstitution(institutionName);
        DataSource.insertUserTOInstitution(userID, institutionID);
    }

    public String loginUser(String emailID, String password) throws Exception {
        String message = "";
        List<User> userList = DataSource.selectUser(emailID);
        if(userList.isEmpty()){
            message = "Username does not exist. Please create an account";
            return message;
        } else if(StringUtils.equals(userList.get(0).getPassword(), password)) {
            message = "Success";
        } else {
            message = "Incorrect Password. Please provide correct password or try to reset password.";
            return message;
        }
        return message;
    }
}
