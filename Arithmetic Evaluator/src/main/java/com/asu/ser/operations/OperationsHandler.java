package com.asu.ser.operations;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.mariuszgromada.math.mxparser.Expression;

import com.asu.ser.util.MessageConstants;
/**
 * @author akhilesh
 * @author Ashwin
 * @author Srinivasan
 */

public class OperationsHandler {
	private static Logger LOGGER = Logger.getLogger(OperationsHandler.class.getName());
	public static String evaluateExpression(String expression) {
		Expression e = new Expression(expression);
		double output = e.calculate();
		String response = "";
		if(Double.isNaN(output)) {
			response = "Invalid expression: " + expression;
			LOGGER.log(Level.INFO, response);
		} else {
			LOGGER.log(Level.INFO, "Output for expression " + expression + " is : " + output);
			response = Double.toString(output);
		}
		return response;
	}

	public static void main(String[] args) {
		System.out.println(evaluateExpression("sin(30)"));
	}
}
