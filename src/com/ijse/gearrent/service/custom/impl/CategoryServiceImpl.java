/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.service.custom.impl;

import com.ijse.gearrent.dao.custom.CategoryDao;
import com.ijse.gearrent.dao.custom.impl.CategoryDaoImpl;
import com.ijse.gearrent.dto.CategoryDto;
import com.ijse.gearrent.entity.CategoryEntity;
import com.ijse.gearrent.service.custom.CategoryService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ishara
 */
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public boolean addCategory(CategoryDto dto) throws Exception {
        return categoryDao.save(new CategoryEntity(
                0,
                dto.getName(),
                dto.getDescription(),
                dto.getBasePriceFactor(),
                dto.getWeekendMultiplier(),
                dto.getLateFeePerDay(),
                true
        ));
    }

    @Override
    public boolean updateCategory(CategoryDto dto) throws Exception {
        return categoryDao.update(new CategoryEntity(
                dto.getCategoryId(),
                dto.getName(),
                dto.getDescription(),
                dto.getBasePriceFactor(),
                dto.getWeekendMultiplier(),
                dto.getLateFeePerDay(),
                dto.isActive()
        ));
    }

    @Override
    public boolean deactivateCategory(int categoryId) throws Exception {
        return categoryDao.deactivate(categoryId);
    }

    @Override
    public CategoryDto getCategory(int categoryId) throws Exception {
        CategoryEntity e = categoryDao.findById(categoryId);
        if (e == null) return null;

        return new CategoryDto(
                e.getCategoryId(),
                e.getName(),
                e.getDescription(),
                e.getBasePriceFactor(),
                e.getWeekendMultiplier(),
                e.getLateFeePerDay(),
                e.isActive()
        );
    }

    @Override
    public List<CategoryDto> getActiveCategories() throws Exception {
        List<CategoryDto> list = new ArrayList<>();
        for (CategoryEntity e : categoryDao.findAllActive()) {
            list.add(new CategoryDto(
                    e.getCategoryId(),
                    e.getName(),
                    e.getDescription(),
                    e.getBasePriceFactor(),
                    e.getWeekendMultiplier(),
                    e.getLateFeePerDay(),
                    e.isActive()
            ));
        }
        return list;
    }
}
