/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.controller.util;

/**
 *
 * @author Ishara
 */
public class RoleValidator {
    public static boolean isAdmin(String role) {
        return "ADMIN".equalsIgnoreCase(role);
    }

    public static boolean isManager(String role) {
        return "MANAGER".equalsIgnoreCase(role);
    }

    public static boolean isStaff(String role) {
        return "STAFF".equalsIgnoreCase(role);
    }
}
