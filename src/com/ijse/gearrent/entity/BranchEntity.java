/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.entity;

/**
 *
 * @author Ishara
 */
public class BranchEntity {
    private int branchId;
    private String branchCode;
    private String name;
    private String address;
    private String contact;

    public BranchEntity() {
    }

    public BranchEntity(int branchId, String branchCode, String name, String address, String contact) {
        this.branchId = branchId;
        this.branchCode = branchCode;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
