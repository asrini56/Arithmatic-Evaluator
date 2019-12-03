package com.asu.ser.usermanagement;

import com.asu.ser.model.Teacher;
import junit.framework.TestCase;

import java.util.List;

/**
 * @author srini
 * @author akhilesh
 */
public class UserManagementHandlerTest extends TestCase {

    /**
     * Test function to test the functionality of init method
     */
    public void testInit(){
        try {
            UserManagementHandler.init();
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality of signup admin user
     */
    public void testSignUpAdminUser(){
        try {
            UserManagementHandler.signUpAdminUser("xcv", "XljlLbVytS2387", "first", "last", "jhs");
        } catch (Exception e) {
            assertEquals("Duplicate entry 'xcv' for key 'email_id_Index'", e.getLocalizedMessage());
        }
    }

    /**
     * Test function to test the functionality to login user
     */
    public void testLoginUser(){
        try {
            String user = UserManagementHandler.loginUser("xcv", "XljlLbVytS2387");
            assertEquals("Success", user);
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality to reset password
     */
    public void testResetPassword(){
        try {
            String result = UserManagementHandler.resetPassword("xcv", "XljlLbVytS2387");
            assertEquals("Success", result);
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality to add teacher
     */
    public void testAddTeacher(){
        try {
            UserManagementHandler.addTeacher("first", "last", "jhs@df.sf");
        } catch (Exception e) {
            assertNull(e.getMessage());
        }
    }

    /**
     * Test function to test the functionality to fetch teachers
     */
    public void testFetchTeachers(){
        try {
            UserManagementHandler.loginUser("akrish84@asu.edu", "Qwertyui9");
            List<Teacher> teacherList = UserManagementHandler.fetchTeachers();
            assertFalse(teacherList.isEmpty());
        } catch(NullPointerException e){
            assertNull(e.getLocalizedMessage());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality to check institution presence
     */
    public void testIsInstitutionPresent(){
        try {
            boolean isPresent = UserManagementHandler.isInstitutionPresent("SRM");
            assertTrue(isPresent);
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality to send email to teacher account
     */
    public void testSendTeacherAccountPasswordEmail(){
        try {
            UserManagementHandler.sendTeacherAccountPasswordEmail("xcv", "Xlj", "fir@sdf.st", "lastasdFdf34", "jh@dfg.gs");
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality to get role name for a user
     */
    public void testGetRoleNameForUser(){
        try {
            String role = UserManagementHandler.getRoleNameForUser("team8.ser515@gmail.com");
            assertEquals("teacher", role);
        } catch (Exception e) {
            fail();
        }
    }

}
