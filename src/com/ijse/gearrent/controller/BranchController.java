/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.controller;

import com.ijse.gearrent.view.BranchView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ishara
 */
public class BranchController {
  
    private final BranchView view;

    public BranchController() {
        this.view = new BranchView();
        init();
    }

    private void init() {

        view.btnAdd.addActionListener(e -> addBranch());
        view.btnClear.addActionListener(e -> clear());
    }

    private void addBranch() {

        DefaultTableModel model =
                (DefaultTableModel) view.tblBranch.getModel();

        model.addRow(new Object[]{
                model.getRowCount() + 1,
                view.txtName.getText()
        });

        JOptionPane.showMessageDialog(view, "Branch Added (Demo)");
        clear();
    }

    private void clear() {
        view.txtName.setText("");
    }

    public void show() {
        view.setVisible(true);
    }
}
