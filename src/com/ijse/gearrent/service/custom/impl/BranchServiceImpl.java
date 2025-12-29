/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.service.custom.impl;

import com.ijse.gearrent.dao.custom.BranchDao;
import com.ijse.gearrent.dao.custom.impl.BranchDaoImpl;
import com.ijse.gearrent.dto.BranchDto;
import com.ijse.gearrent.entity.BranchEntity;
import com.ijse.gearrent.service.custom.BranchService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ishara
 */
public class BranchServiceImpl implements BranchService {

    private final BranchDao branchDao = new BranchDaoImpl();

    @Override
    public boolean addBranch(BranchDto dto) throws Exception {
        return branchDao.save(
                new BranchEntity(
                        0,
                        dto.getBranchCode(),
                        dto.getName(),
                        dto.getAddress(),
                        dto.getContact()
                )
        );
    }

    @Override
    public boolean updateBranch(BranchDto dto) throws Exception {
        return branchDao.update(
                new BranchEntity(
                        dto.getBranchId(),
                        dto.getBranchCode(),
                        dto.getName(),
                        dto.getAddress(),
                        dto.getContact()
                )
        );
    }

    @Override
    public boolean deleteBranch(int branchId) throws Exception {
        return branchDao.delete(branchId);
    }

    @Override
    public BranchDto getBranch(int branchId) throws Exception {
        BranchEntity entity = branchDao.findById(branchId);

        if (entity == null) return null;

        return new BranchDto(
                entity.getBranchId(),
                entity.getBranchCode(),
                entity.getName(),
                entity.getAddress(),
                entity.getContact()
        );
    }

    @Override
    public List<BranchDto> getAllBranches() throws Exception {

        List<BranchEntity> entities = branchDao.findAll();
        List<BranchDto> dtos = new ArrayList<>();

        for (BranchEntity e : entities) {
            dtos.add(new BranchDto(
                    e.getBranchId(),
                    e.getBranchCode(),
                    e.getName(),
                    e.getAddress(),
                    e.getContact()
            ));
        }
        return dtos;
    }
}
