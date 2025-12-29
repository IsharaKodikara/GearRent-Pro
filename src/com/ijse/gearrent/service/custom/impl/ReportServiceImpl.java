/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.service.custom.impl;

import com.ijse.gearrent.dao.custom.RentalDao;
import com.ijse.gearrent.dao.custom.impl.RentalDaoImpl;
import com.ijse.gearrent.dto.RentalDto;
import com.ijse.gearrent.entity.RentalEntity;
import com.ijse.gearrent.service.custom.ReportService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ishara
 */
public class ReportServiceImpl implements ReportService {

    private final RentalDao rentalDao = new RentalDaoImpl();

    @Override
    public List<RentalDto> getRentalHistory(LocalDate from, LocalDate to) throws Exception {

        List<RentalDto> list = new ArrayList<>();

        for (RentalEntity e : rentalDao.findActiveRentals()) {
            if (!e.getStartDate().isBefore(from) && !e.getEndDate().isAfter(to)) {
                list.add(new RentalDto(
                        e.getRentalId(),
                        e.getEquipmentId(),
                        e.getCustomerId(),
                        e.getBranchId(),
                        e.getStartDate(),
                        e.getEndDate(),
                        e.getRentalAmount(),
                        e.getSecurityDeposit(),
                        e.getMembershipDiscount(),
                        e.getLongRentalDiscount(),
                        e.getFinalPayable(),
                        e.getPaymentStatus(),
                        e.getRentalStatus(),
                        e.getActualReturnDate()
                ));
            }
        }
        return list;
    }

    @Override
    public double getTotalRevenue(LocalDate from, LocalDate to) throws Exception {

        double total = 0;

        for (RentalDto r : getRentalHistory(from, to)) {
            total += r.getFinalPayable();
        }
        return total;
    }
}

