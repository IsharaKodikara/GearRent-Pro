/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java
 */
package com.ijse.gearrent.dao.custom.impl;

import com.ijse.gearrent.dao.custom.EquipmentDao;
import com.ijse.gearrent.db.DBConnection;
import com.ijse.gearrent.entity.EquipmentEntity;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ishara
 */
public class EquipmentDaoImpl implements EquipmentDao {

     @Override
    public boolean save(EquipmentEntity entity) throws Exception {
        String sql = "INSERT INTO equipment (equipment_id, category_id, branch_id, brand, model, purchase_year, base_daily_price, security_deposit, status) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setInt(1, entity.getEquipmentId());
        ps.setInt(2, entity.getCategoryId());
        ps.setInt(3, entity.getBranchId());
        ps.setString(4, entity.getBrand());
        ps.setString(5, entity.getModel());
        ps.setInt(6, entity.getPurchaseYear());
        ps.setDouble(7, entity.getBaseDailyPrice());
        ps.setDouble(8, entity.getSecurityDeposit());
        ps.setString(9, entity.getStatus());
        return ps.executeUpdate() > 0;
    }

    @Override
    public boolean update(EquipmentEntity entity) throws Exception {
        String sql = "UPDATE equipment SET category_id=?, branch_id, brand=?, model=?,purchase_year, base_daily_price=?, security_deposit=?, status=? WHERE equipment_id=?";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setInt(1, entity.getBranchId());
        ps.setString(2, entity.getBrand());
        ps.setString(3, entity.getModel());
        ps.setInt(4, entity.getPurchaseYear());
        ps.setDouble(5, entity.getBaseDailyPrice());
        ps.setDouble(6, entity.getSecurityDeposit());
        ps.setString(7, entity.getStatus());
        ps.setInt(8, entity.getCategoryId());
        ps.setInt(9, entity.getEquipmentId());
        return ps.executeUpdate() > 0;
    }

    @Override
    public EquipmentEntity findById(int equipmentId) throws Exception {
        String sql = "SELECT * FROM equipment WHERE equipment_id=?";

        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setInt(1, equipmentId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new EquipmentEntity(
                    rs.getInt("equipment_id"),
                    rs.getInt("category_id"),
                    rs.getInt("branch_id"),
                    rs.getString("brand"),
                    rs.getString("model"),
                    rs.getInt("purchase_year"),
                    rs.getDouble("base_daily_price"),
                    rs.getDouble("security_deposit"),
                    rs.getString("status")
            );
        }
        return null;
    }

    @Override
    public List<EquipmentEntity> findByBranch(int branchId) throws Exception {
        String sql = "SELECT * FROM equipment WHERE branch_id=?";

        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setInt(1, branchId);
        ResultSet rs = ps.executeQuery();

        List<EquipmentEntity> list = new ArrayList<>();
        if (rs.next()) {
            list.add(new EquipmentEntity(
                    rs.getInt("equipment_id"),
                    rs.getInt("category_id"),
                    rs.getInt("branch_id"),
                    rs.getString("brand"),
                    rs.getString("model"),
                    rs.getInt("purchase_year"),
                    rs.getDouble("base_daily_price"),
                    rs.getDouble("security_deposit"),
                    rs.getString("status")
            ));
        }
        return list;
    }

    @Override
    public List<EquipmentEntity> findAvailable(int branchId, LocalDate start, LocalDate end) {
        // Availability handled in Service layer
        return new ArrayList<>();
    }

    @Override
    public boolean updateStatus(int equipmentId, String status) throws Exception {
        String sql = "UPDATE equipment SET status=? WHERE equipment_id=?";

        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, status);
        ps.setInt(2, equipmentId);

        return ps.executeUpdate() > 0;
    }

    @Override
    public List<EquipmentEntity> getAll() throws Exception {

        List<EquipmentEntity> list = new ArrayList<>();

        String sql = "SELECT * FROM equipment";
    Statement stm = DBConnection.getInstance()
            .getConnection()
            .createStatement();

    ResultSet rs = stm.executeQuery(sql);

    while (rs.next()) {
        list.add(new EquipmentEntity(
                rs.getInt("equipment_id"),
                rs.getInt("category_id"),
                rs.getInt("branch_id"),
                rs.getString("brand"),
                rs.getString("model"),
                rs.getInt("purchase_year"),
                rs.getDouble("base_daily_price"),
                rs.getDouble("security_deposit"),
                rs.getString("status")
        ));
    }
    return list;
    }
}


