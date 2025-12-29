/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.controller;

import com.ijse.gearrent.dto.CustomerDto;
import com.ijse.gearrent.service.custom.CustomerService;
import com.ijse.gearrent.service.custom.impl.CustomerServiceImpl;
import com.ijse.gearrent.view.CustomerView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ishara
 */
public class CustomerController {

    private final CustomerView view;
    private final CustomerService customerService = new CustomerServiceImpl();

    public CustomerController() {
        this.view = new CustomerView();
        init();
        loadTable();
    }

    private void init() {

        view.btnAdd.addActionListener(e -> addCustomer());
        view.btnUpdate.addActionListener(e -> updateCustomer());
        view.btnClear.addActionListener(e -> clearFields());

        view.tblCustomers.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                loadSelectedRow();
            }
        });
    }

    private void loadTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) view.tblCustomers.getModel();
            model.setRowCount(0);

            for (CustomerDto c : customerService.getAllCustomers()) {
                model.addRow(new Object[]{
                        c.getCustomerId(),
                        c.getName(),
                        c.getNicPassport(),
                        c.getContact(),
                        c.getEmail(),
                        c.getAddress()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void addCustomer() {
        try {
            CustomerDto dto = new CustomerDto(
                    0,
                    view.txtName.getText(),
                    view.txtNIC.getText(),
                    view.txtContact.getText(),
                    view.txtEmail.getText(),
                    view.txtAddress.getText(),
                    1 
            );

            customerService.addCustomer(dto);
            JOptionPane.showMessageDialog(view, "Customer Added");
            loadTable();
            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void updateCustomer() {
        int row = view.tblCustomers.getSelectedRow();
        if (row == -1) return;

        try {
            int id = (int) view.tblCustomers.getValueAt(row, 0);

            CustomerDto dto = new CustomerDto(
                    id,
                    view.txtName.getText(),
                    view.txtNIC.getText(),
                    view.txtContact.getText(),
                    view.txtEmail.getText(),
                    view.txtAddress.getText(),
                    1
            );

            customerService.updateCustomer(dto);
            JOptionPane.showMessageDialog(view, "Customer Updated");
            loadTable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void loadSelectedRow() {
        int row = view.tblCustomers.getSelectedRow();
        if (row == -1) return;

        view.txtName.setText(view.tblCustomers.getValueAt(row, 1).toString());
        view.txtNIC.setText(view.tblCustomers.getValueAt(row, 2).toString());
        view.txtContact.setText(view.tblCustomers.getValueAt(row, 3).toString());
        view.txtEmail.setText(view.tblCustomers.getValueAt(row, 4).toString());
        view.txtAddress.setText(view.tblCustomers.getValueAt(row, 5).toString());
    }

    private void clearFields() {
        view.txtName.setText("");
        view.txtNIC.setText("");
        view.txtContact.setText("");
        view.txtEmail.setText("");
        view.txtAddress.setText("");
    }

    public void show() {
        view.setVisible(true);
    }
    
}
