/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.gearrent.dao.custom;

import com.ijse.gearrent.dao.SuperDao;
import com.ijse.gearrent.entity.UserEntity;
/**
 *
 * @author Ishara
 */
public interface UserDao extends SuperDao {

    UserEntity findByUsernameAndPassword(String username, String password) throws Exception;
}
