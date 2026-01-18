package com.project.reportcardmanagement.dao;

public interface LoginDAO {
    boolean validateLogin(String username, String password);
}