package com.asu.ser.usermanagement;
/**
 * @author Ashwin
 */

import java.util.List;

import com.asu.ser.model.TestQuestion;

public class TestDetails {
    private Integer testId;
    private String testName;
    private Integer createdByUserId;
    private Integer gradeId;
    private List<TestQuestion> questions;

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Integer getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(Integer createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

	public List<TestQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<TestQuestion> questions) {
		this.questions = questions;
	}
}
