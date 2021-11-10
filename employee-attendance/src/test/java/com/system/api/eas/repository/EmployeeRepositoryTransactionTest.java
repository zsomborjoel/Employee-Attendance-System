package com.system.api.eas.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import com.system.eas.Application;
import com.system.eas.model.Employee;
import com.system.eas.repository.EmployeeRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest
public class EmployeeRepositoryTransactionTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testEmployeeRepository() {
        assertNotNull(employeeRepository);
    }

    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName("TestEmployee");
        employeeRepository.save(employee);
        Optional<Employee> employee2 = employeeRepository.findById(employee.getEmployeeId());
        assertNotNull(employee2);
        assertEquals(employee.getEmployeeName(), employee2.get().getEmployeeName());
    }
 
    @Test
    public void testDeleteEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName("TestEmployee");
        employeeRepository.save(employee);
        employeeRepository.delete(employee);
    }

    @Test
    public void testFindAllEmployees() {
        assertNotNull(employeeRepository.findAll());
    }

    @Test
    public void testDeleteByEmployeeId() {
        Employee employee = new Employee();
        employee.setEmployeeName("TestEmployee");
        employeeRepository.deleteById(employee.getEmployeeId());
    }
}