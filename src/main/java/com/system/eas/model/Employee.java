package com.system.eas.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    private long employeeId;
    private String employeeName;
    private String employeeAddress;
    private String employeeEmail;
    private String employeeDepartment;
    private String employeeJoinDate;
    private String employeePosition;
    private int employeeSalary;

    public Employee() {
    }

    public Employee(@JsonProperty("employeeId") long employeeId, 
                    @JsonProperty("employeeName") String employeeName, 
                    @JsonProperty("employeeAddress") String employeeAddress, 
                    @JsonProperty("employeeEmail") String employeeEmail, 
                    @JsonProperty("employeeDepartment") String employeeDepartment, 
                    @JsonProperty("employeeJoinDate") String employeeJoinDate, 
                    @JsonProperty("employeePosition") String employeePosition, 
                    @JsonProperty("employeeSalary") int employeeSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeeEmail = employeeEmail;
        this.employeeDepartment = employeeDepartment;
        this.employeeJoinDate = employeeJoinDate;
        this.employeePosition = employeePosition;
        this.employeeSalary = employeeSalary;
    }

    public long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return this.employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeEmail() {
        return this.employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeDepartment() {
        return this.employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public String getJoinDate() {
        return this.employeeJoinDate;
    }

    public void setJoinDate(String employeeJoinDate) {
        this.employeeJoinDate = joinDate;
    }

    public String getEmployeePosition() {
        return this.employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public int getEmployeeSalary() {
        return this.employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    
    @Override
    public String toString() {
        return "{" +
            " employeeId='" + getEmployeeId() + "'" +
            ", employeeName='" + getEmployeeName() + "'" +
            ", employeeAddress='" + getEmployeeAddress() + "'" +
            ", employeeEmail='" + getEmployeeEmail() + "'" +
            ", employeeDepartment='" + getEmployeeDepartment() + "'" +
            ", joinDate='" + getJoinDate() + "'" +
            ", employeePosition='" + getEmployeePosition() + "'" +
            ", employeeSalary='" + getEmployeeSalary() + "'" +
            "}";
    }
}