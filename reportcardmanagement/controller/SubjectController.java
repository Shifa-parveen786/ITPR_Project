package com.project.reportcardmanagement.controller;

import java.util.List;
import java.util.Scanner;
import com.project.reportcardmanagement.model.Subject;
import com.project.reportcardmanagement.service.SubjectService;
import com.project.reportcardmanagement.service.impl.SubjectServiceImpl;

public class SubjectController {

    private Scanner sc = new Scanner(System.in);
    private SubjectService service = new SubjectServiceImpl();

    public void menu() {
        while (true) {
            System.out.println("\n--- Subject Management ---");
            System.out.println("1. Add Subject");
            System.out.println("2. Update Subject");
            System.out.println("3. Delete Subject");
            System.out.println("4. Get Subject By Code");
            System.out.println("5. List All Subjects");
            System.out.println("0. Back");

            System.out.print("Choose option: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1: addSubject(); break;
                case 2: updateSubject(); break;
                case 3: deleteSubject(); break;
                case 4: getSubjectByCode(); break;
                case 5: listAllSubjects(); break;
                case 0: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void addSubject() {
        System.out.print("Enter Subject Code: ");
        String code = sc.nextLine();

        System.out.print("Enter Subject Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Max Marks: ");
        int max = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Min Marks: ");
        int min = sc.nextInt();
        sc.nextLine();

        try {
            Subject s = new Subject(code, name, max, min);
            if (service.addSubject(s))
                System.out.println("✓ Subject added successfully!");
            else
                System.out.println("✗ Failed to add subject!");
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void updateSubject() {
        System.out.print("Enter Subject Code to update: ");
        String code = sc.nextLine();

        try {
            Subject s = service.getSubjectByCode(code);
            if (s == null) {
                System.out.println("✗ Subject not found!");
                return;
            }

            System.out.print("Enter New Name: ");
            s.setSubjectName(sc.nextLine());

            System.out.print("Enter New Max Marks: ");
            s.setMaxMarks(sc.nextInt());
            sc.nextLine();

            System.out.print("Enter New Min Marks: ");
            s.setMinMarks(sc.nextInt());
            sc.nextLine();

            if (service.updateSubject(s))
                System.out.println("✓ Updated successfully!");
            else
                System.out.println("✗ Failed to update!");
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void deleteSubject() {
        System.out.print("Enter Subject Code to delete: ");
        String code = sc.nextLine();

        try {
            if (service.deleteSubject(code))
                System.out.println("✓ Deleted successfully!");
            else
                System.out.println("✗ Failed to delete subject!");
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void getSubjectByCode() {
        System.out.print("Enter Subject Code: ");
        String code = sc.nextLine();

        try {
            Subject s = service.getSubjectByCode(code);
            if (s == null) {
                System.out.println("✗ Subject not found!");
                return;
            }

            System.out.println("\n--- Subject Details ---");
            System.out.println("Code      : " + s.getSubjectCode());
            System.out.println("Name      : " + s.getSubjectName());
            System.out.println("Max Marks : " + s.getMaxMarks());
            System.out.println("Min Marks : " + s.getMinMarks());

        } catch (Exception e) { e.printStackTrace(); }
    }

    private void listAllSubjects() {
        try {
            List<Subject> list = service.getAllSubjects();

            System.out.println("\n--- All Subjects ---");
            System.out.printf("%-15s %-25s %-12s %-12s\n", 
                "Code", "Name", "Max Marks", "Min Marks");

            for (Subject s : list) {
                System.out.printf("%-15s %-25s %-12d %-12d\n",
                    s.getSubjectCode(), s.getSubjectName(),
                    s.getMaxMarks(), s.getMinMarks());
            }

        } catch (Exception e) { e.printStackTrace(); }
    }
}