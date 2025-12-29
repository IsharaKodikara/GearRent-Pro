/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.ijse.gearrent;

import com.ijse.gearrent.controller.LoginController;
import com.ijse.gearrent.view.LoginView;


/**
 *
 * @author Ishara
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          new LoginController(new LoginView()).show();
          //new DashboardController(new DashboardView()).show();
    }
    
}
