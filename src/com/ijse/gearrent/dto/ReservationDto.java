/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.dto;

import java.time.LocalDate;
/**
 *
 * @author Ishara
 */
public class ReservationDto {
     private int reservationId;
    private int equipmentId;
    private int customerId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    public ReservationDto() {
    }

    public ReservationDto(int reservationId, int equipmentId, int customerId,
                          LocalDate startDate, LocalDate endDate, String status) {
        this.reservationId = reservationId;
        this.equipmentId = equipmentId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    /**
     * @return the reservationId
     */
    public int getReservationId() {
        return reservationId;
    }

    /**
     * @param reservationId the reservationId to set
     */
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
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
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReservationDto{" + "reservationId=" + reservationId + ", equipmentId=" + equipmentId + ", customerId=" + customerId + ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + '}';
    }
}
