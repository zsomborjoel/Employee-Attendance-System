package com.system.eas.controller;

import java.util.List;

import javax.validation.Valid;

import com.system.eas.exception.ResourceNotFoundException;
import com.system.eas.model.Leave;
import com.system.eas.service.LeaveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping("/employees/{employee_id}/leaves")
    public Leave applyLeave(@PathVariable(value = "employee_id") Long employeeId, @Valid @RequestBody Leave leave) throws ResourceNotFoundException {
        return leaveService.applyLeave(employeeId, leave);
    }

    @DeleteMapping("/leaves/{leave_id}")
    public void cancelLeave(@PathVariable(value = "leave_id") Long leaveId) throws ResourceNotFoundException {
        leaveService.cancelLeave(leaveId);
    }

    @GetMapping("/leaves/{leave_id}")
    public ResponseEntity<Leave> getLeaveById(@PathVariable(value = "leave_id") Long leaveId) throws ResourceNotFoundException {
        return leaveService.getLeaveById(leaveId);
    }

    @GetMapping("/employees/{employee_id}/leaves")
    public List<Leave> getAllLeavesByEmployeeId(@PathVariable(value = "employee_id") Long employeeId) {
        return leaveService.getAllLeavesByEmployeeId(employeeId);
    }
}