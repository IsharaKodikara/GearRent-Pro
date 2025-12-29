/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.dto;

/**
 *
 * @author Ishara
 */
public class CategoryDto {
    private int categoryId;
    private String name;
    private String description;
    private double basePriceFactor;
    private double weekendMultiplier;
    private double lateFeePerDay;
    private boolean active;

    public CategoryDto() {
    }

    public CategoryDto(int categoryId, String name, String description,
                       double basePriceFactor, double weekendMultiplier,
                       double lateFeePerDay, boolean active) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.basePriceFactor = basePriceFactor;
        this.weekendMultiplier = weekendMultiplier;
        this.lateFeePerDay = lateFeePerDay;
        this.active = active;
    }

    /**
     * @return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the basePriceFactor
     */
    public double getBasePriceFactor() {
        return basePriceFactor;
    }

    /**
     * @param basePriceFactor the basePriceFactor to set
     */
    public void setBasePriceFactor(double basePriceFactor) {
        this.basePriceFactor = basePriceFactor;
    }

    /**
     * @return the weekendMultiplier
     */
    public double getWeekendMultiplier() {
        return weekendMultiplier;
    }

    /**
     * @param weekendMultiplier the weekendMultiplier to set
     */
    public void setWeekendMultiplier(double weekendMultiplier) {
        this.weekendMultiplier = weekendMultiplier;
    }

    /**
     * @return the lateFeePerDay
     */
    public double getLateFeePerDay() {
        return lateFeePerDay;
    }

    /**
     * @param lateFeePerDay the lateFeePerDay to set
     */
    public void setLateFeePerDay(double lateFeePerDay) {
        this.lateFeePerDay = lateFeePerDay;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CategoryDto{" + "categoryId=" + categoryId + ", name=" + name + ", description=" + description + ", basePriceFactor=" + basePriceFactor + ", weekendMultiplier=" + weekendMultiplier + ", lateFeePerDay=" + lateFeePerDay + ", active=" + active + '}';
    }
}
