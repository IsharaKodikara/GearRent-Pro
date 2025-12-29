/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.controller;

import com.ijse.gearrent.dto.EquipmentDto;
import com.ijse.gearrent.service.custom.EquipmentService;
import com.ijse.gearrent.service.custom.impl.EquipmentServiceImpl;
import com.ijse.gearrent.view.RentalView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 *
 * @author Ishara
 */
public class RentalController {

    private final RentalView view;
    private final EquipmentService equipmentService;

    // CW2 DEMO DEFAULT
    private final int branchId = 1;

    public RentalController() {
        this.view = new RentalView();
        this.equipmentService = new EquipmentServiceImpl();
        init();
    }

    private void init() {

        view.btnCheck.addActionListener(e -> loadAvailableEquipment());
        view.btnCalculate.addActionListener(e -> calculateTotal());
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

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Invalid dates or data");
        }
    }

    private void calculateTotal() {

        int row = view.tblEquipment.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Select equipment");
            return;
        }

        try {
            LocalDate start = LocalDate.parse(view.txtStartDate.getText());
            LocalDate end = LocalDate.parse(view.txtEndDate.getText());

            long days = ChronoUnit.DAYS.between(start, end) + 1;

            double dailyPrice =
                    Double.parseDouble(view.tblEquipment.getValueAt(row, 3).toString());

            double deposit =
                    Double.parseDouble(view.tblEquipment.getValueAt(row, 4).toString());

            double total = (days * dailyPrice) + deposit;

            view.txtDays.setText(String.valueOf(days));
            view.txtTotal.setText(String.valueOf(total));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Calculation error");
        }
    }

    private void clear() {
        view.txtStartDate.setText("");
        view.txtEndDate.setText("");
        view.txtDays.setText("");
        view.txtTotal.setText("");

        DefaultTableModel model =
                (DefaultTableModel) view.tblEquipment.getModel();
        model.setRowCount(0);
    }

    public void show() {
        view.setVisible(true);
    }
    
}
