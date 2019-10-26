package com.system.eas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.system.eas.model.Leave;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {
    
    void applyLeave(Leave leave);

    void cancelLeave(Long leaveId);

    Optional<Leave> getLeaveById(Long leaveId);

    Optional<Leave> getLeaveByEmployeeId(Long employeeId);

    List<Leave> listAllLeave();

}