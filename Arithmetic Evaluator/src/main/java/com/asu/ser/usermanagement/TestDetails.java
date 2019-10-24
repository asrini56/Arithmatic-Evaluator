package com.asu.ser.usermanagement;

public class TestDetails {
    private Integer id;
    private String testName;
    private Int createdByUserId;
    private Int grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Int getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(Int createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public Int getGrade() {
        return grade;
    }

    public void setGrade(Int grade) {
        this.grade = grade;
    }
}
