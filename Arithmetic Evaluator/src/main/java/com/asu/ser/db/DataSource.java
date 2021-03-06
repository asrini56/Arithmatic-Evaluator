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
import com.asu.ser.model.TestAnswers;
import com.asu.ser.model.TestQuestion;
import com.asu.ser.model.TestScore;
import com.asu.ser.model.User;
import com.asu.ser.usermanagement.TestDetails;

/**
 * @author akhilesh
 * @author Ashwin
 * @author Srinivasan
 * @author Aihaab
 * @author deepti
 */

public class DataSource {

    /**
     * Function to insert user into database
     * @param emailID
     * @param password
     * @param firstName
     * @param lastName
     * @return
     * @throws Exception
     */
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

    /**
     * Function to select user from database
     * @param emailID
     * @return
     * @throws Exception
     */
    public static List<User> selectUser(String emailID) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.SELECT_USER_USING_EMAIL_PASSWORD);
        statement.setString(1, emailID);
        ResultSet resultSet= statement.executeQuery();
        List<User> userList = new ArrayList<>();
        while(resultSet.next()){
            User user = new User();
            user.setEmail(resultSet.getString("email_id"));
            user.setPassword(resultSet.getString("password"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            userList.add(user);
        }
        resultSet.close();
        statement.close();
        return userList;
    }

    /**
     * Function to reset password in database
     * @param emailID
     * @param password
     * @return
     * @throws Exception
     */
    public static Integer resetPassword(String emailID, String password) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.UPDATE_PASSWORD_USING_EMAIL);
        statement.setString(1, password);
        statement.setString(2, emailID);
        Integer rowsAffected = statement.executeUpdate();
        statement.close();
        return rowsAffected;
    }

    /**
     * Function to insert user_to_role into database
     * @param userID
     * @param roleID
     * @throws Exception
     */
    public static void insertUserToRole(int userID, int roleID) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.INSERT_USER_TO_ROLE);
        statement.setInt(1, userID);
        statement.setInt(2, roleID);
        statement.executeUpdate();
        statement.close();
    }

    /**
     * Function to insert institution  into database
     * @param institutionName
     * @return
     * @throws Exception
     */
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

    /**
     * Function to insert user_to_institution into database
     * @param userID
     * @param institutionID
     * @return
     * @throws Exception
     */
    public static Integer insertUserTOInstitution(Integer userID, Integer institutionID) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.INSERT_USER_TO_INSTITUTION, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, userID);
        statement.setInt(2, institutionID);
        int rowsInserted = statement.executeUpdate();
        statement.close();
        return rowsInserted;
    }

    /**
     * Function to select institution_id from database
     * @param institutionName
     * @return
     * @throws Exception
     */
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

    /**
     * Function to select institution_id from database
     * @param emailID
     * @return
     * @throws Exception
     */
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

    /**
     * Function to select institution_id from database
     * @param institutionName
     * @return
     * @throws Exception
     */
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

    /**
     * Function to fetch roles from database
     * @return
     * @throws Exception
     */
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

    /**
     * Function to select user_id from database for given email_id
     * @param emailID
     * @return
     * @throws Exception
     */
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

    /**
     * Function to select user role from database for given user_id
     * @param userID
     * @return
     * @throws Exception
     */
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

    /**
     * Function to select user role_name from database for given email_id
     * @param emailID
     * @return
     * @throws Exception
     */
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

    /**
     * Function to  select teacher from database for given institution_id
     * @param institutionID
     * @return
     * @throws Exception
     */
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

    /**
     * Function to select Student from database for given institution_id
     * @param institutionID
     * @return
     * @throws Exception
     */
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

    /**
     * Function to select test details from database for given user_id
     * @param userID
     * @return
     * @throws Exception
     */
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

    /**
     * Function to delete user form database for given user_id
     * @param userID
     * @throws Exception
     */
    public static void deleteUserWithID(int userID) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.DELETE_USER_WITH_ID);
        statement.setInt(1, userID);
        statement.executeUpdate();
        statement.close();
    }

    /**
     * Function to delete user from database for given email_id
     * @param emailID
     * @throws Exception
     */
    public static void deleteUserWithEmailID(String emailID) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.DELETE_USER_WITH_EMAIL_ID);
        statement.setString(1, emailID);
        statement.executeUpdate();
        statement.close();
    }

    /**
     * Function to  select grade_id from database for given grade
     * @param grade
     * @return
     * @throws Exception
     */
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

    /**
     * Function to insert test into database
     * @param testDetails
     * @param loggedInUserID
     * @param gradeID
     * @throws Exception
     */
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

    /**
     * Function to insert test question into database
     * @param testDetails
     * @throws Exception
     */
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

    /**
     * Function to delete test from database for given test_id
     * @param testID
     * @throws Exception
     */
    public static void deleteTest(int testID) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.DELETE_TEST);
        statement.setInt(1, testID);
        statement.executeUpdate();
        statement.close();
    }

    /**
     * Function to select grade_id from database for given user_id
     * @param userID
     * @return
     * @throws Exception
     */
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

    /**
     * Function to select grade test details from database for given email_id and institution_id
     * @param userEmailID
     * @param institutionID
     * @return
     * @throws Exception
     */
    public static List<TestDetails> fetchGradeTestDetails(String  userEmailID, int institutionID) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.FETCH_TEST_DETAILS_FOR_USER);
        statement.setString(1, userEmailID);
        statement.setInt(2, institutionID);
        ResultSet resultSet = statement.executeQuery();
        List<TestDetails> testDetailsList = new ArrayList<>();
        while(resultSet.next()){
            int id = resultSet.getInt("test_id");
            String name = resultSet.getString("test_name");
            TestDetails testDetails = new TestDetails();
            testDetails.setTestId(id);
            testDetails.setTestName(name);
            testDetailsList.add(testDetails);
        }
        resultSet.close();
        statement.close();
        return testDetailsList;
    }

    /**
     * Function to select test name from database for given test_id
     * @param testID
     * @return
     * @throws Exception
     */
    public static String fetchTestNameForTestID(int testID) throws Exception {
    	Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.FETCH_TEST_DETAILS_FOR_ID);
        statement.setInt(1, testID);
        ResultSet resultSet = statement.executeQuery();
        String testName = "";
        while(resultSet.next()){
        	testName = resultSet.getString("test_name");
        }
        resultSet.close();
        statement.close();
        return testName;
    }

    /**
     * Function to select test details from database for given test_id
     * @param testID
     * @param hasAnswers
     * @return
     * @throws Exception
     */
    public static TestDetails fetchTestDetailsForID(int testID, boolean hasAnswers) throws Exception {
    	Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.FETCH_TEST_QUESTIONS);
        statement.setInt(1, testID);
        ResultSet resultSet = statement.executeQuery();
        List<TestQuestion> testQuestions = new ArrayList<>();
        while(resultSet.next()){
        	int questionID = resultSet.getInt("question_id");
        	String question = resultSet.getString("question");
        	String option1 = resultSet.getString("option1");
        	String option2 = resultSet.getString("option2");
        	String option3 = resultSet.getString("option3");
        	String option4 = resultSet.getString("option4");
        	int answer = -1;
        	if(hasAnswers) {
        		answer = resultSet.getInt("answer");
        	}
        	TestQuestion testQuestion = new TestQuestion();

        	testQuestion.setId(questionID);
        	testQuestion.setQuestion(question);
        	testQuestion.setOption1(option1);
        	testQuestion.setOption2(option2);
        	testQuestion.setOption3(option3);
        	testQuestion.setOption4(option4);
        	testQuestion.setAnswer(answer);
        	testQuestions.add(testQuestion);
        }
        TestDetails testDetail = new TestDetails();
        testDetail.setQuestions(testQuestions);
        testDetail.setTestName(fetchTestNameForTestID(testID));
        testDetail.setTestId(testID);
        return testDetail;
    }

    /**
     * Function to insert student_test into database
     * @param studentID
     * @param testID
     * @param score
     * @return
     * @throws Exception
     */
    public static int insertStudentTest(int studentID, int testID, int score) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.INSERT_STUDENT_TEST, Statement.RETURN_GENERATED_KEYS);
    	statement.setInt(1, studentID);
    	statement.setInt(2, testID);
        statement.setInt(3, score);
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

    /**
     * Function to  insert student_test_answers into database
     * @param studentTestID
     * @param testQuestions
     * @throws Exception
     */
    public static void insertStudentTestAnswers(int studentTestID, Map<Integer, TestQuestion> testQuestions) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.INSERT_STUDENT_TEST_ANSWERS, Statement.RETURN_GENERATED_KEYS);
        for(Integer questionID : testQuestions.keySet()) {
        	TestQuestion question = testQuestions.get(questionID);
        	statement.setInt(1, studentTestID);
        	statement.setInt(2, questionID);
        	statement.setInt(3, question.getAnswer());
            statement.executeUpdate();
        }
        statement.close();
    }

    /**
     * Function to insert user_to_grade into database
     * @param studentUserID
     * @param grade
     * @return
     * @throws Exception
     */
    public static Integer insertUserTOGrade(Integer studentUserID, Integer grade) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.INSERT_STUDENT_TO_GRADE, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, studentUserID);
        statement.setInt(2, grade);
        int rowsInserted = statement.executeUpdate();
        statement.close();
        return rowsInserted;
    }

    /**
     * Function to select grade from database
     * @return
     * @throws Exception
     */
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

    /**
     * Function to select student_test_score from database for given user_id
     * @param userId
     * @return
     * @throws Exception
     */
    public static List<TestScore> fetchStudentTestScore(int userId) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.SELECT_STUDENT_TEST_SCORE);
        statement.setInt(1, userId);
        ResultSet resultSet = statement.executeQuery();
        List<TestScore> testScoreList = new ArrayList<>();
        while(resultSet.next()){
            String name = resultSet.getString("test_name");
            String score = resultSet.getString("score");
            String testId = resultSet.getString("test_id");
            TestScore testScore = new TestScore();
            testScore.setTestId(testId);
            testScore.setTestName(name);
            testScore.setScore(score);
            testScoreList.add(testScore);
        }
        resultSet.close();
        statement.close();
        return testScoreList;
    }

    /**
     * Function to select student_grade from database for given grade_id
     * @param gradeID
     * @return
     * @throws Exception
     */
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

    /**
     * Function to select student test correct answers from database for given user_id and test_id
     * @param userId
     * @param testId
     * @return
     * @throws Exception
     */
    public static List<TestAnswers> fetchStudentTestCorrectAnswers(int userId, int testId) throws Exception {
        Connection connection = DataSourceConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlQueries.SELECT_STUDENT_TEST_CORRECT_ANSWERS);
        statement.setInt(1, userId);
        statement.setInt(2, testId);
        ResultSet resultSet = statement.executeQuery();
        List<TestAnswers> testAnswersList = new ArrayList<>();
        while(resultSet.next()){
            TestAnswers testAnswers = new TestAnswers();
            testAnswers.setQuestion(resultSet.getString("question"));
            String correctAnswer = resultSet.getString("correct_answer");
            String actualAnswer = resultSet.getString("actual_answer");
            testAnswers.setCorrectAnswer(resultSet.getString("option"+correctAnswer));
            testAnswers.setActualAnswer(resultSet.getString("option"+actualAnswer));
            testAnswersList.add(testAnswers);
        }
        resultSet.close();
        statement.close();
        return testAnswersList;
    }

}
