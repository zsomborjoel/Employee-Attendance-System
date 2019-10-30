package com.system.eas.controller;

import java.util.List;

import javax.validation.Valid;

import com.system.eas.exception.ResourceNotFoundException;
import com.system.eas.model.Employee;
import com.system.eas.repository.EmployeeRepository;
import com.system.eas.service.EmployeeService;

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

    private EmployeeService employeeService;    

    @GetMapping("/employees")
    public List<Employee> listAllEmployee() {
        return employeeService.listAllEmployee();
    }

    @PostMapping("/employees")
    public void addEmployee(@Valid @RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping("/employees/{employee_id}")
    public void deleteEmployee(@PathVariable(value = "employee_id")  Long employeeId) throws ResourceNotFoundException {
        employeeService.deleteEmployee(employeeId);                                    
    }

    @PutMapping("/employees/{employee_id}")
    public void updateEmployee(@PathVariable(value = "employee_id") Long employeeId, @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        employeeService.updateEmployee(employeeId, employeeDetails);
    }

    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "employee_id") Long employeeId) throws ResourceNotFoundException {
        return employeeService.getEmployeeById(employeeId);                              
    }
    
}