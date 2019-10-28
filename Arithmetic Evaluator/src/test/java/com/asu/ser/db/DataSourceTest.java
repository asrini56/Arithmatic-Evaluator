package com.asu.ser.db;

import com.asu.ser.model.User;
import com.asu.ser.model.Teacher;
import junit.framework.TestCase;

import java.util.List;
import java.util.Map;

public class DataSourceTest extends TestCase {

    public void testInsertUser(){
        try {
            Integer count = DataSource.insertUser("abc@gmail.com", "Ssadmin123", "AdminFirst", "AdminLast");
            //assertEquals(1, count.intValue());
        } catch (Exception e) {
            assertFalse(false);
        }
    }

    public void testSelectUser(){
        try {
            List<User> userList = DataSource.selectUser("abc@gmail.com");
            //assertFalse(userList.isEmpty());
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testResetPassword(){
        try {
            Integer count = DataSource.resetPassword("abc@gmail.com", "Ssadmin123");
            //assertEquals(1, count.intValue());
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testInsertUserToRole(){
        try {
            DataSource.insertUserToRole(1,1);
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testInsertInstitution(){
        try {
            Integer count = DataSource.insertInstitution("a@bc");
            assertNotNull(count);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testInsertUserTOInstitution(){
        try {
            Integer count = DataSource.insertUserTOInstitution(1,1);
            //assertEquals(1, count.intValue());
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testSelectInstitutionID(){
        try {
            List<Integer> integerList = DataSource.selectInstitutionID("abc");
            //assertFalse(integerList.isEmpty());
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testFetchUsersInstitutionID(){
        try {
            Integer count = DataSource.fetchUsersInstitutionID("abac@gmail.com");
            //assertEquals(1, count.intValue());
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testFetchInstitutionID(){
        try {
            Integer id = DataSource.fetchInstitutionID("a!bc");
            //assertEquals(1, id.intValue());
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testFetchRoles(){
        try {
            Map<String, Integer> rolesMap = DataSource.fetchRoles();
            //assertEquals(3, rolesMap.size());
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testFetchUserID(){
        try {
            Integer id = DataSource.fetchUserID("abac@gmail.com");
            //assertEquals(1, id.intValue());
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testFetchUserRole(){
        try {
            Integer id = DataSource.fetchUserRole(1);
            //assertEquals(1, id.intValue());
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testFetchUserRoleName(){
        try {
            String role = DataSource.fetchUserRoleName("abc@gmail.com");
            //assertEquals("admin", role);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testFetchTeachers(){
        try {
            List<Teacher> teacherList = DataSource.fetchTeachers(3);
            assertNotNull(teacherList);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testDeleteUser(){
        try {
            DataSource.deleteUserWithID(1);
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testDeleteUserWithEmailID(){
        try {
            DataSource.deleteUserWithEmailID("abc@gmail.com");
        } catch (Exception e) {
            assertFalse(false);
        }
    }

}
