/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.dao.custom.impl;

import com.ijse.gearrent.dao.custom.CustomerDao;
import com.ijse.gearrent.db.DBConnection;
import com.ijse.gearrent.entity.CustomerEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ishara
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean save(CustomerEntity entity) throws Exception {
        String sql = "INSERT INTO customers (name, nic_passport, contact, email, address, membership_id) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, entity.getName());
        ps.setString(2, entity.getNicPassport());
        ps.setString(3, entity.getContact());
        ps.setString(4, entity.getEmail());
        ps.setString(5, entity.getAddress());
        ps.setInt(6, entity.getMembershipId());
        return ps.executeUpdate() > 0;
    }

    @Override
    public boolean update(CustomerEntity entity) throws Exception {
        String sql = "UPDATE customers SET name=?, contact=?, email=?, address=?, membership_id=? WHERE customer_id=?";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, entity.getName());
        ps.setString(2, entity.getContact());
        ps.setString(3, entity.getEmail());
        ps.setString(4, entity.getAddress());
        ps.setInt(5, entity.getMembershipId());
        ps.setInt(6, entity.getCustomerId());
        return ps.executeUpdate() > 0;
    }

    @Override
    public CustomerEntity findById(int customerId) throws Exception {
        String sql = "SELECT * FROM customers WHERE customer_id=?";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setInt(1, customerId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new CustomerEntity(
                    rs.getInt("customer_id"),
                    rs.getString("name"),
                    rs.getString("nic_passport"),
                    rs.getString("contact"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getInt("membership_id")
            );
        }
        return null;
    }

    @Override
    public List<CustomerEntity> findAll() throws Exception {
        ResultSet rs = DBConnection.getInstance().getConnection()
                .createStatement().executeQuery("SELECT * FROM customers");

        List<CustomerEntity> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new CustomerEntity(
                    rs.getInt("customer_id"),
                    rs.getString("name"),
                    rs.getString("nic_passport"),
                    rs.getString("contact"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getInt("membership_id")
            ));
        }
        return list;
    }

    @Override
    public double getTotalActiveDeposits(int customerId) throws Exception {
        String sql = "SELECT IFNULL(SUM(security_deposit),0) FROM rentals WHERE customer_id=? AND rental_status='ACTIVE'";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setInt(1, customerId);
        ResultSet rs = ps.executeQuery();
        return rs.next() ? rs.getDouble(1) : 0;
    }
}
