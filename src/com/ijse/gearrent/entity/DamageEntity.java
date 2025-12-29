/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.entity;

/**
 *
 * @author Ishara
 */
public class DamageEntity {
    private int damageId;
    private int rentalId;
    private String description;
    private double damageCharge;

    public DamageEntity() {
    }

    public DamageEntity(int damageId, int rentalId, String description, double damageCharge) {
        this.damageId = damageId;
        this.rentalId = rentalId;
        this.description = description;
        this.damageCharge = damageCharge;
    }

    public int getDamageId() {
        return damageId;
    }

    public void setDamageId(int damageId) {
        this.damageId = damageId;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDamageCharge() {
        return damageCharge;
    }

    public void setDamageCharge(double damageCharge) {
        this.damageCharge = damageCharge;
    }
}
