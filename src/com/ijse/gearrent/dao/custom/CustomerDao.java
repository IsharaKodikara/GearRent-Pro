/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.gearrent.dao.custom;

import com.ijse.gearrent.dao.SuperDao;
import com.ijse.gearrent.entity.CustomerEntity;
import java.util.List;
/**
 *
 * @author Ishara
 */
public interface CustomerDao extends SuperDao {

    boolean save(CustomerEntity entity) throws Exception;

    boolean update(CustomerEntity entity) throws Exception;

    CustomerEntity findById(int customerId) throws Exception;

    List<CustomerEntity> findAll() throws Exception;

    double getTotalActiveDeposits(int customerId) throws Exception;
}
