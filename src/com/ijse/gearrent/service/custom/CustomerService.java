/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.gearrent.service.custom;

import com.ijse.gearrent.dto.CustomerDto;
import com.ijse.gearrent.service.SuperService;
import java.util.List;

/**
 *
 * @author Ishara
 */
public interface CustomerService extends SuperService {

    boolean addCustomer(CustomerDto dto) throws Exception;

    boolean updateCustomer(CustomerDto dto) throws Exception;

    CustomerDto getCustomer(int customerId) throws Exception;

    List<CustomerDto> getAllCustomers() throws Exception;

    boolean canRent(int customerId, double newDeposit) throws Exception;
}
