/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.controller;

import com.ijse.gearrent.view.ReturnView;
import javax.swing.JOptionPane;

/**
 *
 * @author Ishara
 */
public class ReturnController {
    private final ReturnView view = new ReturnView();

    public ReturnController() {
        view.btnReturn.addActionListener(e ->
            JOptionPane.showMessageDialog(view,"Return processed (Demo)")
        );
    }

    public void show() {
        view.setVisible(true);
    }
}
