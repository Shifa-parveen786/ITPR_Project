package com.project.reportcardmanagement.model;

import java.util.Map;

public class ReportCard {

    private String studentId;
    private String studentName;
    private String className;

    private Map<String, Integer> marksMap;
    private int totalMarks;
    private double marksPercentage;
    private double attendancePercentage;
    private String result;

    // ===== getters & setters =====

    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }

    public Map<String, Integer> getMarksMap() {
        return marksMap;
    }
    public void setMarksMap(Map<String, Integer> marksMap) {
        this.marksMap = marksMap;
    }

    public int getTotalMarks() {
        return totalMarks;
    }
    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public double getMarksPercentage() {
        return marksPercentage;
    }
    public void setMarksPercentage(double marksPercentage) {
        this.marksPercentage = marksPercentage;
    }

    public double getAttendancePercentage() {
        return attendancePercentage;
    }
    public void setAttendancePercentage(double attendancePercentage) {
        this.attendancePercentage = attendancePercentage;
    }

    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}