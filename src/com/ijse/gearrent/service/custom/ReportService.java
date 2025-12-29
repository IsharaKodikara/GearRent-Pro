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
public interface ReportService extends SuperService {

    List<RentalDto> getRentalHistory(LocalDate from, LocalDate to) throws Exception;

    double getTotalRevenue(LocalDate from, LocalDate to) throws Exception;
}
