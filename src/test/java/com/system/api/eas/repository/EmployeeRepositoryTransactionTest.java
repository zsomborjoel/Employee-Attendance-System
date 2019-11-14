package com.system.api.eas.repository;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

import com.system.eas.Application;
import com.system.eas.model.Employee;
import com.system.eas.repository.EmployeeRepository;
import com.system.eas.service.EmployeeService;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

@ContextConfiguration(classes = Application.class)
@SpringBootTest
public class EmployeeRepositoryTransactionTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;


    @Test
    public void testSampleService() {
        assertTrue(true);
    }
    
    @Test
    public void testInjectedComponentsAreNotNull() {
        assertThat(employeeRepository, is(not(null)));
    }

    @Test
    public void testShouldGetBackEmployee() {
        Optional<Employee> employee = employeeRepository.findById((long) 2);
    }
    
    @Test
    public void testShouldFinishTransaction() {
        LocalDate dt = LocalDate.parse("2019-10-10");
        Long id = (long) 99;
        employeeRepository.save(new Employee(id, "Joe", "Marine street 4", "joe@fm.co", "sales", dt, "manager", 100000));
    }
    
}