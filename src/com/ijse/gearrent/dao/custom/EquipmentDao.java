/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.gearrent.dao.custom;

import com.ijse.gearrent.dao.SuperDao;
import com.ijse.gearrent.entity.EquipmentEntity;
import java.time.LocalDate;
import java.util.List;
/**
 *
 * @author Ishara
 */
public interface EquipmentDao extends SuperDao {

    boolean save(EquipmentEntity entity) throws Exception;

    boolean update(EquipmentEntity entity) throws Exception;

    EquipmentEntity findById(int equipmentId) throws Exception;

    List<EquipmentEntity> findByBranch(int branchId) throws Exception;

    List<EquipmentEntity> findAvailable(int branchId, LocalDate start, LocalDate end) throws Exception;

    boolean updateStatus(int equipmentId, String status) throws Exception;
}

