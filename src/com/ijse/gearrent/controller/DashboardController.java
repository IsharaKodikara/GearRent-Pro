/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.controller;

import com.ijse.gearrent.controller.util.RoleValidator;
import com.ijse.gearrent.view.DashboardView;

/**
 *
 * @author Ishara
 */
public class DashboardController {
   private final DashboardView view;
    private final String role;

    public DashboardController(DashboardView view, String role) {
        this.view = view;
        this.role = role;
        init();
        applyRolePermissions();
    }

    private void init() {

        view.btnCustomers.addActionListener(e ->
                new CustomerController().show()
        );

        view.btnEquipment.addActionListener(e ->
                new EquipmentController().show()
        );

        view.btnRental.addActionListener(e ->
                new RentalController().show()
        );

        view.btnReservation.addActionListener(e ->
                new ReservationController().show()
        );

        view.btnBranch.addActionListener(e ->
                new BranchController().show()
        );

        view.btnCategory.addActionListener(e ->
                new CategoryController().show()
        );

        view.btnReturns.addActionListener(e ->
                new ReturnController().show()
        );

        view.btnOverdue.addActionListener(e ->
                new OverdueController().show()
        );
    }

    private void applyRolePermissions() {

        // ADMIN ONLY FEATURES
        if (!RoleValidator.isAdmin(role)) {
            view.btnBranch.setEnabled(false);
            view.btnCategory.setEnabled(false);
        }

        // STAFF RESTRICTIONS
        if (RoleValidator.isStaff(role)) {
            view.btnBranch.setEnabled(false);
            view.btnCategory.setEnabled(false);
        }
    }

    public void show() {
        view.setVisible(true);
    }
}
