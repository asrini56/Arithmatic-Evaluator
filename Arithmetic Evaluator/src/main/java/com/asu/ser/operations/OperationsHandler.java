package com.asu.ser.operations;

import org.mariuszgromada.math.mxparser.Expression;
/**
 * @author akhilesh
 * @author Ashwin
 * @author Srinivasan
 */

public class OperationsHandler {

	public static String evaluateExpression(String expression) {
		Expression e = new Expression(expression);
		double output = e.calculate();
		String response = "";
		if(Double.isNaN(output)) {
			response = "Invalid expression:\n" + expression;
			System.out.println(response);
		} else {
			System.out.println("Output for expression " + expression + " is : " + output );
			response = Double.toString(output);
		}
		return response;
	}
}
