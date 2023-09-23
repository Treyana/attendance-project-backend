package com.tumdy.attendance.domain;

import java.util.List;

public class Attendancev1 {
	private long classId;
	private long subjectId;
	private String date;
	private List<String> permissions;
	public Attendancev1() {
		super();
	}
	public Attendancev1(long classIdd, long subjectId, String date, List<String> permissions) {
		super();
		this.classId = classIdd;
		this.subjectId = subjectId;
		this.date = date;
		this.permissions = permissions;
	}
	public long getClassId() {
		return classId;
	}
	public void setClassId(long classIdd) {
		this.classId = classIdd;
	}
	public long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
	
}
