/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.dto;

/**
 *
 * @author Ishara
 */
public class CustomerDto {
     private int customerId;
    private String name;
    private String nicPassport;
    private String contact;
    private String email;
    private String address;
    private int membershipId;

    public CustomerDto() {
    }

    public CustomerDto(int customerId, String name, String nicPassport,
                       String contact, String email, String address, int membershipId) {
        this.customerId = customerId;
        this.name = name;
        this.nicPassport = nicPassport;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.membershipId = membershipId;
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
     * @return the nicPassport
     */
    public String getNicPassport() {
        return nicPassport;
    }

    /**
     * @param nicPassport the nicPassport to set
     */
    public void setNicPassport(String nicPassport) {
        this.nicPassport = nicPassport;
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

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @return the membershipId
     */
    public int getMembershipId() {
        return membershipId;
    }

    /**
     * @param membershipId the membershipId to set
     */
    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    @Override
    public String toString() {
        return "CustomerDto{" + "customerId=" + customerId + ", name=" + name + ", nicPassport=" + nicPassport + ", contact=" + contact + ", email=" + email + ", address=" + address + ", membershipId=" + membershipId + '}';
    }
}
