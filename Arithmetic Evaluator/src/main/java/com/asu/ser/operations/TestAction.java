package com.asu.ser.operations;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.asu.ser.usermanagement.TestDetails;
import com.opensymphony.xwork2.Action;

/**
 * 
 * @author akhilesh
 *
 */

public class TestAction {
	
	private String questionsJSONAsString;
	private String testName;
	private int testForGrade;
	private String message;
	private int testID;
	private TestDetails testDetail;

	private static Logger LOGGER = Logger.getLogger(TestAction.class.getName());
	
	public String addTest() {
		try {
			questionsJSONAsString = URLDecoder.decode(questionsJSONAsString, StandardCharsets.UTF_8.toString());
			LOGGER.log(Level.INFO, "Adding test " + questionsJSONAsString);
			TestHandler.addTest(questionsJSONAsString, testName, testForGrade);
			message = "Successfully added test";
			LOGGER.log(Level.INFO, "message");
		} catch (Exception e) {
			message = "Failed to add test: Internal Server Error";
			LOGGER.log(Level.SEVERE, message, e);
		}
		
		return Action.SUCCESS;
	}
	
	public String fetchTest() {
		try {
			testDetail = TestHandler.fetchTestDetailsForID(testID);
		} catch(Exception e) {
			message = "Unable to fetch test questions for test";
			LOGGER.log(Level.SEVERE, message + " : " + testID);
		}
		return Action.SUCCESS;
	}

	public String forwardToTakeTest() {
		return Action.SUCCESS;
	}

	public String getQuestionsJSONAsString() {
		return questionsJSONAsString;
	}

	public void setQuestionsJSONAsString(String questionsJSONAsString) {
		this.questionsJSONAsString = questionsJSONAsString;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getTestForGrade() {
		return testForGrade;
	}

	public void setTestForGrade(int testForGrade) {
		this.testForGrade = testForGrade;
	}
	
	public int getTestID() {
		return testID;
	}

	public void setTestID(int testID) {
		this.testID = testID;
	}

	public TestDetails getTestDetail() {
		return testDetail;
	}

	public void setTestDetail(TestDetails testDetail) {
		this.testDetail = testDetail;
	}


}
