/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.controller;

import com.ijse.gearrent.dto.EquipmentDto;
import com.ijse.gearrent.service.custom.EquipmentService;
import com.ijse.gearrent.service.custom.impl.EquipmentServiceImpl;
import com.ijse.gearrent.view.EquipmentView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author Ishara
 */
public class EquipmentController {

    private final EquipmentView view;
    private final EquipmentService service;

    private final int branchId = 1;

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
        view.cmbCategoryId.addItem(1);
        view.cmbCategoryId.addItem(2);
        view.cmbCategoryId.addItem(3);
    }

    private void loadTable() {
        try {
            List<EquipmentDto> list =
                    service.getEquipmentByBranch(branchId);

            DefaultTableModel model =
                    (DefaultTableModel) view.tblEquipment.getModel();

            model.setRowCount(0);

            for (EquipmentDto e : list) {
                model.addRow(new Object[]{
                        e.getEquipmentId(),
                        e.getCategoryId(),
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
                    branchId,
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
                    branchId,
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
        view.txtBrand.setText(view.tblEquipment.getValueAt(row, 2).toString());
        view.txtModel.setText(view.tblEquipment.getValueAt(row, 3).toString());
        view.txtPurchaseYear.setText(view.tblEquipment.getValueAt(row, 4).toString());
        view.txtDailyPrice.setText(view.tblEquipment.getValueAt(row, 5).toString());
        view.txtDeposit.setText(view.tblEquipment.getValueAt(row, 6).toString());
        view.cmbStatus.setSelectedItem(view.tblEquipment.getValueAt(row, 7).toString());
    }

    private void clearFields() {
        view.txtBrand.setText("");
        view.txtModel.setText("");
        view.txtPurchaseYear.setText("");
        view.txtDailyPrice.setText("");
        view.txtDeposit.setText("");
        view.cmbStatus.setSelectedIndex(0);
    }

    public void show() {
        view.setVisible(true);
    }
}
