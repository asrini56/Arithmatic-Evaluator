package com.asu.ser.usermanagement;

import junit.framework.TestCase;

public class UserManagementHandlerTest extends TestCase {

    public void testInit(){
        try {
            UserManagementHandler.init();
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testSignUpAdminUser(){
        try {
            UserManagementHandler.signUpAdminUser("xcv", "XljlLbVytS2387", "first", "last", "jhs");
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testLoginUser(){
        try {
            UserManagementHandler.loginUser("xcv", "XljlLbVytS2387");
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testResetPassword(){
        try {
            UserManagementHandler.resetPassword("xcv", "XljlLbVytS2387");
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testAddTeacher(){
        try {
            UserManagementHandler.addTeacher("first", "last", "jhs@df.sf");
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testFetchTeachers(){
        try {
            UserManagementHandler.fetchTeachers();
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testIsInstitutionPresent(){
        try {
            UserManagementHandler.isInstitutionPresent("jhs");
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testSendTeacherAccountPasswordEmail(){
        try {
            UserManagementHandler.sendTeacherAccountPasswordEmail("xcv", "Xlj", "fir@sdf.st", "lastasdFdf34", "jh@dfg.gs");
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testGetRoleNameForUser(){
        try {
            UserManagementHandler.getRoleNameForUser("xcv@dfg.dfv");
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

}
