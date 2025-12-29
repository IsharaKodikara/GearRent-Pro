/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.service.custom.impl;

import com.ijse.gearrent.dao.custom.CustomerDao;
import com.ijse.gearrent.dao.custom.impl.CustomerDaoImpl;
import com.ijse.gearrent.dto.CustomerDto;
import com.ijse.gearrent.entity.CustomerEntity;
import com.ijse.gearrent.service.custom.CustomerService;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Ishara
 */
public class CustomerServiceImpl implements CustomerService {

    private static final double MAX_DEPOSIT_LIMIT = 100000.00;

    private final CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public boolean addCustomer(CustomerDto dto) throws Exception {
        return customerDao.save(new CustomerEntity(
                0,
                dto.getName(),
                dto.getNicPassport(),
                dto.getContact(),
                dto.getEmail(),
                dto.getAddress(),
                dto.getMembershipId()
        ));
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws Exception {
        return customerDao.update(new CustomerEntity(
                dto.getCustomerId(),
                dto.getName(),
                dto.getNicPassport(),
                dto.getContact(),
                dto.getEmail(),
                dto.getAddress(),
                dto.getMembershipId()
        ));
    }

    @Override
    public CustomerDto getCustomer(int customerId) throws Exception {
        CustomerEntity e = customerDao.findById(customerId);
        if (e == null) return null;

        return new CustomerDto(
                e.getCustomerId(),
                e.getName(),
                e.getNicPassport(),
                e.getContact(),
                e.getEmail(),
                e.getAddress(),
                e.getMembershipId()
        );
    }

    @Override
    public List<CustomerDto> getAllCustomers() throws Exception {
        List<CustomerDto> list = new ArrayList<>();
        for (CustomerEntity e : customerDao.findAll()) {
            list.add(new CustomerDto(
                    e.getCustomerId(),
                    e.getName(),
                    e.getNicPassport(),
                    e.getContact(),
                    e.getEmail(),
                    e.getAddress(),
                    e.getMembershipId()
            ));
        }
        return list;
    }

    @Override
    public boolean canRent(int customerId, double newDeposit) throws Exception {
        double currentDeposits = customerDao.getTotalActiveDeposits(customerId);
        return (currentDeposits + newDeposit) <= MAX_DEPOSIT_LIMIT;
    }
}