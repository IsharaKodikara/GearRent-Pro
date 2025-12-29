/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.dao.custom.impl;

import com.ijse.gearrent.dao.custom.RentalDao;
import com.ijse.gearrent.db.DBConnection;
import com.ijse.gearrent.entity.RentalEntity;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ishara
 */
public class RentalDaoImpl implements RentalDao {

    @Override
    public boolean save(RentalEntity entity) throws Exception {
        String sql = "INSERT INTO rentals (equipment_id, customer_id, branch_id, start_date, end_date, rental_amount, security_deposit, membership_discount, long_rental_discount, final_payable, payment_status, rental_status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setInt(1, entity.getEquipmentId());
        ps.setInt(2, entity.getCustomerId());
        ps.setInt(3, entity.getBranchId());
        ps.setDate(4, Date.valueOf(entity.getStartDate()));
        ps.setDate(5, Date.valueOf(entity.getEndDate()));
        ps.setDouble(6, entity.getRentalAmount());
        ps.setDouble(7, entity.getSecurityDeposit());
        ps.setDouble(8, entity.getMembershipDiscount());
        ps.setDouble(9, entity.getLongRentalDiscount());
        ps.setDouble(10, entity.getFinalPayable());
        ps.setString(11, entity.getPaymentStatus());
        ps.setString(12, entity.getRentalStatus());
        return ps.executeUpdate() > 0;
    }

    @Override
    public boolean update(RentalEntity entity) throws Exception {
        String sql = "UPDATE rentals SET rental_status=?, actual_return_date=? WHERE rental_id=?";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, entity.getRentalStatus());
        ps.setDate(2, Date.valueOf(entity.getActualReturnDate()));
        ps.setInt(3, entity.getRentalId());
        return ps.executeUpdate() > 0;
    }

    @Override
    public RentalEntity findById(int rentalId) throws Exception {
        String sql = "SELECT * FROM rentals WHERE rental_id=?";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setInt(1, rentalId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new RentalEntity(
                    rs.getInt("rental_id"),
                    rs.getInt("equipment_id"),
                    rs.getInt("customer_id"),
                    rs.getInt("branch_id"),
                    rs.getDate("start_date").toLocalDate(),
                    rs.getDate("end_date").toLocalDate(),
                    rs.getDouble("rental_amount"),
                    rs.getDouble("security_deposit"),
                    rs.getDouble("membership_discount"),
                    rs.getDouble("long_rental_discount"),
                    rs.getDouble("final_payable"),
                    rs.getString("payment_status"),
                    rs.getString("rental_status"),
                    rs.getDate("actual_return_date") != null ? rs.getDate("actual_return_date").toLocalDate() : null
            );
        }
        return null;
    }

    @Override
    public List<RentalEntity> findActiveRentals() throws Exception {
        ResultSet rs = DBConnection.getInstance().getConnection()
                .createStatement().executeQuery("SELECT * FROM rentals WHERE rental_status='ACTIVE'");

        List<RentalEntity> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new RentalEntity(
                    rs.getInt("rental_id"),
                    rs.getInt("equipment_id"),
                    rs.getInt("customer_id"),
                    rs.getInt("branch_id"),
                    rs.getDate("start_date").toLocalDate(),
                    rs.getDate("end_date").toLocalDate(),
                    rs.getDouble("rental_amount"),
                    rs.getDouble("security_deposit"),
                    rs.getDouble("membership_discount"),
                    rs.getDouble("long_rental_discount"),
                    rs.getDouble("final_payable"),
                    rs.getString("payment_status"),
                    rs.getString("rental_status"),
                    null
            ));
        }
        return list;
    }

    @Override
    public List<RentalEntity> findOverdueRentals(LocalDate today) throws Exception {
        String sql = "SELECT * FROM rentals WHERE rental_status='ACTIVE' AND end_date < ?";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setDate(1, Date.valueOf(today));

        ResultSet rs = ps.executeQuery();
        List<RentalEntity> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new RentalEntity(
                    rs.getInt("rental_id"),
                    rs.getInt("equipment_id"),
                    rs.getInt("customer_id"),
                    rs.getInt("branch_id"),
                    rs.getDate("start_date").toLocalDate(),
                    rs.getDate("end_date").toLocalDate(),
                    rs.getDouble("rental_amount"),
                    rs.getDouble("security_deposit"),
                    rs.getDouble("membership_discount"),
                    rs.getDouble("long_rental_discount"),
                    rs.getDouble("final_payable"),
                    rs.getString("payment_status"),
                    rs.getString("rental_status"),
                    null
            ));
        }
        return list;
    }
}
