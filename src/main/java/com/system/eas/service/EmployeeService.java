package com.system.eas.service;

import java.util.List;

import com.system.eas.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.system.eas.exception.ResourceNotFoundException;
import com.system.eas.model.Employee;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;    

    public List<Employee> listAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                                                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id: " + employeeId));
        employeeRepository.delete(employee);                                        
    }

    public ResponseEntity<Employee> updateEmployee(Long employeeId, Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                                                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id: " + employeeId)); 
        employee.setEmployeeName(employeeDetails.getEmployeeName());
        employee.setEmployeeEmail(employeeDetails.getEmployeeEmail());
        employee.setEmployeeAddress(employeeDetails.getEmployeeAddress());
        employee.setEmployeeDepartment(employeeDetails.getEmployeeDepartment());
        employee.setEmployeePosition(employeeDetails.getEmployeePosition());
        employee.setEmployeeSalary(employeeDetails.getEmployeeSalary());
        employee.setEmployeeJoinDate(employeeDetails.getEmployeeJoinDate());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    public ResponseEntity<Employee> getEmployeeById(Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                                                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id: " + employeeId)); 
        return ResponseEntity.ok().body(employee);                       
    }
}