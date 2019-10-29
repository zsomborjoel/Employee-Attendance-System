package com.system.eas.controller;

import java.util.List;

import javax.validation.Valid;

import com.system.eas.exception.ResourceNotFoundException;
import com.system.eas.model.Employee;
import com.system.eas.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;    

    @GetMapping("/employees")
    public List<Employee> listAllEmployee() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public void addEmployee(@Valid @RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    @DeleteMapping("/employees/{employee_id}")
    public void deleteEmployee(@PathVariable(value = "employee_id")  Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                                                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id: " + employeeId));
        employeeRepository.delete(employee);                                        
    }

    @PutMapping("/employees/{employee_id}")
    public void updateEmployee(@PathVariable(value = "employee_id") Long employeeId, @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                                                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id: " + employeeId)); 
        employee.setEmployeeName(employeeDetails.getEmployeeName());
        employee.setEmployeeEmail(employeeDetails.getEmployeeEmail());
        employee.setEmployeeAddress(employeeDetails.getEmployeeAddress());
        employee.setEmployeeDepartment(employeeDetails.getEmployeeDepartment());
        employee.setEmployeePosition(employeeDetails.getEmployeePosition());
        employee.setEmployeeSalary(employeeDetails.getEmployeeSalary());
        employee.setEmployeeJoinDate(employeeDetails.getEmployeeJoinDate());
    }

    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "employee_id") Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                                                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id: " + employeeId)); 
        return ResponseEntity.ok().body(employee);                                  
    }
    
}