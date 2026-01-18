package com.project.reportcardmanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.project.reportcardmanagement.model.Student;
import com.project.reportcardmanagement.service.StudentService;
import com.project.reportcardmanagement.service.impl.StudentServiceImpl;

public class StudentController {

    private Scanner sc = new Scanner(System.in);
    private StudentService studentService = new StudentServiceImpl();

    public void menu() {
        while (true) {
            System.out.println("\n---------- Student Management ----------");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Get Student By ID");
            System.out.println("5. List All Students");
            System.out.println("6. Back");
            System.out.print("Choose option: ");

            int opt = sc.nextInt();

            switch (opt) {
            case 1:
                addStudent();
                break;
            case 2:
                updateStudent();
                break;
            case 3:
                deleteStudent();
                break;
            case 4:
                getStudentById();
                break;
            case 5:
                listStudents();
                break;
            case 6:
                return; // go back
            default:
                System.out.println("Invalid Option! Try again.");
            }
        }
    }

    // -------------------- ADD STUDENT --------------------
    private void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.next();

        sc.nextLine(); // clear buffer
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter DOB (dd-mm-yyyy): ");
        String dob = sc.next();

        System.out.print("Enter Gender: ");
        String gender = sc.next();

        System.out.print("Enter Email: ");
        String email = sc.next();

        System.out.print("Enter Class: ");
        String className = sc.next();

        Student s = new Student(id, name, dob, gender, email, className);

        try {
            if (studentService.addStudent(s))
                System.out.println("✔ Student added successfully!");
            else
                System.out.println("✘ Failed to add student.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // -------------------- UPDATE STUDENT --------------------
    private void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = sc.next();

        sc.nextLine();
        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New DOB: ");
        String dob = sc.next();

        System.out.print("Enter New Gender: ");
        String gender = sc.next();

        System.out.print("Enter New Email: ");
        String email = sc.next();

        System.out.print("Enter New Class: ");
        String className = sc.next();

        Student s = new Student(id, name, dob, gender, email, className);

        try {
            if (studentService.updateStudent(s))
                System.out.println("✔ Student updated successfully!");
            else
                System.out.println("✘ Failed to update student.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // -------------------- DELETE STUDENT --------------------
    private void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = sc.next();

        try {
            if (studentService.deleteStudent(id))
                System.out.println("✔ Student deleted successfully!");
            else
                System.out.println("✘ Failed to delete student.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // -------------------- GET STUDENT BY ID --------------------
    private void getStudentById() {
        System.out.print("Enter Student ID: ");
        String id = sc.next();

        try {
            Student s = studentService.getStudentById(id);
            if (s != null) {
                System.out.println("\nStudent Details:");
                System.out.println("ID: " + s.getStudentId());
                System.out.println("Name: " + s.getStudentName());
                System.out.println("DOB: " + s.getDob());
                System.out.println("Gender: " + s.getGender());
                System.out.println("Email: " + s.getEmail());
                System.out.println("Class: " + s.getClassName());
            } else {
                System.out.println("✘ Student not found!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // -------------------- LIST ALL STUDENTS --------------------
    private void listStudents() {
        try {
            List<Student> students = studentService.getAllStudents();

            if (students.isEmpty()) {
                System.out.println("No students found!");
                return;
            }

            // TABLE HEADER
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.printf("%-10s %-15s %-12s %-10s %-25s %-10s\n",
                    "ID", "Name", "DOB", "Gender", "Email", "Class");
            System.out.println("--------------------------------------------------------------------------------------------");

            // TABLE ROWS
            for (Student s : students) {
                System.out.printf("%-10s %-15s %-12s %-10s %-25s %-10s\n",
                        s.getStudentId(),
                        s.getStudentName(),
                        s.getDob(),
                        s.getGender(),
                        s.getEmail(),
                        s.getClassName()
                );
            }

            System.out.println("--------------------------------------------------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Error: Unable to fetch students.");
        }
    }
}