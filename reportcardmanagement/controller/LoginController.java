package com.project.reportcardmanagement.controller;

import java.util.Scanner;

import com.project.reportcardmanagement.service.LoginService;
import com.project.reportcardmanagement.service.impl.LoginServiceImpl;

public class LoginController {

    private LoginService service = new LoginServiceImpl();
    private Scanner sc = new Scanner(System.in);

    public boolean login() {

        System.out.println("========== LOGIN ==========");
        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        boolean status = service.validateUser(username, password);

        if (status) {
            System.out.println("Login Successful ✅");
        } else {
            System.out.println("Invalid Username or Password ❌");
        }

        return status;
    }
}