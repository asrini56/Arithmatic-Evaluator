package com.asu.ser.operations;

import com.asu.ser.model.TestQuestion;

public interface ListIterator {
	public boolean hasNext();
	public void moveToHead();
	public TestQuestion next();
	public void remove();
}
