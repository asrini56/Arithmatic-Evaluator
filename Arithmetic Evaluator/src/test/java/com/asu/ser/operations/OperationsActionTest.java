package com.asu.ser.operations;

import junit.framework.TestCase;

public class OperationsActionTest extends TestCase {

    public void testEvaluateExpression(){
        OperationsAction operationsAction = new OperationsAction();
        operationsAction.setExpression("2+3");
        String result = operationsAction.evaluvateExpression();
        assertEquals("success", result);
        operationsAction.setExpression("2+");
        result = operationsAction.evaluvateExpression();
        assertEquals("success", result);
    }
}
