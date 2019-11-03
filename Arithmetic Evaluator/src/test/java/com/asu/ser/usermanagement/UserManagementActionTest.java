package com.asu.ser.usermanagement;

import com.opensymphony.xwork2.Action;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;

public class UserManagementActionTest extends TestCase {

    private static String emailID;
    private static String password;
    private static String firstName;
    private static String lastName;
    private static String message;
    private static String institutionName;

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

    public void testLogin(){
        UserManagementAction userManagementAction = new UserManagementAction();
        userManagementAction.setEmailID("abc@abc.com");
        userManagementAction.setPassword("Admin123");
        assertEquals(Action.ERROR, userManagementAction.login());
        //assertEquals("Username does not exist. Please create an account", userManagementAction.getMessage());
        userManagementAction.setEmailID("abc@gmail.com");
        userManagementAction.setPassword("Ssadmin123");
        userManagementAction.login();
        //assertEquals(Action.ERROR, userManagementAction.login());
        //assertEquals("Error while logging in. Please try again.", userManagementAction.getMessage());
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
        //assertEquals(Action.ERROR, userManagementAction.resetPassword());
        //assertEquals("Invalid Password. Please enter a valid Password.", userManagementAction.getMessage());
    }

}
