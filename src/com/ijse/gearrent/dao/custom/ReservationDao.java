/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.gearrent.dao.custom;

import com.ijse.gearrent.dao.SuperDao;
import com.ijse.gearrent.entity.ReservationEntity;
import java.time.LocalDate;
import java.util.List;
/**
 *
 * @author Ishara
 */
public interface ReservationDao extends SuperDao {

    boolean save(ReservationEntity entity) throws Exception;

    boolean cancel(int reservationId) throws Exception;

    List<ReservationEntity> findOverlappingReservations(
            int equipmentId,
            LocalDate start,
            LocalDate end
    ) throws Exception;
}
