/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.controller;

import com.ijse.gearrent.view.CategoryView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ishara
 */
public class CategoryController {
    
     private final CategoryView view;

    public CategoryController() {
        this.view = new CategoryView();
        init();
    }

    private void init() {

        view.btnAdd.addActionListener(e -> addCategory());
        view.btnClear.addActionListener(e -> clear());
    }

    private void addCategory() {

        DefaultTableModel model =
                (DefaultTableModel) view.tblCategory.getModel();

        model.addRow(new Object[]{
                model.getRowCount() + 1,
                view.txtName.getText()
        });

        JOptionPane.showMessageDialog(view, "Category Added (Demo)");
        clear();
    }

    private void clear() {
        view.txtName.setText("");
    }

    public void show() {
        view.setVisible(true);
    }
}
