/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.gearrent.service.custom;

import com.ijse.gearrent.dto.ReservationDto;
import com.ijse.gearrent.service.SuperService;

/**
 *
 * @author Ishara
 */
public interface ReservationService extends SuperService {

    boolean createReservation(ReservationDto dto) throws Exception;

    boolean cancelReservation(int reservationId) throws Exception;
}
