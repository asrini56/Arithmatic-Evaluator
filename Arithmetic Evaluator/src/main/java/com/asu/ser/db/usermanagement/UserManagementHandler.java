package com.asu.ser.db.usermanagement;

import com.asu.ser.db.DataSource;

public class UserManagementHandler {

    public void signUpUser(String firstName, String lastName, String dob, String emailID, String password) throws Exception {
        DataSource.insertAdminUser(firstName, lastName, dob, emailID, password);
    }
}
