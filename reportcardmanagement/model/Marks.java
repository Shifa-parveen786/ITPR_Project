package com.project.reportcardmanagement.model;

public class Marks {

    private String studentId;
    private String subjectCode;
    private String subjectName;
    private int marks;
    private int maxMarks;
    private int minMarks;

    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }
	public String getSubjectName() {
		return subjectName;
		
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getMaxMarks() {
		return maxMarks;
		
	}
	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}
	public int getMinMarks() {
		return minMarks;
		
	}
	public void setMinMarks(int minMarks) {
		this.minMarks = minMarks;
	}
}