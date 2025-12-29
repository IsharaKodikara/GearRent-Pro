/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.gearrent.dao.custom;

import com.ijse.gearrent.dao.SuperDao;
import com.ijse.gearrent.entity.CategoryEntity;
import java.util.List;
/**
 *
 * @author Ishara
 */
public interface CategoryDao extends SuperDao {

    boolean save(CategoryEntity entity) throws Exception;

    boolean update(CategoryEntity entity) throws Exception;

    boolean deactivate(int categoryId) throws Exception;

    CategoryEntity findById(int categoryId) throws Exception;

    List<CategoryEntity> findAllActive() throws Exception;
}
