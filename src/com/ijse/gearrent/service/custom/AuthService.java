/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.gearrent.service.custom;

import com.ijse.gearrent.dto.UserDto;
import com.ijse.gearrent.service.SuperService;

/**
 *
 * @author Ishara
 */
public interface AuthService extends SuperService {

    UserDto login(String username, String password) throws Exception;
}
