package com.system.api.eas;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.system.eas.model.Employee;
import com.system.eas.repository.EmployeeRepository;
import com.system.eas.service.EmployeeService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void getEmployeeTest() {
		when(employeeRepository.findAll())
		.thenReturn(
			Stream.of(new Employee(2, "Béla", null, null, null, null, null, 0))
			.collect(Collectors.toList())
		);
		assertEquals(1, employeeService.listAllEmployee().size());
	}

}
