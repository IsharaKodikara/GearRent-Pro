/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.gearrent.service.custom;

import com.ijse.gearrent.dto.RentalDto;
import com.ijse.gearrent.service.SuperService;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Ishara
 */
public interface RentalService extends SuperService {

    RentalDto createRental(RentalDto dto) throws Exception;

    RentalDto returnRental(
            int rentalId,
            LocalDate actualReturnDate,
            double damageCharge
    ) throws Exception;

    List<RentalDto> getOverdueRentals() throws Exception;
}

