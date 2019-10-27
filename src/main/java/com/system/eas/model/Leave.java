package com.system.eas.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Leave {
    private long leaveId;
    private long employeeId;
    private String leaveTitle;
    private String leaveDetail;
    private String leaveRequestDate;
    private String leaveAcceptanceDate;
    private String leaveStartDate;
    private String leaveEndDate;

    public Leave() {
    }

    public Leave(@JsonProperty("leaveId") long leaveId,
                @JsonProperty("employeeId") long employeeId,
                @JsonProperty("leaveTitle") String leaveTitle,
                @JsonProperty("leaveDetail") String leaveDetail,
                @JsonProperty("leaveRequestDate") String leaveRequestDate,
                @JsonProperty("leaveAcceptanceDate") String leaveAcceptanceDate,
                @JsonProperty("leaveStartDate") String leaveStartDate,
                @JsonProperty("leaveEndDate") String leaveEndDate) {
        this.leaveId = leaveId;
        this.employeeId = employeeId;
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

    public long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
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

    public String getLeaveRequestDate() {
        return this.leaveRequestDate;
    }

    public void setLeaveRequestDate(String leaveRequestDate) {
        this.leaveRequestDate = leaveRequestDate;
    }

    public String getLeaveAcceptanceDate() {
        return this.leaveAcceptanceDate;
    }

    public void setLeaveAcceptanceDate(String leaveAcceptanceDate) {
        this.leaveAcceptanceDate = leaveAcceptanceDate;
    }

    public String getLeaveStartDate() {
        return this.leaveStartDate;
    }

    public void setLeaveStartDate(String leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public String getLeaveEndDate() {
        return this.leaveEndDate;
    }

    public void setLeaveEndDate(String leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    @Override
    public String toString() {
        return "{" +
            " leaveId='" + getLeaveId() + "'" +
            ", employeeId='" + getEmployeeId() + "'" +
            ", leaveTitle='" + getLeaveTitle() + "'" +
            ", leaveDetail='" + getLeaveDetail() + "'" +
            ", leaveRequestDate='" + getLeaveRequestDate() + "'" +
            ", leaveAcceptanceDate='" + getLeaveAcceptanceDate() + "'" +
            ", leaveStartDate='" + getLeaveStartDate() + "'" +
            ", leaveEndDate='" + getLeaveEndDate() + "'" +
            "}";
    }
   
}