/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.service.custom.impl;

import com.ijse.gearrent.dao.custom.EquipmentDao;
import com.ijse.gearrent.dao.custom.ReservationDao;
import com.ijse.gearrent.dao.custom.impl.EquipmentDaoImpl;
import com.ijse.gearrent.dao.custom.impl.ReservationDaoImpl;
import com.ijse.gearrent.dto.ReservationDto;
import com.ijse.gearrent.entity.EquipmentEntity;
import com.ijse.gearrent.entity.ReservationEntity;
import com.ijse.gearrent.service.custom.ReservationService;

/**
 *
 * @author Ishara
 */
public class ReservationServiceImpl implements ReservationService {

    private final ReservationDao reservationDao = new ReservationDaoImpl();
    private final EquipmentDao equipmentDao = new EquipmentDaoImpl();

    @Override
    public boolean createReservation(ReservationDto dto) throws Exception {

        EquipmentEntity equipment = equipmentDao.findById(dto.getEquipmentId());
        if (equipment == null || !equipment.getStatus().equals("AVAILABLE")) {
            return false;
        }

        boolean overlapping = !reservationDao.findOverlappingReservations(
                dto.getEquipmentId(),
                dto.getStartDate(),
                dto.getEndDate()
        ).isEmpty();

        if (overlapping) return false;

        return reservationDao.save(new ReservationEntity(
                0,
                dto.getEquipmentId(),
                dto.getCustomerId(),
                dto.getStartDate(),
                dto.getEndDate(),
                "ACTIVE"
        ));
    }

    @Override
    public boolean cancelReservation(int reservationId) throws Exception {
        return reservationDao.cancel(reservationId);
    }
}
