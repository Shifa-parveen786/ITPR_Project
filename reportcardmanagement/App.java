package com.project.reportcardmanagement;

import java.util.Scanner;

import com.project.reportcardmanagement.controller.AttendanceController;
import com.project.reportcardmanagement.controller.ExamController;
import com.project.reportcardmanagement.controller.LoginController;
import com.project.reportcardmanagement.controller.MarksController;
import com.project.reportcardmanagement.controller.ReportCardController;
import com.project.reportcardmanagement.controller.ScheduleController;
import com.project.reportcardmanagement.controller.StudentController;
import com.project.reportcardmanagement.controller.SubjectController;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Controllers
        LoginController loginController = new LoginController();
        StudentController studentController = new StudentController();
        SubjectController subjectController = new SubjectController();
        AttendanceController attendanceController = new AttendanceController();
        ExamController examController = new ExamController();
        ScheduleController scheduleController = new ScheduleController();
        MarksController marksController = new MarksController();
        ReportCardController reportCardController = new ReportCardController();

        try {

            // ===== LOGIN =====
            if (!loginController.login()) {
                System.out.println("Login Failed! Program Terminated.");
                return;
            }

            int choice;

            do {
                System.out.println("\n========= REPORT CARD MANAGEMENT SYSTEM =========");
                System.out.println("1. Student Management");
                System.out.println("2. Subject Management");
                System.out.println("3. Attendance Management");
                System.out.println("4. Exam Management");
                System.out.println("5. Schedule Management");
                System.out.println("6. Marks Management");
                System.out.println("7. Generate Report Card");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        studentController.menu();
                        break;

                    case 2:
                        subjectController.menu();
                        break;

                    case 3:
                        attendanceController.menu();
                        break;

                    case 4:
                        examController.menu();
                        break;

                    case 5:
                        scheduleController.menu();
                        break;

                    case 6:
                        marksController.menu();
                        break;

                    case 7:
                        reportCardController.generateReportCard();
                        break;

                    case 8:
                        System.out.println("Thank you for using the system.");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } while (choice != 8);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}