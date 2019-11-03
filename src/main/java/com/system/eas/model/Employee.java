package com.system.eas.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "employee", schema = "eas")
public class Employee {

    private long employeeId;
    private String employeeName;
    private String employeeAddress;
    private String employeeEmail;
    private String employeeDepartment;
    private LocalDate employeeJoinDate;
    private String employeePosition;
    private int employeeSalary;
    private List<Leave> leave;

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name = "employee_name", nullable = true)
    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Column(name = "employee_address", nullable = true)
    public String getEmployeeAddress() {
        return this.employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    @Column(name = "employee_email", nullable = true)
    public String getEmployeeEmail() {
        return this.employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    @Column(name = "employee_department", nullable = true)
    public String getEmployeeDepartment() {
        return this.employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    @Column(name = "employee_join_date", nullable = true)
    public LocalDate getEmployeeJoinDate() {
        return this.employeeJoinDate;
    }

    public void setEmployeeJoinDate(LocalDate employeeJoinDate) {
        this.employeeJoinDate = employeeJoinDate;
    }

    @Column(name = "employee_position", nullable = true)
    public String getEmployeePosition() {
        return this.employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    @Column(name = "employee_salary", nullable = true)
    public int getEmployeeSalary() {
        return this.employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    public List<Leave> getLeave() {
        return this.leave;
    }

    public void setLeave(List<Leave> leave) {
        this.leave = leave;
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