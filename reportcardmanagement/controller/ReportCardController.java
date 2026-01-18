package com.project.reportcardmanagement.controller;

import java.util.Map;
import java.util.Scanner;

import com.project.reportcardmanagement.dao.ReportCardDAO;
import com.project.reportcardmanagement.dao.impl.ReportCardDAOImpl;
import com.project.reportcardmanagement.model.ReportCard;
import com.project.reportcardmanagement.service.ReportCardService;
import com.project.reportcardmanagement.service.impl.ReportCardServiceImpl;

public class ReportCardController {

    private ReportCardService reportCardService;
    private Scanner sc = new Scanner(System.in);

    // ✅ Constructor
    public ReportCardController() {
        ReportCardDAO dao = new ReportCardDAOImpl();
        this.reportCardService = new ReportCardServiceImpl(dao);
    }

    // ✅ Method called from App.java (case 7)
    public void generateReportCard() {

        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();

        ReportCard reportCard = reportCardService.generateReportCard(studentId);

        if (reportCard == null) {
            System.out.println("Report Card cannot be generated!");
            return;
        }

        System.out.println("\n========== REPORT CARD ==========");
        System.out.println("Student ID   : " + reportCard.getStudentId());
        System.out.println("Student Name : " + reportCard.getStudentName());
        System.out.println("Class        : " + reportCard.getClassName());

        System.out.println("\n------ Subject Marks ------");
        for (Map.Entry<String, Integer> entry : reportCard.getMarksMap().entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.printf("\nMarks Percentage      : %.2f%%\n",
                reportCard.getMarksPercentage());
        System.out.printf("Attendance Percentage : %.2f%%\n",
                reportCard.getAttendancePercentage());

        System.out.println("Result                : " + reportCard.getResult());
        System.out.println("================================\n");
    }
}