package com.asu.ser.operations;

import com.asu.ser.model.TestQuestion;
/**
 * @author akhilesh
 */

/**
 * An iterator class to iterate over TestQuestions objects.
 *
 */
public class QuestionsIterator implements ListIterator {
	TestQuestionsList questions;
	int currentIndex = -1;

	QuestionsIterator(TestQuestionsList questions) {
		this.questions = questions;
	}

	@Override
	public boolean hasNext() {
		if(currentIndex+1 < questions.size()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void moveToHead() {
		currentIndex = -1;
	}

	@Override
	public TestQuestion next() {
		if(hasNext()) {
			currentIndex++;
			return questions.get(currentIndex);
		}
		return null;
	}

	@Override
	public void remove() {
		questions.remove(currentIndex);
	}
	
}
