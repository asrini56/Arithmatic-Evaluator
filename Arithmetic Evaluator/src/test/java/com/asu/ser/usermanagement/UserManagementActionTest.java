package com.asu.ser.usermanagement;

import com.opensymphony.xwork2.Action;
import junit.framework.TestCase;

/**
 * @author srini
 * @author akhilesh
 */
public class UserManagementActionTest extends TestCase {

    /**
     * Test function to test the functionality to validate email
     */
    public void testSignUpValidateEmail(){
        UserManagementAction userManagementAction = new UserManagementAction();
        assertEquals(Action.ERROR, userManagementAction.signUp());
        assertEquals("Invalid Email ID. Please enter a valid Email ID.", userManagementAction.getMessage());
        userManagementAction.setEmailID("abc");
        userManagementAction.setMessage(null);
        assertEquals(Action.ERROR, userManagementAction.signUp());
        assertEquals("Invalid Email ID. Please enter a valid Email ID.", userManagementAction.getMessage());
    }

    /**
     * Test function to test the functionality to validate password
     */
    public void testSignUpValidatePassword(){
        UserManagementAction userManagementAction = new UserManagementAction();
        userManagementAction.setEmailID("abc@abc.com");
        assertEquals(Action.ERROR, userManagementAction.signUp());
        assertEquals("Invalid Password. Please enter a valid Password.", userManagementAction.getMessage());
        userManagementAction.setPassword("abc");
        userManagementAction.setMessage(null);
        assertEquals(Action.ERROR, userManagementAction.signUp());
        assertEquals("Invalid Password. Please enter a valid Password.", userManagementAction.getMessage());
    }

    /**
     * Test function to test the functionality to validate institution
     */
    public void testSignUpValidateInstitution(){
        UserManagementAction userManagementAction = new UserManagementAction();
        userManagementAction.setEmailID("abc@abc.com");
        userManagementAction.setPassword("Admin123");
        assertEquals(Action.ERROR, userManagementAction.signUp());
        assertEquals("Institution name exists. Kindly try another name", userManagementAction.getMessage());
    }

    /**
     * Test function to test the functionality to add teacher
     */
    public void testAddTeacher(){
        try {
            UserManagementAction userManagementAction = new UserManagementAction();
            assertEquals(Action.ERROR, userManagementAction.addTeacher());
        } catch (Exception e){
            assertTrue(true);
        }
    }

    /**
     * Test function to test the functionality to fetch teachers
     */
    public void testFetchTeachers(){
        try {
            UserManagementAction userManagementAction = new UserManagementAction();
            assertEquals(Action.ERROR, userManagementAction.fetchTeachers());
        } catch (Exception e){
            assertTrue(true);
        }
    }

    /**
     * Test function to test the functionality to reset password
     */
    public void testResetPassword(){
        UserManagementAction userManagementAction = new UserManagementAction();
        userManagementAction.setNewPassword("Password123");
        userManagementAction.setConfirmPassword("Password");
        assertEquals(Action.ERROR, userManagementAction.resetPassword());
        assertEquals("Passwords does not match. Please re-enter a new password.", userManagementAction.getMessage());
        userManagementAction.setNewPassword("Password");
        assertEquals(Action.ERROR, userManagementAction.resetPassword());
        assertEquals("Invalid Password. Please enter a valid Password.", userManagementAction.getMessage());
        userManagementAction.setNewPassword("Password");
        userManagementAction.setEmailID("abc@gmail.com");
        userManagementAction.setPassword("Ssadmin123");
        userManagementAction.resetPassword();
        assertEquals(Action.ERROR, userManagementAction.resetPassword());
        assertEquals("Invalid Password. Please enter a valid Password.", userManagementAction.getMessage());
    }

}
