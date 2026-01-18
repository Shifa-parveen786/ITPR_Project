package com.project.reportcardmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.project.reportcardmanagement.dao.ReportCardDAO;
import com.project.reportcardmanagement.model.Student;
import com.project.reportcardmanagement.util.DataBaseUtil;

public class ReportCardDAOImpl implements ReportCardDAO {

    // ================== STUDENT ==================
    @Override
    public Student getStudentById(String studentId) {

        Student student = null;
        String sql = "SELECT * FROM student WHERE student_id = ?";

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studentId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setStudentId(rs.getString("student_id"));
                student.setName(rs.getString("student_name"));
                student.setClassName(rs.getString("class"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    // ================== MARKS ==================
    @Override
    public Map<String, Integer> getMarksByStudent(String studentId) {

        Map<String, Integer> marksMap = new HashMap<>();

        String sql =
                "SELECT s.subject_name, m.marks " +
                "FROM marks m " +
                "JOIN subject s ON m.subject_code = s.subject_code " +
                "WHERE m.student_id = ?";

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                marksMap.put(
                        rs.getString("subject_name"),
                        rs.getInt("marks")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return marksMap;
    }

    // ================== ATTENDANCE COUNT ==================
    @Override
    public int getTotalClasses(String studentId) {

        int total = 0;
        String sql = "SELECT COUNT(*) FROM attendance WHERE student_id = ?";

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studentId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public int getPresentCount(String studentId) {

        int present = 0;
        String sql =
                "SELECT COUNT(*) FROM attendance " +
                "WHERE student_id = ? AND status = 'P'";

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studentId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                present = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return present;
    }
}