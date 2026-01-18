package com.project.reportcardmanagement.dao.impl;

import java.sql.*;
import java.util.*;
import com.project.reportcardmanagement.dao.AttendanceDAO;
import com.project.reportcardmanagement.model.Attendance;
import com.project.reportcardmanagement.util.DataBaseUtil;

public class AttendanceDAOImpl implements AttendanceDAO {

    @Override
    public boolean addAttendance(Attendance a) throws Exception {

        String sql = "INSERT INTO attendance(student_id, attendance_date, status, remarks) VALUES (?,?,?,?)";
        Connection con = DataBaseUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, a.getStudentId());
        ps.setString(2, a.getAttendanceDate());
        ps.setString(3, a.getStatus());
        ps.setString(4, a.getRemarks());

        return ps.executeUpdate() > 0;
    }

    @Override
    public List<Attendance> getAttendanceByStudent(String studentId) throws Exception {

        List<Attendance> list = new ArrayList<>();
        String sql = "SELECT * FROM attendance WHERE student_id=?";
        Connection con = DataBaseUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, studentId);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Attendance a = new Attendance();
            a.setStudentId(rs.getString("student_id"));
            a.setAttendanceDate(rs.getString("attendance_date"));
            a.setStatus(rs.getString("status"));
            a.setRemarks(rs.getString("remarks"));
            list.add(a);
        }
        return list;
    }

    @Override
    public int getTotalDays(String studentId) throws Exception {

        String sql = "SELECT COUNT(*) FROM attendance WHERE student_id=?";
        Connection con = DataBaseUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, studentId);

        ResultSet rs = ps.executeQuery();
        if (rs.next())
            return rs.getInt(1);

        return 0;
    }

    @Override
    public int getPresentDays(String studentId) throws Exception {

        String sql = "SELECT COUNT(*) FROM attendance WHERE student_id=? AND status='Present'";
        Connection con = DataBaseUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, studentId);

        ResultSet rs = ps.executeQuery();
        if (rs.next())
            return rs.getInt(1);

        return 0;
    }
}