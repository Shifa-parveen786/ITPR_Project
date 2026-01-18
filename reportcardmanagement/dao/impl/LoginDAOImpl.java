package com.project.reportcardmanagement.dao.impl;

import java.sql.*;
import com.project.reportcardmanagement.dao.LoginDAO;
import com.project.reportcardmanagement.util.DataBaseUtil;

public class LoginDAOImpl implements LoginDAO {

    public boolean validateLogin(String username, String password) {

        String sql = "SELECT * FROM login WHERE username=? AND password=?";

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}