package com.project.reportcardmanagement.dao.impl;

import java.sql.*;
import java.util.*;

import com.project.reportcardmanagement.dao.MarksDAO;
import com.project.reportcardmanagement.model.Marks;
import com.project.reportcardmanagement.util.DataBaseUtil;

public class MarksDAOImpl implements MarksDAO {

    @Override
    public boolean addMarks(Marks m) throws Exception {
        String sql = "INSERT INTO marks(student_id, subject_code, marks) VALUES (?, ?, ?)";
        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, m.getStudentId());
            ps.setString(2, m.getSubjectCode());
            ps.setInt(3, m.getMarks());

            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean updateMarks(Marks m) throws Exception {
        String sql = "UPDATE marks SET marks=? WHERE student_id=? AND subject_code=?";
        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, m.getMarks());
            ps.setString(2, m.getStudentId());
            ps.setString(3, m.getSubjectCode());

            return ps.executeUpdate() > 0;
        }
    }
    
    @Override
    public boolean deleteMarks(String studentId, String subjectCode) throws Exception {
        String sql = "DELETE FROM marks WHERE student_id=? AND subject_code=?";
        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studentId);
            ps.setString(2, subjectCode);

            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public List<Marks> getMarksByStudent(String studentId) throws Exception {
        List<Marks> list = new ArrayList<>();

        String sql = "SELECT * FROM marks WHERE student_id=?";
        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Marks m = new Marks();
                m.setStudentId(rs.getString("student_id"));
                m.setSubjectCode(rs.getString("subject_code"));
                m.setMarks(rs.getInt("marks"));
                list.add(m);
            }
        }
        return list;
    }

    @Override
    public List<Marks> getAllMarks() throws Exception {
        List<Marks> list = new ArrayList<>();

        String sql = "SELECT * FROM marks";
        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Marks m = new Marks();
                m.setStudentId(rs.getString("student_id"));
                m.setSubjectCode(rs.getString("subject_code"));
                m.setMarks(rs.getInt("marks"));
                list.add(m);
            }
        }
        return list;
    }
}