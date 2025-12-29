/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.dao.custom.impl;

import com.ijse.gearrent.dao.custom.CategoryDao;
import com.ijse.gearrent.db.DBConnection;
import com.ijse.gearrent.entity.CategoryEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ishara
 */
public class CategoryDaoImpl implements CategoryDao {

    @Override
    public boolean save(CategoryEntity entity) throws Exception {
        String sql = "INSERT INTO categories (name,description,base_price_factor,weekend_multiplier,late_fee_per_day,active) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, entity.getName());
        ps.setString(2, entity.getDescription());
        ps.setDouble(3, entity.getBasePriceFactor());
        ps.setDouble(4, entity.getWeekendMultiplier());
        ps.setDouble(5, entity.getLateFeePerDay());
        ps.setBoolean(6, entity.isActive());
        return ps.executeUpdate() > 0;
    }

    @Override
    public boolean update(CategoryEntity entity) throws Exception {
        String sql = "UPDATE categories SET description=?, base_price_factor=?, weekend_multiplier=?, late_fee_per_day=?, active=? WHERE category_id=?";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, entity.getDescription());
        ps.setDouble(2, entity.getBasePriceFactor());
        ps.setDouble(3, entity.getWeekendMultiplier());
        ps.setDouble(4, entity.getLateFeePerDay());
        ps.setBoolean(5, entity.isActive());
        ps.setInt(6, entity.getCategoryId());
        return ps.executeUpdate() > 0;
    }

    @Override
    public boolean deactivate(int categoryId) throws Exception {
        String sql = "UPDATE categories SET active=false WHERE category_id=?";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setInt(1, categoryId);
        return ps.executeUpdate() > 0;
    }

    @Override
    public CategoryEntity findById(int categoryId) throws Exception {
        String sql = "SELECT * FROM categories WHERE category_id=?";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setInt(1, categoryId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new CategoryEntity(
                    rs.getInt("category_id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDouble("base_price_factor"),
                    rs.getDouble("weekend_multiplier"),
                    rs.getDouble("late_fee_per_day"),
                    rs.getBoolean("active")
            );
        }
        return null;
    }

    @Override
    public List<CategoryEntity> findAllActive() throws Exception {
        String sql = "SELECT * FROM categories WHERE active=true";
        ResultSet rs = DBConnection.getInstance().getConnection().createStatement().executeQuery(sql);

        List<CategoryEntity> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new CategoryEntity(
                    rs.getInt("category_id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDouble("base_price_factor"),
                    rs.getDouble("weekend_multiplier"),
                    rs.getDouble("late_fee_per_day"),
                    rs.getBoolean("active")
            ));
        }
        return list;
    }
}
