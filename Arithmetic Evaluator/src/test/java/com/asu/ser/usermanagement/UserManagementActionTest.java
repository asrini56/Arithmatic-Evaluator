package com.asu.ser.usermanagement;

import com.asu.ser.db.DataSource;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import junit.framework.TestCase;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Conversion()
public class UserManagementActionTest extends TestCase {

    private static String emailID;
    private static String password;
    private static String firstName;
    private static String lastName;
    private static String message;
    private static String institutionName;

    public void testSignUp(){
        UserManagementAction userManagementAction = new UserManagementAction();
        assertEquals(Action.ERROR, userManagementAction.signUp());
    }

}
