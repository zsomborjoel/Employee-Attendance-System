package com.system.eas.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "employee", schema = "eas")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    @Column(name = "employee_name", nullable = true)
    private String employeeName;

    @Column(name = "employee_address", nullable = true)
    private String employeeAddress;

    @Column(name = "employee_email", nullable = true)
    private String employeeEmail;

    @Column(name = "employee_department", nullable = true)
    private String employeeDepartment;

    @Column(name = "employee_join_date", nullable = true)
    private LocalDate employeeJoinDate;

    @Column(name = "employee_position", nullable = true)
    private String employeePosition;

    @Column(name = "employee_salary", nullable = true)
    private int employeeSalary;

    public Employee() {
    }

    public Employee(@JsonProperty("employeeId") long employeeId, 
                    @JsonProperty("employeeName") String employeeName, 
                    @JsonProperty("employeeAddress") String employeeAddress, 
                    @JsonProperty("employeeEmail") String employeeEmail, 
                    @JsonProperty("employeeDepartment") String employeeDepartment, 
                    @JsonProperty("employeeJoinDate") LocalDate employeeJoinDate, 
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

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Long employeeId) {
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

    public LocalDate getEmployeeJoinDate() {
        return this.employeeJoinDate;
    }

    public void setEmployeeJoinDate(LocalDate employeeJoinDate) {
        this.employeeJoinDate = employeeJoinDate;
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
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId 
                && Objects.equals(employeeName, employee.employeeName) 
                && Objects.equals(employeeAddress, employee.employeeAddress) 
                && Objects.equals(employeeEmail, employee.employeeEmail) 
                && Objects.equals(employeeDepartment, employee.employeeDepartment) 
                && Objects.equals(employeeJoinDate, employee.employeeJoinDate) 
                && Objects.equals(employeePosition, employee.employeePosition) 
                && employeeSalary == employee.employeeSalary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId,
                            employeeName,
                            employeeAddress,
                            employeeEmail,
                            employeeDepartment,
                            employeeJoinDate,
                            employeePosition,
                            employeeSalary);
    }
    
    @Override
    public String toString() {
        return "{" +
            " employeeId='" + Long.toString(getEmployeeId()) + "'" +
            ", employeeName='" + getEmployeeName() + "'" +
            ", employeeAddress='" + getEmployeeAddress() + "'" +
            ", employeeEmail='" + getEmployeeEmail() + "'" +
            ", employeeDepartment='" + getEmployeeDepartment() + "'" +
            ", joinDate='" + getEmployeeJoinDate().toString() + "'" +
            ", employeePosition='" + getEmployeePosition() + "'" +
            ", employeeSalary='" + Integer.toString(getEmployeeSalary()) + "'" +
            "}";
    }
}