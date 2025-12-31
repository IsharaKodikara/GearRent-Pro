/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.gearrent.service.custom;

import com.ijse.gearrent.dto.EquipmentDto;
import com.ijse.gearrent.service.SuperService;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Ishara
 */
public interface EquipmentService extends SuperService {

    boolean addEquipment(EquipmentDto dto) throws Exception;

    boolean updateEquipment(EquipmentDto dto) throws Exception;

    EquipmentDto getEquipment(int equipmentId) throws Exception;

    List<EquipmentDto> getEquipmentByBranch(int branchId) throws Exception;

    List<EquipmentDto> getAvailableEquipment(
            int branchId,
            LocalDate startDate,
            LocalDate endDate
    ) throws Exception;
    
     List<EquipmentDto> getAllEquipment() throws Exception;

}
