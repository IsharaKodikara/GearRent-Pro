/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.controller;

import com.ijse.gearrent.dto.UserDto;
import com.ijse.gearrent.service.custom.AuthService;
import com.ijse.gearrent.service.custom.impl.AuthServiceImpl;
import com.ijse.gearrent.view.DashboardView;
import com.ijse.gearrent.view.LoginView;

import javax.swing.*;

/**
 *
 * @author Ishara
 */
public class LoginController {
     private final LoginView view;
    private final AuthService authService = new AuthServiceImpl();

    public LoginController(LoginView view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.btnLogin.addActionListener(e -> login());
    }

    private void login() {
        try {
            String username = view.txtUsername.getText();
            String password = new String(view.txtPassword.getPassword());

            UserDto user = authService.login(username, password);

            if (user == null) {
                JOptionPane.showMessageDialog(view, "Invalid Credentials");
                return;
            }

            JOptionPane.showMessageDialog(view, "Welcome " + user.getRole());

            view.dispose();
            DashboardView dashboardView = new DashboardView();
            new DashboardController(dashboardView, user.getRole()).show();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }

    public void show() {
        view.setVisible(true);
    }
}
