/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.dao.custom.impl;

import com.ijse.gearrent.dao.custom.BranchDao;
import com.ijse.gearrent.db.DBConnection;
import com.ijse.gearrent.entity.BranchEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ishara
 */
public class BranchDaoImpl implements BranchDao {

    @Override
    public boolean save(BranchEntity entity) throws Exception {
        String sql = "INSERT INTO branches (branch_code, name, address, contact) VALUES (?,?,?,?)";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, entity.getBranchCode());
        ps.setString(2, entity.getName());
        ps.setString(3, entity.getAddress());
        ps.setString(4, entity.getContact());
        return ps.executeUpdate() > 0;
    }

    @Override
    public boolean update(BranchEntity entity) throws Exception {
        String sql = "UPDATE branches SET name=?, address=?, contact=? WHERE branch_id=?";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, entity.getName());
        ps.setString(2, entity.getAddress());
        ps.setString(3, entity.getContact());
        ps.setInt(4, entity.getBranchId());
        return ps.executeUpdate() > 0;
    }

    @Override
    public boolean delete(int branchId) throws Exception {
        String sql = "DELETE FROM branches WHERE branch_id=?";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setInt(1, branchId);
        return ps.executeUpdate() > 0;
    }

    @Override
    public BranchEntity findById(int branchId) throws Exception {
        String sql = "SELECT * FROM branches WHERE branch_id=?";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setInt(1, branchId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new BranchEntity(
                    rs.getInt("branch_id"),
                    rs.getString("branch_code"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("contact")
            );
        }
        return null;
    }

    @Override
    public List<BranchEntity> findAll() throws Exception {
        String sql = "SELECT * FROM branches";
        Statement st = DBConnection.getInstance().getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);

        List<BranchEntity> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new BranchEntity(
                    rs.getInt("branch_id"),
                    rs.getString("branch_code"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("contact")
            ));
        }
        return list;
    }
}
