package com.asu.ser.operations;

import junit.framework.TestCase;

/**
 * @author srini
 * @author akhilesh
 */
public class OperationsActionTest extends TestCase {

    /**
     * Test function to test the functionality to evaluate expression - Success scenario
     */
    public void testEvaluateExpressionSuccess(){
        OperationsAction operationsAction = new OperationsAction();
        operationsAction.setExpression("2+3");
        String result = operationsAction.evaluvateExpression();
        assertEquals("success", result);
    }

    /**
     * Test function to test the functionality to evaluate expression - Error scenario
     */
    public void testEvaluateExpressionFailure(){
        OperationsAction operationsAction = new OperationsAction();
        operationsAction.setExpression("2+");
        String result = operationsAction.evaluvateExpression();
        assertEquals("success", result);
    }

}
