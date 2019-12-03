package com.asu.ser.operations;

import java.util.ArrayList;

import com.asu.ser.model.TestQuestion;

/**
 * @author Akhilesh
 *
 * TestQuestionsList is a List which extends ArrayList
 * It is a list which adds/fetches/removes TestQuestion objects.
 * It has its own iterator which is used to iterate 
 * over stored the questions.
 *
 */

public class TestQuestionsList extends ArrayList<TestQuestion> {
	
	private static final long serialVersionUID = -2099049967748374557L;
	private QuestionsIterator iterator;
	
	public TestQuestionsList() {
		super(new ArrayList<>());
		iterator = new QuestionsIterator(this);
	}

	public boolean add(TestQuestion question) {
		return super.add(question);
	}

	public TestQuestion remove(int index) {
		return super.remove(index);
	}
	
	public TestQuestion get(int index) {
		return super.get(index);
	}
	
	public QuestionsIterator getIterator() {
		return iterator;
	}
	
	public int size() {
		return super.size();
	}
}
