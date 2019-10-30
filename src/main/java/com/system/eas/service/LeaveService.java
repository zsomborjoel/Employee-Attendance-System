package com.system.eas.service;

import java.util.List;
import java.util.Optional;

import com.system.eas.exception.ResourceNotFoundException;
import com.system.eas.model.Leave;
import com.system.eas.repository.LeaveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    public void applyLeave(Leave leave) {
        leaveRepository.save(leave);
    }

    public void cancelLeave(Long leaveId) throws ResourceNotFoundException {
        Leave leave = leaveRepository.findById(leaveId)
                                        .orElseThrow(() -> new ResourceNotFoundException("Leave not found for this id: " + leaveId));
        leaveRepository.delete(leave);
    }

    public Leave getLeaveById(Long leaveId) throws ResourceNotFoundException {
        Leave leave = leaveRepository.findById(leaveId)
                                        .orElseThrow(() -> new ResourceNotFoundException("Leave not found for this id: " + leaveId));
        return leave;
    }

    public Leave getLeaveByEmployeeId(Long employeeId) {
        return null;
    }

    public List<Leave> listAllLeave() {
        // TODO Auto-generated method stub
        return null;
    }

}