package com.project.reportcardmanagement.service.impl;

import java.util.List;
import com.project.reportcardmanagement.dao.*;
import com.project.reportcardmanagement.dao.impl.*;
import com.project.reportcardmanagement.model.Student;
import com.project.reportcardmanagement.service.*;

public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public boolean addStudent(Student s) throws Exception {
        return studentDAO.addStudent(s);
    }

    @Override
    public boolean updateStudent(Student s) throws Exception {
        return studentDAO.updateStudent(s);
    }

    @Override
    public boolean deleteStudent(String studentId) throws Exception {
        return studentDAO.deleteStudent(studentId);
    }

    @Override
    public Student getStudentById(String studentId) throws Exception {
        return studentDAO.getStudentById(studentId);
    }

    @Override
    public List<Student> getAllStudents() throws Exception {
        return studentDAO.getAllStudents();
    }

}