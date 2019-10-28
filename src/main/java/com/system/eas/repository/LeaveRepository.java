package com.system.eas.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.system.eas.model.Leave;

@Repository
public interface LeaveRepository {
    
    void applyLeave(Leave leave);

    void cancelLeave(Long leaveId);

    Optional<Leave> getLeaveById(Long leaveId);

    Optional<Leave> getLeaveByEmployeeId(Long employeeId);

    List<Leave> listAllLeave();

}