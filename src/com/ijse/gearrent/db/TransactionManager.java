/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.db;

import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Ishara
 */
public class TransactionManager {
  public static void begin(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
    }

    public static void commit(Connection connection) throws SQLException {
        connection.commit();
        connection.setAutoCommit(true);
    }

    public static void rollback(Connection connection) {
        try {
            connection.rollback();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }  
}
