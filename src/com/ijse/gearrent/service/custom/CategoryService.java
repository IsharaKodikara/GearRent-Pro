/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.gearrent.service.custom;

import com.ijse.gearrent.dto.CategoryDto;
import com.ijse.gearrent.service.SuperService;
import java.util.List;

/**
 *
 * @author Ishara
 */
public interface CategoryService extends SuperService {

    boolean addCategory(CategoryDto dto) throws Exception;

    boolean updateCategory(CategoryDto dto) throws Exception;

    boolean deactivateCategory(int categoryId) throws Exception;

    CategoryDto getCategory(int categoryId) throws Exception;

    List<CategoryDto> getActiveCategories() throws Exception;
}
