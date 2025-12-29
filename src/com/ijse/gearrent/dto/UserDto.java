/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.gearrent.dto;

/**
 *
 * @author Ishara
 */
public class UserDto {
    private int userId;
    private String username;
    private String role;
    private Integer branchId;

    public UserDto() {
    }

    public UserDto(int userId, String username, String role, Integer branchId) {
        this.userId = userId;
        this.username = username;
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
        return "UserDto{" + "userId=" + userId + ", username=" + username + ", role=" + role + ", branchId=" + branchId + '}';
    }
}
