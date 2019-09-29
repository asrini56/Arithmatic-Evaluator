package com.asu.ser.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asu.ser.usermanagement.Teacher;

public class DataSource {

    public static Integer insertUser(String emailID, String password, String firstName, String lastName) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.INSERT_USER, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, emailID);
        statement.setString(2, password);
        statement.setString(3, firstName);
        statement.setString(4, lastName);
        Integer lastInsertId = null;
        int rowsInserted = statement.executeUpdate();
        if(rowsInserted != 0){
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            lastInsertId = rs.getInt(1);
        }
        statement.close();
        return lastInsertId;
    }

    public static void insertUserToRole(int userID, int roleID) throws Exception {
    	 Connection connection = DataSourceConnector.getConnection();
         PreparedStatement statement = connection.prepareStatement(SqlQueries.INSERT_USER_TO_ROLE);
         statement.setInt(1, userID);
         statement.setInt(2, roleID);
         statement.executeUpdate();
         statement.close();
    }
 
    public static Integer insertInstitution(String institutionName) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.INSERT_INSTITUTION, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, institutionName);
        Integer lastInsertId = null;
        int rowsInserted = statement.executeUpdate();
        if(rowsInserted != 0){
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            lastInsertId = rs.getInt(1);
        }
        statement.close();
        return lastInsertId;
    }

    public static Integer insertUserTOInstitution(Integer userID, Integer institutionID) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.INSERT_USER_TO_INSTITUTION, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, userID);
        statement.setInt(2, institutionID);
        int rowsInserted = statement.executeUpdate();
        statement.close();
        return rowsInserted;
    }

    public static Integer fetchUsersInstitutionID(String emailID) throws Exception {
    	Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.FETCH_INSTITUTION_ID_USING_USER_EMAIL_ID);
        statement.setString(1, emailID);
        ResultSet resultSet = statement.executeQuery();
        Integer institutionID = null;
        while(resultSet.next()){
        	institutionID = resultSet.getInt("institution_id");
        }
        resultSet.close();
        statement.close();
        return institutionID;
    }

    public static Integer fetchInstitutionID(String institutionName) throws Exception{
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.SELECT_INSTITUTION_ID_USING_NAME);
        statement.setString(1, institutionName);
        ResultSet resultSet = statement.executeQuery();
        Integer institutionID = null;
        while(resultSet.next()){
        	institutionID = resultSet.getInt("institution_id");
        }
        resultSet.close();
        statement.close();
        return institutionID;
    }

    public static Map<String, Integer> fetchRoles() throws Exception {
    	Map<String, Integer> userRoles = new HashMap<>();
    	Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.FETCH_ALL_ROLES);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
        	int id = resultSet.getInt("role_id");
        	String role = resultSet.getString("role_name");
        	userRoles.put(role, id);
        }
        resultSet.close();
        statement.close();
        return userRoles;
    }
    
    public static Integer fetchUserID(String emailID) throws Exception {
    	Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.FETCH_USER_ID_FROM_EMAIL);
        statement.setString(1, emailID);
        ResultSet resultSet = statement.executeQuery();
        Integer userID = null;
        while(resultSet.next()){
        	userID = resultSet.getInt("user_id");
        }
        resultSet.close();
        statement.close();
        return userID;
    }
 
    public static Integer fetchUserRole(int userID) throws Exception {
    	Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.FETCH_USER_ROLE);
        statement.setInt(1, userID);
        ResultSet resultSet = statement.executeQuery();
        Integer roleID = null;
        while(resultSet.next()){
        	roleID = resultSet.getInt("role_id");
        }
        resultSet.close();
        statement.close();
        return roleID;
    }

    public static List<Teacher> fetchTeachers(int institutionID) throws Exception {
    	Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.FETCH_TEACHERS_DETAILS);
        statement.setInt(1, institutionID);
        ResultSet resultSet = statement.executeQuery();
        List<Teacher> teachers = new ArrayList<>();
        while(resultSet.next()){
        	int userID = resultSet.getInt("user_id");
        	String emailID = resultSet.getString("email_id");
        	String firstName = resultSet.getString("first_name");
        	String lastName = resultSet.getString("last_name");
        	Teacher teacher = new Teacher();
        	teacher.setId(userID);
        	teacher.setEmail(emailID);
        	teacher.setFirstName(firstName);
        	teacher.setLastName(lastName);
        }
        resultSet.close();
        statement.close();
        return teachers;
    }
    
    public static void deleteUser(int userID) throws Exception {
    	Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.DELETE_USER);
        statement.setInt(1, userID);
        statement.executeUpdate();
        statement.close();
    }
}
