/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.service.custom.impl;

import com.ijse.gearrent.dao.custom.*;
import com.ijse.gearrent.dao.custom.impl.CategoryDaoImpl;
import com.ijse.gearrent.dao.custom.impl.CustomerDaoImpl;
import com.ijse.gearrent.dao.custom.impl.DamageDaoImpl;
import com.ijse.gearrent.dao.custom.impl.EquipmentDaoImpl;
import com.ijse.gearrent.dao.custom.impl.RentalDaoImpl;
import com.ijse.gearrent.dto.RentalDto;
import com.ijse.gearrent.entity.*;
import com.ijse.gearrent.service.custom.RentalService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ishara
 */
public class RentalServiceImpl implements RentalService {

    private final RentalDao rentalDao = new RentalDaoImpl();
    private final EquipmentDao equipmentDao = new EquipmentDaoImpl();
    private final CategoryDao categoryDao = new CategoryDaoImpl();
    private final CustomerDao customerDao = new CustomerDaoImpl();
    private final DamageDao damageDao = new DamageDaoImpl();

    @Override
    public RentalDto createRental(RentalDto dto) throws Exception {

        EquipmentEntity equipment = equipmentDao.findById(dto.getEquipmentId());
        CategoryEntity category = categoryDao.findById(equipment.getCategoryId());

        long days = ChronoUnit.DAYS.between(dto.getStartDate(), dto.getEndDate()) + 1;

        double baseAmount = equipment.getBaseDailyPrice()
                * days
                * category.getBasePriceFactor();

        double membershipDiscount = (dto.getMembershipDiscount() > 0)
                ? baseAmount * dto.getMembershipDiscount()
                : 0;

        double longRentalDiscount = (days >= 7)
                ? baseAmount * 0.10
                : 0;

        double finalPayable = baseAmount - membershipDiscount - longRentalDiscount;

        RentalEntity entity = new RentalEntity(
                0,
                dto.getEquipmentId(),
                dto.getCustomerId(),
                dto.getBranchId(),
                dto.getStartDate(),
                dto.getEndDate(),
                baseAmount,
                equipment.getSecurityDeposit(),
                membershipDiscount,
                longRentalDiscount,
                finalPayable,
                "PAID",
                "ACTIVE",
                null
        );

        rentalDao.save(entity);
        equipmentDao.updateStatus(dto.getEquipmentId(), "RENTED");

        dto.setRentalAmount(baseAmount);
        dto.setFinalPayable(finalPayable);
        dto.setRentalStatus("ACTIVE");

        return dto;
    }

    @Override
    public RentalDto returnRental(int rentalId, LocalDate actualReturnDate, double damageCharge) throws Exception {

        RentalEntity rental = rentalDao.findById(rentalId);
        CategoryEntity category = categoryDao.findById(
                equipmentDao.findById(rental.getEquipmentId()).getCategoryId()
        );

        long lateDays = ChronoUnit.DAYS.between(rental.getEndDate(), actualReturnDate);
        double lateFee = lateDays > 0 ? lateDays * category.getLateFeePerDay() : 0;

        double finalPayable = rental.getFinalPayable() + lateFee + damageCharge;

        rental.setRentalStatus("COMPLETED");
        rental.setActualReturnDate(actualReturnDate);
        rental.setFinalPayable(finalPayable);

        rentalDao.update(rental);
        equipmentDao.updateStatus(rental.getEquipmentId(), "AVAILABLE");

        if (damageCharge > 0) {
            damageDao.save(new DamageEntity(
                    0,
                    rentalId,
                    "Reported Damage",
                    damageCharge
            ));
        }

        return new RentalDto(
                rental.getRentalId(),
                rental.getEquipmentId(),
                rental.getCustomerId(),
                rental.getBranchId(),
                rental.getStartDate(),
                rental.getEndDate(),
                rental.getRentalAmount(),
                rental.getSecurityDeposit(),
                rental.getMembershipDiscount(),
                rental.getLongRentalDiscount(),
                finalPayable,
                rental.getPaymentStatus(),
                rental.getRentalStatus(),
                actualReturnDate
        );
    }

    @Override
    public List<RentalDto> getOverdueRentals() throws Exception {

        List<RentalDto> list = new ArrayList<>();

        for (RentalEntity e : rentalDao.findOverdueRentals(LocalDate.now())) {
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
                    null
            ));
        }
        return list;
    }
}
