/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.service.custom.impl;

import com.ijse.gearrent.dao.custom.UserDao;
import com.ijse.gearrent.dao.custom.impl.UserDaoImpl;
import com.ijse.gearrent.dto.UserDto;
import com.ijse.gearrent.entity.UserEntity;
import com.ijse.gearrent.service.custom.AuthService;

/**
 *
 * @author Ishara
 */
public class AuthServiceImpl implements AuthService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public UserDto login(String username, String password) throws Exception {

        UserEntity entity = userDao.findByUsernameAndPassword(username, password);

        if (entity == null) {
            return null;
        }

        return new UserDto(
                entity.getUserId(),
                entity.getUsername(),
                entity.getRole(),
                entity.getBranchId()
        );
    }
}
