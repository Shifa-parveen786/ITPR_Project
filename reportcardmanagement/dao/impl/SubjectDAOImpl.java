package com.project.reportcardmanagement.dao.impl;

import java.sql.*;
import java.util.*;
import com.project.reportcardmanagement.dao.SubjectDAO;
import com.project.reportcardmanagement.model.Subject;
import com.project.reportcardmanagement.util.DataBaseUtil;

/*---------------------------------------------------
 * ------- Structure Of the Subject ---------
 * table : subject
 * --------------------------------------
 * fields - datatype - 
 * subject_code - varchar(30) - primary key
 * subject_name - varchar(200) - not null 
 * max_marks -    int -          not null
 * min_marks -    int -          not null
 * */

public class SubjectDAOImpl implements SubjectDAO {

    @Override
    public boolean addSubject(Subject s) throws Exception {
        String sql = "INSERT INTO subject(subject_code, subject_name, max_marks, min_marks) VALUES (?,?,?,?)";

        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getSubjectCode());
            ps.setString(2, s.getSubjectName());
            ps.setInt(3, s.getMaxMarks());
            ps.setInt(4, s.getMinMarks());

            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean updateSubject(Subject s) throws Exception {
        String sql = "UPDATE subject SET subject_name=?, max_marks=?, min_marks=? WHERE subject_code=?";

        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getSubjectName());
            ps.setInt(2, s.getMaxMarks());
            ps.setInt(3, s.getMinMarks());
            ps.setString(4, s.getSubjectCode());

            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteSubject(String subjectCode) throws Exception {
        String sql = "DELETE FROM subject WHERE subject_code=?";

        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, subjectCode);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Subject getSubjectByCode(String subjectCode) throws Exception {

        String sql = "SELECT * FROM subject WHERE subject_code=?";

        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, subjectCode);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Subject s = new Subject();
                s.setSubjectCode(rs.getString("subject_code"));
                s.setSubjectName(rs.getString("subject_name"));
                s.setMaxMarks(rs.getInt("max_marks"));
                s.setMinMarks(rs.getInt("min_marks"));
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Subject> getAllSubjects() throws Exception {
        List<Subject> list = new ArrayList<>();

        String sql = "SELECT * FROM subject";

        try (Connection conn = DataBaseUtil.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Subject s = new Subject();
                s.setSubjectCode(rs.getString("subject_code"));
                s.setSubjectName(rs.getString("subject_name"));
                s.setMaxMarks(rs.getInt("max_marks"));
                s.setMinMarks(rs.getInt("min_marks"));
                list.add(s);
            }
        }
        return list;
    }
}