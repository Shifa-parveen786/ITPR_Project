package com.project.reportcardmanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.project.reportcardmanagement.model.Schedule;
import com.project.reportcardmanagement.service.ScheduleService;
import com.project.reportcardmanagement.service.impl.ScheduleServiceImpl;

public class ScheduleController {

    ScheduleService service = new ScheduleServiceImpl();
    Scanner sc = new Scanner(System.in);

    public void menu() throws Exception {

        System.out.println("---- SCHEDULE MANAGEMENT ----");
        System.out.println("1. Add Schedule");
        System.out.println("2. View Schedule by Exam");
        System.out.println("3. Back");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                addSchedule();
                break;
            case 2:
                viewSchedule();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid option");
        }
    }

    private void addSchedule() throws Exception {

        Schedule s = new Schedule();

        System.out.print("Exam Type: ");
        s.setExamType(sc.next());

        System.out.print("Subject Code: ");
        s.setSubjectCode(sc.next());

        System.out.print("Exam Date (YYYY-MM-DD): ");
        s.setExamDate(sc.next());
        
        sc.nextLine();

        System.out.print("Start Time: ");
        s.setStartTime(sc.nextLine());

        System.out.print("End Time: ");
        s.setEndTime(sc.nextLine());

        if (service.addSchedule(s))
            System.out.println("Schedule added successfully");
        else
            System.out.println("Failed to add schedule");
    }

    private void viewSchedule() throws Exception {

        System.out.print("Enter Exam Type: ");
        String examType = sc.next();

        List<Schedule> list = service.viewScheduleByExam(examType);

        for (Schedule s : list) {
            System.out.println(
                s.getSubjectCode() + " | " +
                s.getExamDate() + " | " +
                s.getStartTime() + " - " +
                s.getEndTime()
            );
        }
    }
}