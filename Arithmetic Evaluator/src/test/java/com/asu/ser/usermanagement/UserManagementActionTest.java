package com.asu.ser.usermanagement;

import com.opensymphony.xwork2.Action;
import junit.framework.TestCase;

public class UserManagementActionTest extends TestCase {

    public void testSignUpValidateEmail(){
        UserManagementAction userManagementAction = new UserManagementAction();
        assertEquals(Action.ERROR, userManagementAction.signUp());
        assertEquals("Invalid Email ID. Please enter a valid Email ID.", userManagementAction.getMessage());
        userManagementAction.setEmailID("abc");
        userManagementAction.setMessage(null);
        assertEquals(Action.ERROR, userManagementAction.signUp());
        assertEquals("Invalid Email ID. Please enter a valid Email ID.", userManagementAction.getMessage());
    }

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

    public void testSignUpValidateInstitution(){
        UserManagementAction userManagementAction = new UserManagementAction();
        userManagementAction.setEmailID("abc@abc.com");
        userManagementAction.setPassword("Admin123");
        assertEquals(Action.ERROR, userManagementAction.signUp());
        assertEquals("Institution name exists. Kindly try another name", userManagementAction.getMessage());
    }

    public void testAddTeacher(){
        try {
            UserManagementAction userManagementAction = new UserManagementAction();
            assertEquals(Action.ERROR, userManagementAction.addTeacher());
        } catch (Exception e){
            assertTrue(true);
        }
    }

    public void testFetchTeachers(){
        try {
            UserManagementAction userManagementAction = new UserManagementAction();
            assertEquals(Action.ERROR, userManagementAction.fetchTeachers());
        } catch (Exception e){
            assertTrue(true);
        }
    }

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
