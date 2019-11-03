package com.asu.ser.usermanagement;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Grade {
	GRADE_ONE(1, "Grade-1"),
	GRADE_SIX(6, "Grade-2"),
	GRADE_NINE(9, "Grade-3");

	private int grade;
	private String desc;
	private static final Map<Integer, String> LOOKUP = new HashMap<Integer, String>();

	static {
		for (Grade grade : EnumSet.allOf(Grade.class)) {
			LOOKUP.put(grade.getGrade(), grade.getDesc());
		}
	}

	Grade(int grade, String desc) {
		this.grade = grade;
		this.desc = desc;
	}

	public static String get(int id) {
		return LOOKUP.get(id);
	}

	public int getGrade() {
		return grade;
	}

	public String getDesc() {
		return desc;
	}
	

}
