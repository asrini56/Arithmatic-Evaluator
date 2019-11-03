package com.asu.ser.operations;

import org.json.JSONException;
import org.json.JSONObject;

import com.opensymphony.xwork2.Action;

public class TestAction {
	
	private String questionsJSONAsString;
	private String message;
	
	
	public String addTest() {
		try {
			JSONObject obj = new JSONObject(questionsJSONAsString);
			
		} catch (JSONException e) {
			message = "Failed to add test: Internal Server Error";
		}
		message = "Successfully added test";
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

}
