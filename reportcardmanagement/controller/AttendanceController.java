package com.project.reportcardmanagement.controller;

import java.util.*;
import com.project.reportcardmanagement.model.Attendance;
import com.project.reportcardmanagement.service.AttendanceService;
import com.project.reportcardmanagement.service.impl.AttendanceServiceImpl;

public class AttendanceController {

    AttendanceService service = new AttendanceServiceImpl();
    Scanner sc = new Scanner(System.in);

    public void menu() throws Exception {

        while (true) {
            System.out.println("\n--- ATTENDANCE MANAGEMENT ---");
            System.out.println("1. Mark Attendance");
            System.out.println("2. View Attendance by Student");
            System.out.println("3. Back");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    markAttendance();
                    break;
                case 2:
                    viewAttendance();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void markAttendance() throws Exception {

        Attendance a = new Attendance();

        System.out.print("Enter Student ID: ");
        a.setStudentId(sc.nextLine());

        System.out.print("Enter Date (YYYY-MM-DD): ");
        a.setAttendanceDate(sc.nextLine());

        System.out.print("Status (P/A): ");
        a.setStatus(sc.nextLine());

        System.out.print("Remarks: ");
        a.setRemarks(sc.nextLine());

        if (service.addAttendance(a))
            System.out.println("Attendance marked successfully!");
        else
            System.out.println("Failed!");
    }

    private void viewAttendance() throws Exception {

        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();

        List<Attendance> list = service.getAttendanceByStudent(studentId);

        if (list.isEmpty()) {
            System.out.println("No attendance records found!");
            return;
        }

        System.out.println("\nDate        | Status   | Remarks");
        System.out.println("---------------------------------");

        for (Attendance a : list) {
            System.out.printf("%-12s %-9s %s\n",
                    a.getAttendanceDate(),
                    a.getStatus(),
                    a.getRemarks());
        }
    }
}