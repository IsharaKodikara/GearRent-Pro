/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.controller;

import com.ijse.gearrent.dto.EquipmentDto;
import com.ijse.gearrent.service.custom.EquipmentService;
import com.ijse.gearrent.service.custom.impl.EquipmentServiceImpl;
import com.ijse.gearrent.view.EquipmentView;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Ishara
 */
public class EquipmentController {

    private final EquipmentView view;
    private final EquipmentService service;

    // ✅ DEFAULT BRANCH (CW-2 DEMO PURPOSE)
    private final int branchId = 1;

    // ✅ NO-ARG CONSTRUCTOR (FIXES YOUR ERROR)
    public EquipmentController() {
        this.view = new EquipmentView();
        this.service = new EquipmentServiceImpl();

        loadCategoryIds();
        loadTable();
        init();
    }

    private void init() {

        view.btnAdd.addActionListener(e -> addEquipment());
        view.btnUpdate.addActionListener(e -> updateEquipment());
        view.btnClear.addActionListener(e -> clearFields());

        view.tblEquipment.getSelectionModel()
                .addListSelectionListener(e -> {
                    if (!e.getValueIsAdjusting()) {
                        loadSelectedRow();
                    }
                });
    }

    private void loadCategoryIds() {
        // TEMP static data (OK for CW-2)
        view.cmbCategoryId.addItem(1);
        view.cmbCategoryId.addItem(2);
        view.cmbCategoryId.addItem(3);
        view.cmbCategoryId.addItem(4);
        
        view.cmbBranchId.addItem(1);
        view.cmbBranchId.addItem(2);
        view.cmbBranchId.addItem(3);
    }

    private void loadTable() {
        try {
            List<EquipmentDto> list =
                    service.getAllEquipment();

            DefaultTableModel model =
                    (DefaultTableModel) view.tblEquipment.getModel();

            model.setRowCount(0);

            for (EquipmentDto e : list) {
                model.addRow(new Object[]{
                        e.getEquipmentId(),
                        e.getCategoryId(),
                        e.getBranchId(),
                        e.getBrand(),
                        e.getModel(),
                        e.getPurchaseYear(),
                        e.getBaseDailyPrice(),
                        e.getSecurityDeposit(),
                        e.getStatus()
                });
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }

    private void addEquipment() {
        try {
            EquipmentDto dto = new EquipmentDto(
                0,
                (int) view.cmbCategoryId.getSelectedItem(),
                (int) view.cmbBranchId.getSelectedItem(),
                view.txtBrand.getText(),
                view.txtModel.getText(),
                Integer.parseInt(view.txtPurchaseYear.getText()),
                Double.parseDouble(view.txtDailyPrice.getText()),
                Double.parseDouble(view.txtDeposit.getText()),
                view.cmbStatus.getSelectedItem().toString()
            );

            service.addEquipment(dto);
            JOptionPane.showMessageDialog(view, "Equipment Added");
            loadTable();
            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void updateEquipment() {
        int row = view.tblEquipment.getSelectedRow();
        if (row == -1) return;

        try {
            int id = (int) view.tblEquipment.getValueAt(row, 0);

            EquipmentDto dto = new EquipmentDto(
                    id,
                    (int) view.cmbCategoryId.getSelectedItem(),
                    (int) view.cmbBranchId.getSelectedItem(),
                    view.txtBrand.getText(),
                    view.txtModel.getText(),
                    Integer.parseInt(view.txtPurchaseYear.getText()),
                    Double.parseDouble(view.txtDailyPrice.getText()),
                    Double.parseDouble(view.txtDeposit.getText()),
                    view.cmbStatus.getSelectedItem().toString()
            );

            service.updateEquipment(dto);
            JOptionPane.showMessageDialog(view, "Equipment Updated");
            loadTable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void loadSelectedRow() {
        int row = view.tblEquipment.getSelectedRow();
        if (row == -1) return;

        view.cmbCategoryId.setSelectedItem(view.tblEquipment.getValueAt(row, 1));
        view.cmbBranchId.setSelectedItem(view.tblEquipment.getValueAt(row, 2));
        view.txtBrand.setText(view.tblEquipment.getValueAt(row, 3).toString());
        view.txtModel.setText(view.tblEquipment.getValueAt(row, 4).toString());
        view.txtPurchaseYear.setText(view.tblEquipment.getValueAt(row, 5).toString());
        view.txtDailyPrice.setText(view.tblEquipment.getValueAt(row, 6).toString());
        view.txtDeposit.setText(view.tblEquipment.getValueAt(row, 7).toString());
        view.cmbStatus.setSelectedItem(view.tblEquipment.getValueAt(row, 8).toString());
    }

    private void clearFields() {
        view.txtBrand.setText("");
        view.txtModel.setText("");
        view.cmbCategoryId.setSelectedIndex(0);
        view.cmbBranchId.setSelectedIndex(0);
        view.txtPurchaseYear.setText("");
        view.txtDailyPrice.setText("");
        view.txtDeposit.setText("");
        view.cmbStatus.setSelectedIndex(0);
    }

    public void show() {
        view.setVisible(true);
    }
}
