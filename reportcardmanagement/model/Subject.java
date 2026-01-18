package com.project.reportcardmanagement.model;

public class Subject {
    private String subjectCode;
    private String subjectName;
    private int maxMarks;
    private int minMarks;

    public Subject() {}

    public Subject(String subjectCode, String subjectName, int maxMarks, int minMarks) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.maxMarks = maxMarks;
        this.minMarks = minMarks;
    }

    public String getSubjectCode() { return subjectCode; }
    public void setSubjectCode(String subjectCode) { this.subjectCode = subjectCode; }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

    public int getMaxMarks() { return maxMarks; }
    public void setMaxMarks(int maxMarks) { this.maxMarks = maxMarks; }

    public int getMinMarks() { return minMarks; }
    public void setMinMarks(int minMarks) { this.minMarks = minMarks; }
}