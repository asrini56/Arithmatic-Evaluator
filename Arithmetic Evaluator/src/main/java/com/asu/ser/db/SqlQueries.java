package com.asu.ser.db;
/**
 * @author akhilesh
 * @author Ashwin
 * @author Srinivasan
 */

public class SqlQueries {


	// START USER TABLE QUERIES//
    public static final String INSERT_USER = "INSERT INTO users (email_id, password, first_name, last_name) VALUES (?,?,?,?)";
    public static final String SELECT_USER_USING_EMAIL_PASSWORD = "SELECT email_id, password, first_name, last_name from users WHERE email_id = ?";
    public static final String UPDATE_PASSWORD_USING_EMAIL = "UPDATE users SET password = ? WHERE email_id = ?";

    public static final String FETCH_USER_ID_FROM_EMAIL = "SELECT user_id from users where email_id = ?";

    public static final String FETCH_TEACHERS_DETAILS = "SELECT users.user_id, email_id, first_name, last_name from users inner join user_to_role on "
    		+ "user_to_role.user_id = users.user_id inner join roles on roles.role_id = user_to_role.role_id inner join user_to_institution on "
    		+ "user_to_institution.user_id = users.user_id where roles.role_name = 'teacher' and user_to_institution.institution_id = ?";

    public static final String FETCH_STUDENT_DETAILS = "SELECT users.user_id, email_id, first_name, last_name, grades.grade_name from users " +
            "inner join user_to_role on user_to_role.user_id = users.user_id " +
            "inner join roles on roles.role_id = user_to_role.role_id " +
            "inner join user_to_institution on user_to_institution.user_id = users.user_id " +
            "inner join student_to_grade on student_to_grade.user_id = users.user_id " +
            "inner join grades on student_to_grade.grade_id = grades.grade_id " +
            "where roles.role_name = 'student' and user_to_institution.institution_id = ?";

    public static final String DELETE_USER_WITH_ID = "DELETE from users where user_id = ?";
    public static final String DELETE_USER_WITH_EMAIL_ID = "DELETE from users where email_id = ?";

    // END USER TABLE QUERIES

    // START USER_TO_ROLE, ROLES TABLE QUERIES
    public static final String FETCH_ALL_ROLES = "SELECT role_id, role_name from roles";

    public static final String INSERT_USER_TO_ROLE = "INSERT INTO user_to_role (user_id, role_id) values (? , ?)";
    public static final String FETCH_USER_ROLE = "SELECT role_id from user_to_role where user_id = ?";
    public static final String FETCH_USER_ROLE_NAME = "SELECT role_name from roles where role_id in (SELECT role_id from user_to_role inner join users on users.user_id = "
    		+ "user_to_role.user_id where users.email_id = ?)";

    // END USER_TO_ROLE, ROLES TABLE QUERIES

    // START INSTITUTION RELATED TABLES QUERIES
    public static final String INSERT_INSTITUTION = "INSERT INTO institutions (institution_name) VALUES (?)";
    public static final String SELECT_INSTITUTION_ID_USING_NAME = "SELECT institution_id from institutions WHERE institution_name = ?";
    public static final String FETCH_INSTITUTION_ID_USING_USER_EMAIL_ID = "SELECT institution_id from user_to_institution inner join users on users.user_id = "
    		+ "user_to_institution.user_id where users.email_id = ?";

    public static final String INSERT_USER_TO_INSTITUTION = "INSERT INTO user_to_institution (user_id, institution_id) VALUES (?,?)";
    // END INSTITUTION RELATED TABLE QUERIES
    
    // START GRADES RELATED TABLE QUERIES
    public static final String GET_GRADE_ID = "Select grade_id from grades where grade_name = ?";
    // END GRADES RELATED TABLE QUERIES
    
    
    // START TESTDETAILS RELATED TABLE QUERIES
    public static final String INSERT_TEST = "INSERT into tests(test_name, grade_id, created_by_user_id) values(?, ?, ?)";
    public static final String INSERT_TEST_QUESTION = "INSERT into test_questions(test_id, question, option1, option2, option3, option4, answer) values(?, ?, ?, ?, ?, ?, ?)";
    public static final String DELETE_TEST = "DELETE from tests where test_id = ?";
    public static final String FETCH_TEST_DETAILS ="SELECT test_id, test_name, tests.grade_id, grade_name from tests inner join grades on tests.grade_id = grades.grade_id"
    		+ " where created_by_user_id = ?";
    public static final String FETCH_TEST_DETAILS_FOR_ID = "SELECT test_id, test_name from tests where test_id = ?";
    public static final String FETCH_TEST_QUESTIONS = "SELECT question_id, question, option1, option2, option3, option4, answer from test_questions where test_id = ?";
    public static final String FETCH_TEST_DETAILS_GRADE ="SELECT test_id, test_name, tests.grade_id, grade_name from tests inner join grades on tests.grade_id "
    		+ "= grades.grade_id where grade_id = ?";
    public static final String FETCH_GRADE_ID = "SELECT grade_id from student_to_grade where user_id = ?";    
    public static final String FETCH_TEST_DETAILS_FOR_USER = "SELECT test_id, test_name, tests.grade_id from tests inner join student_to_grade on student_to_grade.grade_id "
    		+ "= tests.grade_id inner join users on users.user_id = student_to_grade.user_id where users.email_id=?";
    public static final String FETCH_GRADE_NAME = "Select grade_name from grades where grade_id = ?";

    // 	END TESTDETAILS RELATED TABLE QUERIES
    
    // START STUDENT TEST RELATED TABLE QUERIES
    public static final String INSERT_STUDENT_TEST = "INSERT into student_test(student_id, test_id, score) values(?, ?, ?)";
    public static final String INSERT_STUDENT_TEST_ANSWERS = "INSERT into student_test_answers(student_test_id, question_id, answer) values(?, ?, ?)";


    public static final String FETCH_ALL_GRADES = "SELECT grade_id, grade_name from grades";

    public static final String INSERT_STUDENT_TO_GRADE = "INSERT INTO student_to_grade (user_id, grade_id) VALUES (?,?)";

    public static final String SELECT_STUDENT_TEST_SCORE = "SELECT tests.test_name, student_test.score from student_test " +
            "inner join tests on tests.test_id = student_test.test_id where student_test.student_id = ?";



}
