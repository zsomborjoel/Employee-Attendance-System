package com.system.api.eas.repository;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import com.system.eas.exception.ResourceNotFoundException;
import com.system.eas.model.Employee;
import com.system.eas.repository.EmployeeRepository;
import com.system.eas.service.EmployeeService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class EmployeeRepositoryTransactionTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void should_finish_transaction() throws ResourceNotFoundException {
        LocalDate dt = LocalDate.parse("2019-10-10");
        Long id = (long) 99;
        Employee employee = new Employee(id, "Joe", "Marine street 4", "joe@fm.co", "sales", dt, "manager", 100000);
        employeeRepository.save(employee);
        assertEquals(employeeService.getEmployeeById(id), employee.getEmployeeId());
    }
    
}