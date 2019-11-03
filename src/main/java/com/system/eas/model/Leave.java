package com.system.eas.model;

import java.util.Objects;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "leave", schema = "eas")
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long leaveId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "employee_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Employee employee;

    @Column(name = "leave_title", nullable = true)
    private String leaveTitle;

    @Column(name = "leave_detail", nullable = true)
    private String leaveDetail;

    @Column(name = "leave_request_date", nullable = true)
    private LocalDate leaveRequestDate;

    @Column(name = "leave_acceptance_date", nullable = true)
    private LocalDate leaveAcceptanceDate;

    @Column(name = "leave_start_date", nullable = true)
    private LocalDate leaveStartDate;

    @Column(name = "leave_end_date", nullable = true)
    private LocalDate leaveEndDate;

    public Leave() {
    }

    public Leave(@JsonProperty("leaveId") long leaveId,
                @JsonProperty("employee") Employee employee,
                @JsonProperty("leaveTitle") String leaveTitle,
                @JsonProperty("leaveDetail") String leaveDetail,
                @JsonProperty("leaveRequestDate") LocalDate leaveRequestDate,
                @JsonProperty("leaveAcceptanceDate") LocalDate leaveAcceptanceDate,
                @JsonProperty("leaveStartDate") LocalDate leaveStartDate,
                @JsonProperty("leaveEndDate") LocalDate leaveEndDate) {
        this.leaveId = leaveId;
        this.employee = employee;
        this.leaveTitle = leaveTitle;
        this.leaveDetail = leaveDetail;
        this.leaveRequestDate = leaveRequestDate;
        this.leaveAcceptanceDate = leaveAcceptanceDate;
        this.leaveStartDate = leaveStartDate;
        this.leaveEndDate = leaveEndDate;
    }

    
    public long getLeaveId() {
        return this.leaveId;
    }

    public void setLeaveId(long leaveId) {
        this.leaveId = leaveId;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getLeaveTitle() {
        return this.leaveTitle;
    }

    public void setLeaveTitle(String leaveTitle) {
        this.leaveTitle = leaveTitle;
    }

    public String getLeaveDetail() {
        return this.leaveDetail;
    }

    public void setLeaveDetail(String leaveDetail) {
        this.leaveDetail = leaveDetail;
    }

    public LocalDate getLeaveRequestDate() {
        return this.leaveRequestDate;
    }

    public void setLeaveRequestDate(LocalDate leaveRequestDate) {
        this.leaveRequestDate = leaveRequestDate;
    }

    public LocalDate getLeaveAcceptanceDate() {
        return this.leaveAcceptanceDate;
    }

    public void setLeaveAcceptanceDate(LocalDate leaveAcceptanceDate) {
        this.leaveAcceptanceDate = leaveAcceptanceDate;
    }

    public LocalDate getLeaveStartDate() {
        return this.leaveStartDate;
    }

    public void setLeaveStartDate(LocalDate leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

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
            ", leaveTitle='" + getLeaveTitle() + "'" +
            ", leaveDetail='" + getLeaveDetail() + "'" +
            ", leaveRequestDate='" + getLeaveRequestDate() + "'" +
            ", leaveAcceptanceDate='" + getLeaveAcceptanceDate().toString() + "'" +
            ", leaveStartDate='" + getLeaveStartDate().toString() + "'" +
            ", leaveEndDate='" + getLeaveEndDate().toString() + "'" +
            "}";
    }
   
}