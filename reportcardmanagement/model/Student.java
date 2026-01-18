package com.project.reportcardmanagement.model;

public class Student {
    private String studentId;
    private String studentName;
    private String dob;
    private String gender;
    private String email;
    private String className;

    // constructors, getters, setters
    public Student() {}

    public Student(String studentId, String studentName, String dob, String gender, String email, String className) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.className = className;
    }

    // getters / setters ...
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getStudentName() { return studentName; }
    public void setName(String studentName) { this.studentName = studentName; }
    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    }
    
