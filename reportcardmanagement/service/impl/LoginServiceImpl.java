package com.project.reportcardmanagement.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.reportcardmanagement.service.LoginService;
import com.project.reportcardmanagement.util.DataBaseUtil;

public class LoginServiceImpl implements LoginService {

    @Override
    public boolean validateUser(String username, String password) {

        boolean valid = false;
        String sql = "SELECT * FROM login WHERE username=? AND password=?";

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            valid = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return valid;
    }
}