package com.asu.ser.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asu.ser.model.Student;
import com.asu.ser.model.Teacher;
import com.asu.ser.model.TestQuestion;
import com.asu.ser.model.TestScore;
import com.asu.ser.model.User;
import com.asu.ser.usermanagement.Grade;
import com.asu.ser.usermanagement.TestDetails;

/**
 * @author akhilesh
 * @author Ashwin
 * @author Srinivasan
 */

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
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            lastInsertId = resultSet.getInt(1);
            resultSet.close();
        }
        statement.close();
        return lastInsertId;
    }

    public static List<User> selectUser(String emailID) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.SELECT_USER_USING_EMAIL_PASSWORD);
        statement.setString(1, emailID);
        ResultSet resultSet= statement.executeQuery();
        List<User> userList = new ArrayList<>();
        while(resultSet.next()){
            User user = new User();
            user.setEmailId(resultSet.getString("email_id"));
            user.setPassword(resultSet.getString("password"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            userList.add(user);
        }
        resultSet.close();
        statement.close();
        return userList;
    }

    public static Integer resetPassword(String emailID, String password) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.UPDATE_PASSWORD_USING_EMAIL);
        statement.setString(1, password);
        statement.setString(2, emailID);
        Integer rowsAffected = statement.executeUpdate();
        statement.close();
        return rowsAffected;
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
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            lastInsertId = resultSet.getInt(1);
            resultSet.close();
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
        resultSet.close();
        return institutionIdList;
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

    public static String fetchUserRoleName(String emailID) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.FETCH_USER_ROLE_NAME);
        statement.setString(1, emailID);
        ResultSet resultSet = statement.executeQuery();
        String roleName = null;
        while(resultSet.next()){
            roleName = resultSet.getString("role_name");
        }
        resultSet.close();
        statement.close();
        return roleName;
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
            teachers.add(teacher);
        }
        resultSet.close();
        statement.close();
        return teachers;
    }

    public static List<Student> fetchStudents(int institutionID) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.FETCH_STUDENT_DETAILS);
        statement.setInt(1, institutionID);
        ResultSet resultSet = statement.executeQuery();
        List<Student> students = new ArrayList<>();
        while(resultSet.next()){
            int userID = resultSet.getInt("user_id");
            String emailID = resultSet.getString("email_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String grade = resultSet.getString("grade_name");
            Student student = new Student();
            student.setId(userID);
            student.setEmail(emailID);
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setGrade(grade);
            students.add(student);
        }
        resultSet.close();
        statement.close();
        return students;
    }

    public static List<TestDetails> fetchTestDetails(int userID) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.FETCH_TEST_DETAILS);
        statement.setInt(1, userID);
        ResultSet resultSet = statement.executeQuery();
        List<TestDetails> testDetailsList = new ArrayList<>();
        while(resultSet.next()){
            int id = resultSet.getInt("test_id");
            String name = resultSet.getString("test_name");
            String grade = resultSet.getString("grade_name");
            TestDetails testDetails = new TestDetails();
            testDetails.setTestId(id);
            testDetails.setTestName(name);
            testDetails.setGrade(grade);
            testDetailsList.add(testDetails);
        }
        resultSet.close();
        statement.close();
        return testDetailsList;
    }

    public static void deleteUserWithID(int userID) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.DELETE_USER_WITH_ID);
        statement.setInt(1, userID);
        statement.executeUpdate();
        statement.close();
    }

    public static void deleteUserWithEmailID(String emailID) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.DELETE_USER_WITH_EMAIL_ID);
        statement.setString(1, emailID);
        statement.executeUpdate();
        statement.close();
    }
    
    public static int getGradeID(String grade) throws Exception {
    	Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.GET_GRADE_ID);
        statement.setString(1, grade);
        ResultSet resultSet = statement.executeQuery();
        Integer gradeID = null;
        while(resultSet.next()){
        	gradeID = resultSet.getInt("grade_id");
        }
        resultSet.close();
        statement.close();
        return gradeID;
    }
    
    public static void inserTest(TestDetails testDetails, int loggedInUserID, int gradeID) throws Exception {
    	 Connection connection = DataSourceConnector.getConnection();
         PreparedStatement statement = connection.prepareStatement(SqlQueries.INSERT_TEST, Statement.RETURN_GENERATED_KEYS);
         statement.setString(1, testDetails.getTestName());
         statement.setInt(2, gradeID);
         statement.setInt(3, loggedInUserID);
         Integer testID = null;
         int rowsInserted = statement.executeUpdate();
         if(rowsInserted != 0){
             ResultSet resultSet = statement.getGeneratedKeys();
             resultSet.next();
             testID = resultSet.getInt(1);
             testDetails.setTestId(testID);
             resultSet.close();
         }
         statement.close();
    }
    
    public static void insertTestQuestion(TestDetails testDetails) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.INSERT_TEST_QUESTION, Statement.RETURN_GENERATED_KEYS);
        for(TestQuestion question : testDetails.getQuestions()) {
        	statement.setInt(1, testDetails.getTestId());
        	statement.setString(2, question.getQuestion());
            statement.setString(3, question.getOption1());
            statement.setString(4, question.getOption2());
            statement.setString(5, question.getOption3());
            statement.setString(6, question.getOption4());
            statement.setString(6, question.getOption4());
            statement.setInt(7, question.getAnswer());
            statement.executeUpdate();
        }
        statement.close();
    }
    
    public static void deleteTest(int testID) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.DELETE_TEST);
        statement.setInt(1, testID);
        statement.executeUpdate();
        statement.close();
    }

    public static int fetchGradeID(int userID) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.FETCH_GRADE_ID);
        statement.setInt(1, userID);
        ResultSet resultSet = statement.executeQuery();
        Integer gradeID = null;
        while(resultSet.next()){
            gradeID = resultSet.getInt("grade_id");
        }
        resultSet.close();
        statement.close();
        return gradeID;
    }
    
    public static List<TestDetails> fetchGradeTestDetails(int gradeId) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.FETCH_TEST_DETAILS_GRADE);
        statement.setInt(1, gradeId);
        ResultSet resultSet = statement.executeQuery();
        List<TestDetails> testDetailsList = new ArrayList<>();
        while(resultSet.next()){
            int id = resultSet.getInt("test_id");
            String name = resultSet.getString("test_name");
            String grade = resultSet.getString("grade_name");
            TestDetails testDetails = new TestDetails();
            testDetails.setTestId(id);
            testDetails.setTestName(name);
            testDetails.setGrade(grade);
            testDetailsList.add(testDetails);
        }
        resultSet.close();
        statement.close();
        return testDetailsList;
    }

    public static Integer insertUserTOGrade(Integer studentUserID, Integer grade) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.INSERT_STUDENT_TO_GRADE, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, studentUserID);
        statement.setInt(2, grade);
        int rowsInserted = statement.executeUpdate();
        statement.close();
        return rowsInserted;
    }

    public static Map<String, Integer> fetchGrades() throws Exception {
        Map<String, Integer> userGrades = new HashMap<>();
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.FETCH_ALL_GRADES);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt("grade_id");
            String grade = resultSet.getString("grade_name");
            userGrades.put(grade, id);
        }
        resultSet.close();
        statement.close();
        return userGrades;
    }

    public static List<TestScore> fetchStudentTestScore(int userId) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.SELECT_STUDENT_TEST_SCORE);
        statement.setInt(1, userId);
        ResultSet resultSet = statement.executeQuery();
        List<TestScore> testScoreList = new ArrayList<>();
        while(resultSet.next()){
            String name = resultSet.getString("test_name");
            String score = resultSet.getString("score");
            TestScore testScore = new TestScore();
            testScore.setTestName(name);
            testScore.setScore(score);
            testScoreList.add(testScore);
        }
        resultSet.close();
        statement.close();
        return testScoreList;
    }

    public static String fetchStudentGrade(int gradeID) throws Exception {
        String grade = "Grade-1";
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.FETCH_GRADE_NAME);
        statement.setInt(1, gradeID);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            grade = resultSet.getString("grade_name");
        }
        resultSet.close();
        statement.close();
        return grade;
    }
}
