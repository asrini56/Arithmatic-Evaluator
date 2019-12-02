package com.asu.ser.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.*;

import com.asu.ser.authentication.AuthenticationUtil;
import com.asu.ser.db.DataSource;
import com.asu.ser.model.TestQuestion;
import com.asu.ser.usermanagement.Grade;
import com.asu.ser.usermanagement.TestDetails;
import com.asu.ser.usermanagement.UserManagementHandler;
import com.asu.ser.util.MessageConstants;

/**
 * 
 * @author akhilesh
 *
 */

public class TestHandler {
	
	private static final String JSON_KEY_QUESTIONS = "questions";
	private static final String JSON_KEY_QUESTION_ID = "questionID";
	private static final String JSON_KEY_QUESTION = "question";
	private static final String JSON_KEY_OPTION1 = "option1";
	private static final String JSON_KEY_OPTION2 = "option2";
	private static final String JSON_KEY_OPTION3 = "option3";
	private static final String JSON_KEY_OPTION4 = "option4";
	private static final String JSON_KEY_ANSWER = "answer";
	private static Logger LOGGER = Logger.getLogger(TestHandler.class.getName());

	public static void addTest(String questionsJSONAsString, String testName, int testForGrade) throws Exception {
		JSONObject questionsJSON = new JSONObject(questionsJSONAsString);
		JSONArray questionsArr = questionsJSON.getJSONArray(JSON_KEY_QUESTIONS);
		TestDetails details = new TestDetails();
		details.setTestName(testName);
		details.setGradeId(testForGrade);
		String loggedInUser = AuthenticationUtil.getLoggedInUser();
    	if(loggedInUser == null || loggedInUser.isEmpty()) {
    		throw new Exception(MessageConstants.NO_USER_LOGGED_IN);
    	}
    	int userID = DataSource.fetchUserID(loggedInUser);
    	int gradeID = DataSource.getGradeID(Grade.get(testForGrade));
    	DataSource.inserTest(details, userID, gradeID);
		List<TestQuestion> testQuestions = new ArrayList<>();
		for(int i= 0 ; i < questionsArr.length(); i++) {
			JSONObject questionObj = questionsArr.getJSONObject(i);
			String question = questionObj.getString(JSON_KEY_QUESTION);
			String option1 = questionObj.getString(JSON_KEY_OPTION1);
			String option2 = questionObj.getString(JSON_KEY_OPTION2);
			String option3 = questionObj.getString(JSON_KEY_OPTION3);
			String option4 = questionObj.getString(JSON_KEY_OPTION4);
			int answer = questionObj.getInt(JSON_KEY_ANSWER);
			TestQuestion testQuestion = new TestQuestion();
			testQuestion.setQuestion(question);
			testQuestion.setOption1(option1);
			testQuestion.setOption2(option2);
			testQuestion.setOption3(option3);
			testQuestion.setOption4(option4);
			testQuestion.setAnswer(answer);
			testQuestions.add(testQuestion);
		}
		details.setQuestions(testQuestions);
		try {
			DataSource.insertTestQuestion(details);
		} catch(Exception e) {
			DataSource.deleteTest(details.getTestId());
			throw e;
		}
	}
	
	
	/**
	 * Function saves the questions and answers for a given test in DB
	 * Uses TestQuestion Iterator to iterate over questions to add into DB.
	 * 
	 * @param questionsJSONAsString
	 * @param testID
	 * @throws Exception
	 */
	public static void submitTest(String questionsJSONAsString, int testID) throws Exception {
		String loggedInUser = AuthenticationUtil.getLoggedInUser();
        if(loggedInUser == null || loggedInUser.isEmpty()) {
            throw new Exception(MessageConstants.NO_USER_LOGGED_IN);
        }
        
        LOGGER.log(Level.SEVERE, "Test id is " + testID);
        TestDetails details = DataSource.fetchTestDetailsForID(testID, true);
        LOGGER.log(Level.SEVERE, "TestID " + testID + "questions are " + details.getQuestions().size());
        
        JSONObject questionsJSON = new JSONObject(questionsJSONAsString);
		JSONArray questionsArr = questionsJSON.getJSONArray(JSON_KEY_QUESTIONS);
		Map<Integer, TestQuestion> testQuestions = new HashMap<>();
		for(int i= 0 ; i < questionsArr.length(); i++) {
			JSONObject questionObj = questionsArr.getJSONObject(i);
			int questionID = questionObj.getInt(JSON_KEY_QUESTION_ID);
			int answer = questionObj.getInt(JSON_KEY_ANSWER);
			TestQuestion testQuestion = new TestQuestion();
			
			testQuestion.setAnswer(answer);
			testQuestions.put(questionID, testQuestion);
		}
		int score = 0;
		int totalScore = 0;
		
		TestQuestionsList qL = details.getQuestionsList();
		if(qL!= null) {
			int valScored = 0;
			QuestionsIterator itr = qL.getIterator();
			while(itr.hasNext()) {
				TestQuestion question = itr.next();
				if(question!=null) {
					valScored += question.getAnswer();
					totalScore += valScored;
				}
			}
		}
		
		for(TestQuestion question : details.getQuestions()) {
			int studentAnswer = testQuestions.get(question.getId()).getAnswer();
			int actualAnswer = question.getAnswer();
			totalScore++;
			if(studentAnswer == actualAnswer) {
				score++;
			}
		}
		float finalPercent = ((float)score / (float)totalScore) * 100;
		int studentTestID = DataSource.insertStudentTest(DataSource.fetchUserID(loggedInUser), testID, (int)finalPercent);
		DataSource.insertStudentTestAnswers(studentTestID, testQuestions);
	}
	
    public static List<TestDetails> fetchTestDetails() throws Exception {
        String loggedInUser = AuthenticationUtil.getLoggedInUser();
        if(loggedInUser == null || loggedInUser.isEmpty()) {
            throw new Exception(MessageConstants.NO_USER_LOGGED_IN);
        }
        int userID = DataSource.fetchUserID(loggedInUser);
        int userRoleID = DataSource.fetchUserRole(userID);
        int teacherRoleID = UserManagementHandler.getTeacherRoleID();
        if(userRoleID != teacherRoleID) {
            throw new Exception(MessageConstants.ILLEGAL_OPERATION_NO_PERMISSION);
        }
        return DataSource.fetchTestDetails(userID);
    }
    
    public static TestDetails fetchTestDetailsForID(int testID) throws Exception {
    	String loggedInUser = AuthenticationUtil.getLoggedInUser();
        if(loggedInUser == null || loggedInUser.isEmpty()) {
            throw new Exception(MessageConstants.NO_USER_LOGGED_IN);
        }
        return DataSource.fetchTestDetailsForID(testID, false);
    }

}
