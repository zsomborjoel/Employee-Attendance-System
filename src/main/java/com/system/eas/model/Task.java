package com.system.eas.model;

import java.util.Objects;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name = "task", schema = "eas")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long taskId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Employee employee;

    @Column(name = "task_name", nullable = true)
    private String taskName;

    @Column(name = "task_date", nullable = true)
    private LocalDate taskDate;

    @Column(name = "task_start_time", nullable = true)
    private LocalDateTime taskStartTime;

    @Column(name = "task_end_time", nullable = true)
    private LocalDateTime taskEndTime;

    public Task() {
    }

    public Task(@JsonProperty("taskId") long taskId,
                @JsonProperty("employee") Employee employee,
                @JsonProperty("taskName") String taskName,
                @JsonProperty("taskDate") LocalDate taskDate,
                @JsonProperty("taskStartTime") LocalDateTime taskStartTime,
                @JsonProperty("taskEndTime") LocalDateTime taskEndTime) {
        this.taskId = taskId;
        this.employee = employee;
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.taskStartTime = taskStartTime;
        this.taskEndTime = taskEndTime;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDate getTaskDate() {
        return this.taskDate;
    }

    public void setTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }

    public LocalDateTime getTaskStartTime() {
        return this.taskStartTime;
    }

    public void setTaskStartTime(LocalDateTime taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public LocalDateTime getTaskEndTime() {
        return this.taskEndTime;
    }

    public void setTaskEndTime(LocalDateTime taskEndTime) {
        this.taskEndTime = taskEndTime;
    }
   
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Task)) {
            return false;
        }
        Task task = (Task) o;
        return taskId == task.taskId 
                && Objects.equals(taskName, task.taskName) 
                && Objects.equals(taskDate, task.taskDate) 
                && Objects.equals(taskStartTime, task.taskStartTime) 
                && Objects.equals(taskEndTime, task.taskEndTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId,
                            taskName,
                            taskDate,
                            taskStartTime,
                            taskEndTime);
    }

    @Override
    public String toString() {
        return "{" +
            " taskId='" + Long.toString(getTaskId()) + "'" +
            ", taskName='" + getTaskName() + "'" +
            ", taskDate='" + getTaskDate().toString() + "'" +
            ", taskStartTime='" + getTaskStartTime().toString() + "'" +
            ", taskEndTime='" + getTaskEndTime().toString() + "'" +
            "}";
    }

}