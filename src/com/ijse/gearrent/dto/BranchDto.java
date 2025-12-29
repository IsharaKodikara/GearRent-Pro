/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.dto;

/**
 *
 * @author Ishara
 */
public class BranchDto {
    private int branchId;
    private String branchCode;
    private String name;
    private String address;
    private String contact;

    public BranchDto() {
    }

    public BranchDto(int branchId, String branchCode, String name, String address, String contact) {
        this.branchId = branchId;
        this.branchCode = branchCode;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    /**
     * @return the branchId
     */
    public int getBranchId() {
        return branchId;
    }

    /**
     * @param branchId the branchId to set
     */
    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    /**
     * @return the branchCode
     */
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * @param branchCode the branchCode to set
     */
    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "BranchDto{" + "branchId=" + branchId + ", branchCode=" + branchCode + ", name=" + name + ", address=" + address + ", contact=" + contact + '}';
    }
}
