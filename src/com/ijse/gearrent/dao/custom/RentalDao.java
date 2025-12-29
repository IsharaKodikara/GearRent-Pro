/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.gearrent.dao.custom;

import com.ijse.gearrent.dao.SuperDao;
import com.ijse.gearrent.entity.RentalEntity;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Ishara
 */
public interface RentalDao extends SuperDao {

    boolean save(RentalEntity entity) throws Exception;

    boolean update(RentalEntity entity) throws Exception;

    RentalEntity findById(int rentalId) throws Exception;

    List<RentalEntity> findActiveRentals() throws Exception;

    List<RentalEntity> findOverdueRentals(LocalDate today) throws Exception;
}
