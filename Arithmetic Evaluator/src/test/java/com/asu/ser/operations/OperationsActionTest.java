package com.asu.ser.operations;

import junit.framework.TestCase;

public class OperationsActionTest extends TestCase {

    public void testEvaluateExpressionSuccess(){
        OperationsAction operationsAction = new OperationsAction();
        operationsAction.setExpression("2+3");
        String result = operationsAction.evaluvateExpression();
        assertEquals("success", result);
    }

    public void testEvaluateExpressionFailure(){
        OperationsAction operationsAction = new OperationsAction();
        operationsAction.setExpression("2+");
        String result = operationsAction.evaluvateExpression();
        assertEquals("success", result);
    }

}
