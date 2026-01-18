package com.project.reportcardmanagement.controller;

import java.util.Scanner;

import com.project.reportcardmanagement.model.Exam;
import com.project.reportcardmanagement.service.ExamService;
import com.project.reportcardmanagement.service.impl.ExamServiceImpl;

public class ExamController {

    ExamService examService = new ExamServiceImpl();
    Scanner sc = new Scanner(System.in);

    public void menu() {

        try {
            System.out.println("\n===== EXAM MANAGEMENT =====");
            System.out.println("1. Add Exam Details");
            System.out.println("2. Back");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:
                addExam();
                break;

            case 2:
                return;

            default:
                System.out.println("Invalid option!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addExam() throws Exception {

        Exam exam = new Exam();

        System.out.print("Enter Student ID: ");
        exam.setStudentId(sc.nextLine());

        System.out.print("Enter Exam Type (Mid/Final): ");
        exam.setExamType(sc.nextLine());

        System.out.print("Is Eligible (Yes/No): ");
        exam.setIsEligible(sc.nextLine());

        System.out.print("Enter Exam Date (YYYY-MM-DD): ");
        exam.setExamDate(sc.nextLine());

        if (examService.addExam(exam)) {
            System.out.println("Exam details added successfully!");
        } else {
            System.out.println("Failed to add exam details!");
        }
    }
}