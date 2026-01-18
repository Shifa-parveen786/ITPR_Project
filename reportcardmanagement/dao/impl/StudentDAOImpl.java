package com.project.reportcardmanagement.dao.impl;

import com.project.reportcardmanagement.dao.StudentDAO;
import com.project.reportcardmanagement.model.Student;
import com.project.reportcardmanagement.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*---------------------------------------------------
 * ------- Structure Of the Student ---------
 * table : student
 * --------------------------------------
 * fields - datatype - 
 * studentid - varchar(30) - primary key
 * studentname - varchar(100) - null 
 * dob - varchar(20) -  null
 * gender - varchar(10) - null
 * email - varchar(100) - null 
 * class - varchar(20)  - null
 * */


public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean addStudent(Student s) throws Exception {
        String sql = "INSERT INTO student(student_id, student_name, dob, gender, email, class) VALUES (?,?,?,?,?,?)";

        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getStudentId());
            ps.setString(2, s.getStudentName());
            ps.setString(3, s.getDob());
            ps.setString(4, s.getGender());
            ps.setString(5, s.getEmail());
            ps.setString(6, s.getClassName());

            return ps.executeUpdate() > 0;
        }
    }

    // ---------------- UPDATE ----------------
    @Override
    public boolean updateStudent(Student s) throws Exception {
        String sql = "UPDATE student SET student_name=?, dob=?, gender=?, email=?, class=? WHERE student_id=?";

        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getStudentName());
            ps.setString(2, s.getDob());
            ps.setString(3, s.getGender());
            ps.setString(4, s.getEmail());
            ps.setString(5, s.getClassName());
            ps.setString(6, s.getStudentId());

            return ps.executeUpdate() > 0;
        }
    }

    // ---------------- DELETE ----------------
    @Override
    public boolean deleteStudent(String studentId) throws Exception {
        String sql = "DELETE FROM student WHERE student_id=?";

        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, studentId);
            return ps.executeUpdate() > 0;
        }
    }

    // ---------------- GET BY ID ----------------
    @Override
    public Student getStudentById(String studentId) throws Exception {
        String sql = "SELECT * FROM student WHERE student_id=?";

        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getString("student_id"));
                s.setName(rs.getString("student_name"));
                s.setDob(rs.getString("dob"));
                s.setGender(rs.getString("gender"));
                s.setEmail(rs.getString("email"));
                s.setClassName(rs.getString("class"));
                return s;
            }
        }
        return null;
    }

    // ---------------- GET ALL ----------------
    @Override
    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();

        String sql = "SELECT * FROM student";

        try (Connection conn = DataBaseUtil.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getString("student_id"));
                s.setName(rs.getString("student_name"));
                s.setDob(rs.getString("dob"));
                s.setGender(rs.getString("gender"));
                s.setEmail(rs.getString("email"));
                s.setClassName(rs.getString("class"));

                list.add(s);
            }
        }
        return list;
    }
}