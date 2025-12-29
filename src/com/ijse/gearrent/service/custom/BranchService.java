/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.gearrent.service.custom;

import com.ijse.gearrent.dto.BranchDto;
import com.ijse.gearrent.service.SuperService;
import java.util.List;

/**
 *
 * @author Ishara
 */
public interface BranchService extends SuperService {

    boolean addBranch(BranchDto dto) throws Exception;

    boolean updateBranch(BranchDto dto) throws Exception;

    boolean deleteBranch(int branchId) throws Exception;

    BranchDto getBranch(int branchId) throws Exception;

    List<BranchDto> getAllBranches() throws Exception;
}
