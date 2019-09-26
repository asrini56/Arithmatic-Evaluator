package com.asu.ser.db;

public class SqlQueries {
	
	
	// use %s for unknown values and use String.format(Query, params) to replace %s in query. 
	
	//TABLE USERS
	//public static final String SELECT_USER = "select * from Users where ID = %s";
    public static final String INSERT_USER = "INSERT INTO TABLE users (email_id, password, first_name, last_name) VALUES (?,?,?,?)";

    public static final String INSERT_INSTITUTION = "INSERT INTO TABLE institutions (institution_name) VALUES (?)";
    public static final String SELECT_INSTITUTION_ID_USING_NAME = "SELECT institution_id from TABLE institutions WHERE institution_name = ?";

    public static final String INSERT_USER_TO_INSTITUTION = "INSERT INTO TABLE user_to_institution (user_id, institution_id) VALUES (?,?)";
}
