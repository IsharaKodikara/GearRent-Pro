/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.service.custom.impl;

import com.ijse.gearrent.dao.custom.EquipmentDao;
import com.ijse.gearrent.dao.custom.ReservationDao;
import com.ijse.gearrent.dao.custom.RentalDao;
import com.ijse.gearrent.dao.custom.impl.EquipmentDaoImpl;
import com.ijse.gearrent.dao.custom.impl.RentalDaoImpl;
import com.ijse.gearrent.dao.custom.impl.ReservationDaoImpl;
import com.ijse.gearrent.dto.EquipmentDto;
import com.ijse.gearrent.entity.EquipmentEntity;
import com.ijse.gearrent.service.custom.EquipmentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ishara
 */
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentDao equipmentDao = new EquipmentDaoImpl();
    private final ReservationDao reservationDao = new ReservationDaoImpl();
    private final RentalDao rentalDao = new RentalDaoImpl();

    @Override
    public boolean addEquipment(EquipmentDto dto) throws Exception {
        return equipmentDao.save(new EquipmentEntity(
                0,
                dto.getCategoryId(),
                dto.getBranchId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getPurchaseYear(),
                dto.getBaseDailyPrice(),
                dto.getSecurityDeposit(),
                "AVAILABLE"
        ));
    }

    @Override
    public boolean updateEquipment(EquipmentDto dto) throws Exception {
        return equipmentDao.update(new EquipmentEntity(
                dto.getEquipmentId(),
                dto.getCategoryId(),
                dto.getBranchId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getPurchaseYear(),
                dto.getBaseDailyPrice(),
                dto.getSecurityDeposit(),
                dto.getStatus()
        ));
    }

    @Override
    public EquipmentDto getEquipment(int equipmentId) throws Exception {
        EquipmentEntity e = equipmentDao.findById(equipmentId);
        if (e == null) return null;

        return new EquipmentDto(
                e.getEquipmentId(),
                e.getCategoryId(),
                e.getBranchId(),
                e.getBrand(),
                e.getModel(),
                e.getPurchaseYear(),
                e.getBaseDailyPrice(),
                e.getSecurityDeposit(),
                e.getStatus()
        );
    }

    @Override
    public List<EquipmentDto> getEquipmentByBranch(int branchId) throws Exception {
        List<EquipmentDto> list = new ArrayList<>();
        for (EquipmentEntity e : equipmentDao.findByBranch(branchId)) {
            list.add(new EquipmentDto(
                    e.getEquipmentId(),
                    e.getCategoryId(),
                    e.getBranchId(),
                    e.getBrand(),
                    e.getModel(),
                    e.getPurchaseYear(),
                    e.getBaseDailyPrice(),
                    e.getSecurityDeposit(),
                    e.getStatus()
            ));
        }
        return list;
    }

    @Override
    public List<EquipmentDto> getAvailableEquipment(int branchId, LocalDate startDate, LocalDate endDate) throws Exception {

        List<EquipmentDto> available = new ArrayList<>();

        for (EquipmentEntity e : equipmentDao.findByBranch(branchId)) {

            boolean hasReservation =
                    !reservationDao.findOverlappingReservations(
                            e.getEquipmentId(),
                            startDate,
                            endDate
                    ).isEmpty();

            if (!hasReservation && e.getStatus().equals("AVAILABLE")) {

                available.add(new EquipmentDto(
                        e.getEquipmentId(),
                        e.getCategoryId(),
                        e.getBranchId(),
                        e.getBrand(),
                        e.getModel(),
                        e.getPurchaseYear(),
                        e.getBaseDailyPrice(),
                        e.getSecurityDeposit(),
                        e.getStatus()
                ));
            }
        }
        return available;
    }
    
    
}
