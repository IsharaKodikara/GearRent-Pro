/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.controller;

import com.ijse.gearrent.dto.EquipmentDto;
import com.ijse.gearrent.service.custom.EquipmentService;
import com.ijse.gearrent.service.custom.impl.EquipmentServiceImpl;
import com.ijse.gearrent.view.ReservationView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Ishara
 */
public class ReservationController {

    private final ReservationView view;
    private final EquipmentService equipmentService;

    // CW2 DEMO DEFAULT
    private final int branchId = 1;

    public ReservationController() {
        this.view = new ReservationView();
        this.equipmentService = new EquipmentServiceImpl();
        init();
    }

    private void init() {

        view.btnCheck.addActionListener(e -> loadAvailableEquipment());
        view.btnReserve.addActionListener(e -> reserve());
        view.btnClear.addActionListener(e -> clear());
    }

    private void loadAvailableEquipment() {
        try {
            LocalDate start = LocalDate.parse(view.txtStartDate.getText());
            LocalDate end = LocalDate.parse(view.txtEndDate.getText());

            List<EquipmentDto> list =
                    equipmentService.getAvailableEquipment(branchId, start, end);

            DefaultTableModel model =
                    (DefaultTableModel) view.tblEquipment.getModel();

            model.setRowCount(0);

            for (EquipmentDto e : list) {
                model.addRow(new Object[]{
                        e.getEquipmentId(),
                        e.getBrand(),
                        e.getModel(),
                        e.getBaseDailyPrice(),
                        e.getSecurityDeposit(),
                        e.getStatus()
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Invalid date input");
        }
    }

    private void reserve() {

        int row = view.tblEquipment.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Select equipment to reserve");
            return;
        }

        // CW2 – no DB save yet
        JOptionPane.showMessageDialog(
                view,
                "Equipment Reserved (Demo Only)",
                "Reservation",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void clear() {

        view.txtStartDate.setText("");
        view.txtEndDate.setText("");

        DefaultTableModel model =
                (DefaultTableModel) view.tblEquipment.getModel();
        model.setRowCount(0);
    }

    public void show() {
        view.setVisible(true);
    }
    
}
