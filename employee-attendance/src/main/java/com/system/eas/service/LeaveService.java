package com.system.eas.service;

import java.util.List;

import com.system.eas.exception.ResourceNotFoundException;
import com.system.eas.model.Leave;
import com.system.eas.repository.EmployeeRepository;
import com.system.eas.repository.LeaveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Leave applyLeave(Long employeeId, Leave leave) throws ResourceNotFoundException {
        return employeeRepository.findById(employeeId).map(employee -> {
            leave.setEmployee(employee);
            return leaveRepository.save(leave);
        }).orElseThrow(() -> new ResourceNotFoundException("Leave not found for this id: " + employeeId));
    }

    public void cancelLeave(Long leaveId) throws ResourceNotFoundException {
        Leave leave = leaveRepository.findById(leaveId)
                                        .orElseThrow(() -> new ResourceNotFoundException("Leave not found for this id: " + leaveId));
        leaveRepository.delete(leave);
    }

    public ResponseEntity<Leave> getLeaveById(Long leaveId) throws ResourceNotFoundException {
        Leave leave = leaveRepository.findById(leaveId)
                                        .orElseThrow(() -> new ResourceNotFoundException("Leave not found for this id: " + leaveId));
        return ResponseEntity.ok().body(leave);
    }

    
    public List<Leave> getAllLeavesByEmployeeId(Long employeeId) {
        return leaveRepository.findByEmployeeEmployeeId(employeeId);
    }

}