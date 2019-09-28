package com.asu.ser.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Integer> selectInstitutionID(String institutionName) throws Exception{
        List<Integer> institutionIdList = new ArrayList<>();
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.SELECT_INSTITUTION_ID_USING_NAME);
        statement.setString(1, institutionName);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            institutionIdList.add(resultSet.getInt("institution_id"));
        }
        return institutionIdList;
    }

}
