package com.asu.ser.db;

import com.asu.ser.model.User;
import com.asu.ser.model.Teacher;
import junit.framework.TestCase;
import org.apache.commons.text.RandomStringGenerator;

import java.sql.DataTruncation;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

/**
 * @author srini
 * @author akhilesh
 */
public class DataSourceTest extends TestCase {

    /**
     * Test function to test the functionality of insert user into database
     */
    public void testInsertUser(){
        try {
            DataSource.insertUser("abc@gmail.com", "Ssadmin123", "AdminFirst", "AdminLast");
        } catch (SQLException e){
            assertEquals("Duplicate entry 'abc@gmail.com' for key 'email_id_Index'", e.getLocalizedMessage());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality of select user from database
     */
    public void testSelectUser(){
        try {
            List<User> userList = DataSource.selectUser("abc@gmail.com");
            assertFalse(userList.isEmpty());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality of reset password in database
     */
    public void testResetPassword(){
        try {
            Integer count = DataSource.resetPassword("abc@gmail.com", "Ssadmin123");
            assertEquals(1, count.intValue());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality of insert user_to_role into database
     */
    public void testInsertUserToRole(){
        try {
            DataSource.insertUserToRole(58,2);
        } catch (SQLIntegrityConstraintViolationException e) {
            assertEquals("Duplicate entry '58-2' for key 'PRIMARY'", e.getLocalizedMessage());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality of insert institution into database
     */
    public void testInsertInstitution(){
        try {
            RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
            DataSource.insertInstitution(generator.generate(81));
        } catch (DataTruncation e) {
            assertEquals("Data truncation: Data too long for column 'institution_name' at row 1", e.getLocalizedMessage());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality of insert user_to_institution into database
     */
    public void testInsertUserTOInstitution(){
        try {
            DataSource.insertUserTOInstitution(139,1);
        } catch (SQLException e) {
            assertEquals("Duplicate entry '139-1' for key 'PRIMARY'", e.getLocalizedMessage());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality of select institution from database
     */
    public void testSelectInstitutionID(){
        try {
            List<Integer> integerList = DataSource.selectInstitutionID("SRM");
            assertFalse(integerList.isEmpty());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality of select institution_id for a given user_id from database
     */
    public void testFetchUsersInstitutionID(){
        try {
            Integer count = DataSource.fetchUsersInstitutionID("akrish84@asu.edu");
            assertEquals(21, count.intValue());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality of fetch institution_id for given institution_name from database
     */
    public void testFetchInstitutionID(){
        try {
            Integer id = DataSource.fetchInstitutionID("SRM");
            assertEquals(1, id.intValue());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality of select roles from database
     */
    public void testFetchRoles(){
        try {
            Map<String, Integer> rolesMap = DataSource.fetchRoles();
            assertEquals(3, rolesMap.size());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality of select user_id from database
     */
    public void testFetchUserID(){
        try {
            Integer id = DataSource.fetchUserID("team8.ser515@gmail.com");
            assertEquals(58, id.intValue());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality of select  user_role from database
     */
    public void testFetchUserRole(){
        try {
            Integer id = DataSource.fetchUserRole(58);
            assertEquals(2, id.intValue());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality of select user role_name from database
     */
    public void testFetchUserRoleName(){
        try {
            String role = DataSource.fetchUserRoleName("team8.ser515@gmail.com");
            assertEquals("teacher", role);
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality of select teachers from database
     */
    public void testFetchTeachers(){
        try {
            List<Teacher> teacherList = DataSource.fetchTeachers(3);
            assertNotNull(teacherList);
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality of delete user from database
     */
    public void testDeleteUser(){
        try {
            DataSource.deleteUserWithID(500);
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test function to test the functionality of delete user for given mail_id from database
     */
    public void testDeleteUserWithEmailID(){
        try {
            DataSource.deleteUserWithEmailID("rand@test.ikl");
        } catch (Exception e) {
            fail();
        }
    }

}
