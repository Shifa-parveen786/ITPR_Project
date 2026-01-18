package com.project.reportcardmanagement.dao;

import java.util.Map;

import com.project.reportcardmanagement.model.Student;

public interface ReportCardDAO {

    // ================= STUDENT =================
    Student getStudentById(String studentId);

    // ================= MARKS =================
    // key   -> subject_name
    // value -> marks
    Map<String, Integer> getMarksByStudent(String studentId);

    // ================= ATTENDANCE =================
    int getTotalClasses(String studentId);

    int getPresentCount(String studentId);
}