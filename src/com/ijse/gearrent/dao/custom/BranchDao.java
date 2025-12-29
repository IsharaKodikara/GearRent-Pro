/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.gearrent.dao.custom;

import com.ijse.gearrent.dao.SuperDao;
import com.ijse.gearrent.entity.BranchEntity;
import java.util.List;

/**
 *
 * @author Ishara
 */
public interface BranchDao extends SuperDao {

    boolean save(BranchEntity entity) throws Exception;

    boolean update(BranchEntity entity) throws Exception;

    boolean delete(int branchId) throws Exception;

    BranchEntity findById(int branchId) throws Exception;

    List<BranchEntity> findAll() throws Exception;
}
