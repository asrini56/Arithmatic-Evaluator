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

public class DataSourceTest extends TestCase {

    public void testInsertUser(){
        try {
            DataSource.insertUser("abc@gmail.com", "Ssadmin123", "AdminFirst", "AdminLast");
        } catch (SQLException e){
            assertEquals("Duplicate entry 'abc@gmail.com' for key 'email_id_Index'", e.getLocalizedMessage());
        } catch (Exception e) {
            fail();
        }
    }

    public void testSelectUser(){
        try {
            List<User> userList = DataSource.selectUser("abc@gmail.com");
            assertFalse(userList.isEmpty());
        } catch (Exception e) {
            fail();
        }
    }

    public void testResetPassword(){
        try {
            Integer count = DataSource.resetPassword("abc@gmail.com", "Ssadmin123");
            assertEquals(1, count.intValue());
        } catch (Exception e) {
            fail();
        }
    }

    public void testInsertUserToRole(){
        try {
            DataSource.insertUserToRole(74,1);
        } catch (SQLIntegrityConstraintViolationException e) {
            assertEquals("Duplicate entry '74-1' for key 'PRIMARY'", e.getLocalizedMessage());
        } catch (Exception e) {
            fail();
        }
    }

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

    public void testInsertUserTOInstitution(){
        try {
            DataSource.insertUserTOInstitution(6,1);
        } catch (SQLException e) {
            assertEquals("Duplicate entry '6-1' for key 'PRIMARY'", e.getLocalizedMessage());
        } catch (Exception e) {
            fail();
        }
    }

    public void testSelectInstitutionID(){
        try {
            List<Integer> integerList = DataSource.selectInstitutionID("SRM");
            assertFalse(integerList.isEmpty());
        } catch (Exception e) {
            fail();
        }
    }

    public void testFetchUsersInstitutionID(){
        try {
            Integer count = DataSource.fetchUsersInstitutionID("akrish84@asu.edu");
            assertEquals(1, count.intValue());
        } catch (Exception e) {
            fail();
        }
    }

    public void testFetchInstitutionID(){
        try {
            Integer id = DataSource.fetchInstitutionID("SRM");
            assertEquals(1, id.intValue());
        } catch (Exception e) {
            fail();
        }
    }

    public void testFetchRoles(){
        try {
            Map<String, Integer> rolesMap = DataSource.fetchRoles();
            assertEquals(2, rolesMap.size());
        } catch (Exception e) {
            fail();
        }
    }

    public void testFetchUserID(){
        try {
            Integer id = DataSource.fetchUserID("abc@gmail.com");
            assertEquals(74, id.intValue());
        } catch (Exception e) {
            fail();
        }
    }

    public void testFetchUserRole(){
        try {
            Integer id = DataSource.fetchUserRole(6);
            assertEquals(1, id.intValue());
        } catch (Exception e) {
            fail();
        }
    }

    public void testFetchUserRoleName(){
        try {
            String role = DataSource.fetchUserRoleName("abc@gmail.com");
            assertEquals("admin", role);
        } catch (Exception e) {
            fail();
        }
    }

    public void testFetchTeachers(){
        try {
            List<Teacher> teacherList = DataSource.fetchTeachers(3);
            assertNotNull(teacherList);
        } catch (Exception e) {
            fail();
        }
    }

    public void testDeleteUser(){
        try {
            DataSource.deleteUserWithID(1);
        } catch (Exception e) {
            fail();
        }
    }

    public void testDeleteUserWithEmailID(){
        try {
            DataSource.deleteUserWithEmailID("rand@test.ikl");
        } catch (Exception e) {
            fail();
        }
    }

}
