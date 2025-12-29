/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.gearrent.dao.custom;

import com.ijse.gearrent.dao.SuperDao;
import com.ijse.gearrent.entity.DamageEntity;

/**
 *
 * @author Ishara
 */
public interface DamageDao extends SuperDao {

    boolean save(DamageEntity entity) throws Exception;
}
