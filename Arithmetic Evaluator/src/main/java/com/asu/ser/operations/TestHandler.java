package com.asu.ser.operations;

import org.json.*;

import com.asu.ser.usermanagement.TestDetails;

public class TestHandler {
	
	private static final String JSON_KEY_QUESTIONS = "questions";
	

	public static void addTest(String questionsJSONString) throws Exception {
		JSONObject questionsJSON = new JSONObject(questionsJSONString);
		JSONArray questionsArr = questionsJSON.getJSONArray(JSON_KEY_QUESTIONS);
		TestDetails details = new TestDetails();
		
		for(int i= 0 ; i < questionsArr.length(); i++) {
			
		}
	}

}
