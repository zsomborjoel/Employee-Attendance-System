package com.system.eas.controller;

import java.util.List;
import java.util.Optional;

import com.system.eas.model.Leave;
import com.system.eas.service.LeaveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping("/leave")
    public Leave applyLeave(Leave leave) {
        return leaveService.applyLeave(leave);
    }

    public void cancelLeave(Long leaveId) {
        // TODO Auto-generated method stub

    }

    public Optional<Leave> getLeaveById(Long leaveId) {
        // TODO Auto-generated method stub
        return null;
    }

    public Optional<Leave> getLeaveByEmployeeId(Long employeeId) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Leave> listAllLeave() {
        // TODO Auto-generated method stub
        return null;
    }
    
}