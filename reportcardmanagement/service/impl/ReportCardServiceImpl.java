package com.project.reportcardmanagement.service.impl;

import java.util.Map;

import com.project.reportcardmanagement.dao.ReportCardDAO;
import com.project.reportcardmanagement.model.ReportCard;
import com.project.reportcardmanagement.model.Student;
import com.project.reportcardmanagement.service.ReportCardService;

public class ReportCardServiceImpl implements ReportCardService {

    private ReportCardDAO dao;

    // ✅ Constructor 
    public ReportCardServiceImpl(ReportCardDAO dao) {
        this.dao = dao;
    }

    // ================= GENERATE REPORT CARD =================
    @Override
    public ReportCard generateReportCard(String studentId) {

        // 1️⃣ Student details
        Student student = dao.getStudentById(studentId);
        if (student == null) {
            return null;
        }

        // 2️⃣ Marks
        Map<String, Integer> marksMap = dao.getMarksByStudent(studentId);

        int totalMarks = 0;
        for (int m : marksMap.values()) {
            totalMarks += m;
        }

        // 3️⃣ Marks Percentage
        double marksPercentage = 0;
        if (!marksMap.isEmpty()) {
            marksPercentage = (double) totalMarks / (marksMap.size() * 100) * 100;
        }

        // 4️⃣ Attendance Percentage
        int totalClasses = dao.getTotalClasses(studentId);
        int presentClasses = dao.getPresentCount(studentId);

        double attendancePercentage = 0;
        if (totalClasses > 0) {
            attendancePercentage = (double) presentClasses / totalClasses * 100;
        }

        // 5️⃣ Result logic
        String result;
        if (marksPercentage >= 40 && attendancePercentage >= 75) {
            result = "PASS";
        } else {
            result = "FAIL";
        }

        // 6️⃣ Create ReportCard object
        ReportCard reportCard = new ReportCard();
        reportCard.setStudentId(student.getStudentId());
        reportCard.setStudentName(student.getStudentName());
        reportCard.setClassName(student.getClassName());
        reportCard.setMarksMap(marksMap);
        reportCard.setMarksPercentage(marksPercentage);
        reportCard.setAttendancePercentage(attendancePercentage);
        reportCard.setResult(result);

        return reportCard;
    }
}