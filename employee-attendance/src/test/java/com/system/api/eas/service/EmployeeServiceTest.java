package com.system.api.eas.service;

import static org.junit.Assert.assertThat;

import com.system.eas.exception.ResourceNotFoundException;
import com.system.eas.model.Employee;
import com.system.eas.service.EmployeeService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
class EmployeeServiceTest {
    
    @Autowired
    private EmployeeService service;

    @Test
    public void should_give_back_test_employee() throws ResourceNotFoundException {
        Long id = (long) 3;
        final ResponseEntity<Employee> testEmployee = service.getEmployeeById(id);
        assertThat(testEmployee.getStatusCode(), is(404));
    }

}