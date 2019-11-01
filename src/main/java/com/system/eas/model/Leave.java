package com.system.eas.model;

import java.util.Objects;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "leave", schema = "eas")
public class Leave {

    private long leaveId;
    private long employeeId;
    private String leaveTitle;
    private String leaveDetail;
    private LocalDate leaveRequestDate;
    private LocalDate leaveAcceptanceDate;
    private LocalDate leaveStartDate;
    private LocalDate leaveEndDate;

    public Leave() {
    }

    public Leave(@JsonProperty("leaveId") long leaveId,
                @JsonProperty("employeeId") long employeeId,
                @JsonProperty("leaveTitle") String leaveTitle,
                @JsonProperty("leaveDetail") String leaveDetail,
                @JsonProperty("leaveRequestDate") LocalDate leaveRequestDate,
                @JsonProperty("leaveAcceptanceDate") LocalDate leaveAcceptanceDate,
                @JsonProperty("leaveStartDate") LocalDate leaveStartDate,
                @JsonProperty("leaveEndDate") LocalDate leaveEndDate) {
        this.leaveId = leaveId;
        this.employeeId = employeeId;
        this.leaveTitle = leaveTitle;
        this.leaveDetail = leaveDetail;
        this.leaveRequestDate = leaveRequestDate;
        this.leaveAcceptanceDate = leaveAcceptanceDate;
        this.leaveStartDate = leaveStartDate;
        this.leaveEndDate = leaveEndDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getLeaveId() {
        return this.leaveId;
    }

    public void setLeaveId(long leaveId) {
        this.leaveId = leaveId;
    }

    public long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name = "leave_title", nullable = true)
    public String getLeaveTitle() {
        return this.leaveTitle;
    }

    public void setLeaveTitle(String leaveTitle) {
        this.leaveTitle = leaveTitle;
    }

    @Column(name = "leave_detail", nullable = true)
    public String getLeaveDetail() {
        return this.leaveDetail;
    }

    public void setLeaveDetail(String leaveDetail) {
        this.leaveDetail = leaveDetail;
    }

    @Column(name = "leave_request_date", nullable = true)
    public LocalDate getLeaveRequestDate() {
        return this.leaveRequestDate;
    }

    public void setLeaveRequestDate(LocalDate leaveRequestDate) {
        this.leaveRequestDate = leaveRequestDate;
    }

    @Column(name = "leave_acceptance_date", nullable = true)
    public LocalDate getLeaveAcceptanceDate() {
        return this.leaveAcceptanceDate;
    }

    public void setLeaveAcceptanceDate(LocalDate leaveAcceptanceDate) {
        this.leaveAcceptanceDate = leaveAcceptanceDate;
    }

    @Column(name = "leave_start_date", nullable = true)
    public LocalDate getLeaveStartDate() {
        return this.leaveStartDate;
    }

    public void setLeaveStartDate(LocalDate leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    @Column(name = "leave_end_date", nullable = true)
    public LocalDate getLeaveEndDate() {
        return this.leaveEndDate;
    }

    public void setLeaveEndDate(LocalDate leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Leave)) {
            return false;
        }
        Leave leave = (Leave) o;
        return leaveId == leave.leaveId 
                && employeeId == leave.employeeId 
                && Objects.equals(leaveTitle, leave.leaveTitle) 
                && Objects.equals(leaveDetail, leave.leaveDetail) 
                && Objects.equals(leaveRequestDate, leave.leaveRequestDate) 
                && Objects.equals(leaveAcceptanceDate, leave.leaveAcceptanceDate) 
                && Objects.equals(leaveStartDate, leave.leaveStartDate) 
                && Objects.equals(leaveEndDate, leave.leaveEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leaveId,
                            employeeId,
                            leaveTitle,
                            leaveDetail,
                            leaveRequestDate,
                            leaveAcceptanceDate,
                            leaveStartDate,
                            leaveEndDate);
    }

    @Override
    public String toString() {
        return "{" +
            " leaveId='" + Long.toString(getLeaveId()) + "'" +
            ", employeeId='" + Long.toString(getEmployeeId()) + "'" +
            ", leaveTitle='" + getLeaveTitle() + "'" +
            ", leaveDetail='" + getLeaveDetail() + "'" +
            ", leaveRequestDate='" + getLeaveRequestDate() + "'" +
            ", leaveAcceptanceDate='" + getLeaveAcceptanceDate().toString() + "'" +
            ", leaveStartDate='" + getLeaveStartDate().toString() + "'" +
            ", leaveEndDate='" + getLeaveEndDate().toString() + "'" +
            "}";
    }
   
}