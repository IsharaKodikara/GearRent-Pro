/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.dao.custom.impl;

import com.ijse.gearrent.dao.custom.UserDao;
import com.ijse.gearrent.db.DBConnection;
import com.ijse.gearrent.entity.UserEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Ishara
 */
public class UserDaoImpl implements UserDao {

    @Override
    public UserEntity findByUsernameAndPassword(String username, String password) throws Exception {
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new UserEntity(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role"),
                    rs.getInt("branch_id")
            );
        }
        return null;
    }
}
