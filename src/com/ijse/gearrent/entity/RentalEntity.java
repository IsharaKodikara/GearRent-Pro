/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.entity;

import java.time.LocalDate;

/**
 *
 * @author Ishara
 */
public class RentalEntity {
    private int rentalId;
    private int equipmentId;
    private int customerId;
    private int branchId;
    private LocalDate startDate;
    private LocalDate endDate;
    private double rentalAmount;
    private double securityDeposit;
    private double membershipDiscount;
    private double longRentalDiscount;
    private double finalPayable;
    private String paymentStatus;
    private String rentalStatus;
    private LocalDate actualReturnDate;

    public RentalEntity() {
    }

    public RentalEntity(int rentalId, int equipmentId, int customerId, int branchId,
                        LocalDate startDate, LocalDate endDate, double rentalAmount,
                        double securityDeposit, double membershipDiscount,
                        double longRentalDiscount, double finalPayable,
                        String paymentStatus, String rentalStatus, LocalDate actualReturnDate) {
        this.rentalId = rentalId;
        this.equipmentId = equipmentId;
        this.customerId = customerId;
        this.branchId = branchId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentalAmount = rentalAmount;
        this.securityDeposit = securityDeposit;
        this.membershipDiscount = membershipDiscount;
        this.longRentalDiscount = longRentalDiscount;
        this.finalPayable = finalPayable;
        this.paymentStatus = paymentStatus;
        this.rentalStatus = rentalStatus;
        this.actualReturnDate = actualReturnDate;
    }

    /**
     * @return the rentalId
     */
    public int getRentalId() {
        return rentalId;
    }

    /**
     * @param rentalId the rentalId to set
     */
    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    /**
     * @return the equipmentId
     */
    public int getEquipmentId() {
        return equipmentId;
    }

    /**
     * @param equipmentId the equipmentId to set
     */
    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    /**
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
     * @return the startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the rentalAmount
     */
    public double getRentalAmount() {
        return rentalAmount;
    }

    /**
     * @param rentalAmount the rentalAmount to set
     */
    public void setRentalAmount(double rentalAmount) {
        this.rentalAmount = rentalAmount;
    }

    /**
     * @return the securityDeposit
     */
    public double getSecurityDeposit() {
        return securityDeposit;
    }

    /**
     * @param securityDeposit the securityDeposit to set
     */
    public void setSecurityDeposit(double securityDeposit) {
        this.securityDeposit = securityDeposit;
    }

    /**
     * @return the membershipDiscount
     */
    public double getMembershipDiscount() {
        return membershipDiscount;
    }

    /**
     * @param membershipDiscount the membershipDiscount to set
     */
    public void setMembershipDiscount(double membershipDiscount) {
        this.membershipDiscount = membershipDiscount;
    }

    /**
     * @return the longRentalDiscount
     */
    public double getLongRentalDiscount() {
        return longRentalDiscount;
    }

    /**
     * @param longRentalDiscount the longRentalDiscount to set
     */
    public void setLongRentalDiscount(double longRentalDiscount) {
        this.longRentalDiscount = longRentalDiscount;
    }

    /**
     * @return the finalPayable
     */
    public double getFinalPayable() {
        return finalPayable;
    }

    /**
     * @param finalPayable the finalPayable to set
     */
    public void setFinalPayable(double finalPayable) {
        this.finalPayable = finalPayable;
    }

    /**
     * @return the paymentStatus
     */
    public String getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * @param paymentStatus the paymentStatus to set
     */
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * @return the rentalStatus
     */
    public String getRentalStatus() {
        return rentalStatus;
    }

    /**
     * @param rentalStatus the rentalStatus to set
     */
    public void setRentalStatus(String rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    /**
     * @return the actualReturnDate
     */
    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    /**
     * @param actualReturnDate the actualReturnDate to set
     */
    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    @Override
    public String toString() {
        return "RentalEntity{" + "rentalId=" + rentalId + ", equipmentId=" + equipmentId + ", customerId=" + customerId + ", branchId=" + branchId + ", startDate=" + startDate + ", endDate=" + endDate + ", rentalAmount=" + rentalAmount + ", securityDeposit=" + securityDeposit + ", membershipDiscount=" + membershipDiscount + ", longRentalDiscount=" + longRentalDiscount + ", finalPayable=" + finalPayable + ", paymentStatus=" + paymentStatus + ", rentalStatus=" + rentalStatus + ", actualReturnDate=" + actualReturnDate + '}';
    }
    
    
}
