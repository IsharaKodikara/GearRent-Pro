/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.entity;

/**
 *
 * @author Ishara
 */
public class UserEntity {
    private int userId;
    private String username;
    private String password;
    private String role;
    private Integer branchId;

    public UserEntity() {
    }

    public UserEntity(int userId, String username, String password, String role, Integer branchId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.branchId = branchId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the branchId
     */
    public Integer getBranchId() {
        return branchId;
    }

    /**
     * @param branchId the branchId to set
     */
    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    @Override
    public String toString() {
        return "UserEntity{" + "userId=" + userId + ", username=" + username + ", password=" + password + ", role=" + role + ", branchId=" + branchId + '}';
    } 
}
