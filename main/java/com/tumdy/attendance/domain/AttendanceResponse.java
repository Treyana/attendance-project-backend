package com.tumdy.attendance.domain;

public class AttendanceResponse {
	private String className;
	private String studentName;
	private String subjectName;
	
	public AttendanceResponse(String className, String studentName, String subjectName) {
		this.className = className;
		this.studentName = studentName;
		this.subjectName = subjectName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	
}
