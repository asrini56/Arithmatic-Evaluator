package com.asu.ser.operations;

import com.opensymphony.xwork2.Action;
/**
 * @author akhilesh
 * @author Ashwin
 * @author Srinivasan
 */

public class OperationsAction {

	private String expression;
	private String response;
	
	
	public String evaluvateExpression() {
		response = Operations.evaluvateExpression(expression);
		return Action.SUCCESS;
	}
	
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
}
