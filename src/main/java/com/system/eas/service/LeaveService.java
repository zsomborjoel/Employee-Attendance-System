package com.system.eas.service;

import java.util.List;

import com.system.eas.exception.ResourceNotFoundException;
import com.system.eas.model.Leave;
import com.system.eas.repository.LeaveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    public Leave applyLeave(Leave leave) {
        return leaveRepository.save(leave);
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

    public List<Leave> listAllLeave() {
        return leaveRepository.findAll();
    }

    public List<Leave> getLeaveByEmployeeId(Long employeeId) throws ResourceNotFoundException {
        return leaveRepository.findByEmployee(employeeId);
    }

}