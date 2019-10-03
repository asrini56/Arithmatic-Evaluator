package com.asu.ser.db;

public class SqlQueries {


	// START USER TABLE QUERIES//
    public static final String INSERT_USER = "INSERT INTO users (email_id, password, first_name, last_name) VALUES (?,?,?,?)";
    public static final String SELECT_USER_USING_EMAIL_PASSWORD = "SELECT email_id, password, first_name, last_name from users WHERE email_id = ?";
    public static final String UPDATE_PASSWORD_USING_EMAIL = "UPDATE users SET password = ? WHERE email_id = ?";

    public static final String FETCH_USER_ID_FROM_EMAIL = "SELECT user_id from users where email_id = ?";

    public static final String FETCH_TEACHERS_DETAILS = "SELECT users.user_id, email_id, first_name, last_name from users inner join user_to_role on "
    		+ "user_to_role.user_id = users.user_id inner join roles on roles.role_id = user_to_role.role_id inner join user_to_institution on "
    		+ "user_to_institution.user_id = users.user_id where roles.role_name = 'teacher' and user_to_institution.institution_id = ?";

    public static final String DELETE_USER = "DELETE from users where user_id = ?";

    // END USER TABLE QUERIES

    // START USER_TO_ROLE, ROLES TABLE QUERIES
    public static final String FETCH_ALL_ROLES = "SELECT role_id, role_name from roles";

    public static final String INSERT_USER_TO_ROLE = "INSERT INTO user_to_role (user_id, role_id) values (? , ?)";
    public static final String FETCH_USER_ROLE = "SELECT role_id from user_to_role where user_id = ?";
    public static final String FETCH_USER_ROLE_NAME = "SELECT role_name from roles where role_id in (SELECT role_id from user_to_role inner join users on users.user_id = user_to_role.user_id where users.email_id = ?)";

    // END USER_TO_ROLE, ROLES TABLE QUERIES

    // START INSTITUTION RELATED TABLES QUERIES
    public static final String INSERT_INSTITUTION = "INSERT INTO institutions (institution_name) VALUES (?)";
    public static final String SELECT_INSTITUTION_ID_USING_NAME = "SELECT institution_id from institutions WHERE institution_name = ?";
    public static final String FETCH_INSTITUTION_ID_USING_USER_EMAIL_ID = "SELECT institution_id from user_to_institution inner join users on users.user_id = user_to_institution.user_id where users.email_id = ?";

    public static final String INSERT_USER_TO_INSTITUTION = "INSERT INTO user_to_institution (user_id, institution_id) VALUES (?,?)";
    // END INSTITUTION RELATED TABLE QUERIES



}
