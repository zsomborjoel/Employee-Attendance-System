package com.system.api.eas.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;

import com.system.eas.model.Employee;

public class EmployeeTest {

    @Test
    public void should_get_right_name() throws Exception {
        LocalDate dt = LocalDate.parse("2019-10-10");
        Employee employee = new Employee(1, "Joe", "Marine street 4", "joe@fm.co", "sales", dt, "manager", 100000);
        assertThat(employee.getEmployeeName(), is("Joe"));
    }

}