/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.dao.custom.impl;

import com.ijse.gearrent.dao.custom.DamageDao;
import com.ijse.gearrent.db.DBConnection;
import com.ijse.gearrent.entity.DamageEntity;

import java.sql.PreparedStatement;

/**
 *
 * @author Ishara
 */
public class DamageDaoImpl implements DamageDao {

    @Override
    public boolean save(DamageEntity entity) throws Exception {
        String sql = "INSERT INTO damages (rental_id, description, damage_charge) VALUES (?,?,?)";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setInt(1, entity.getRentalId());
        ps.setString(2, entity.getDescription());
        ps.setDouble(3, entity.getDamageCharge());
        return ps.executeUpdate() > 0;
    }
}
