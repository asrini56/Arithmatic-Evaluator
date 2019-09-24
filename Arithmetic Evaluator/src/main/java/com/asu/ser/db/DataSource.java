package com.asu.ser.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import static com.asu.ser.db.SqlQueries.INSERT_USER;

public class DataSource {

    public static void insertAdminUser(String firstName, String lastName, String dob, String emailID, String password) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(INSERT_USER);
        statement.setString(1,firstName);
        statement.setString(2,lastName);
        statement.setString(3,dob);
        statement.setString(4,emailID);
        statement.setString(5,password);
        statement.executeUpdate();
        statement.close();
    }

}
