/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.dao.custom.impl;

import com.ijse.gearrent.dao.custom.ReservationDao;
import com.ijse.gearrent.db.DBConnection;
import com.ijse.gearrent.entity.ReservationEntity;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ishara
 */
public class ReservationDaoImpl implements ReservationDao {

    @Override
    public boolean save(ReservationEntity entity) throws Exception {
        String sql = "INSERT INTO reservations (equipment_id, customer_id, start_date, end_date, status) VALUES (?,?,?,?,?)";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setInt(1, entity.getEquipmentId());
        ps.setInt(2, entity.getCustomerId());
        ps.setDate(3, Date.valueOf(entity.getStartDate()));
        ps.setDate(4, Date.valueOf(entity.getEndDate()));
        ps.setString(5, entity.getStatus());
        return ps.executeUpdate() > 0;
    }

    @Override
    public boolean cancel(int reservationId) throws Exception {
        String sql = "UPDATE reservations SET status='CANCELLED' WHERE reservation_id=?";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setInt(1, reservationId);
        return ps.executeUpdate() > 0;
    }

    @Override
    public List<ReservationEntity> findOverlappingReservations(int equipmentId, LocalDate start, LocalDate end) throws Exception {
        String sql = "SELECT * FROM reservations WHERE equipment_id=? AND status='ACTIVE' AND (start_date <= ? AND end_date >= ?)";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setInt(1, equipmentId);
        ps.setDate(2, Date.valueOf(end));
        ps.setDate(3, Date.valueOf(start));

        ResultSet rs = ps.executeQuery();
        List<ReservationEntity> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new ReservationEntity(
                    rs.getInt("reservation_id"),
                    rs.getInt("equipment_id"),
                    rs.getInt("customer_id"),
                    rs.getDate("start_date").toLocalDate(),
                    rs.getDate("end_date").toLocalDate(),
                    rs.getString("status")
            ));
        }
        return list;
    }
}
