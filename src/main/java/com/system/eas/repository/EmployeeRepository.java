package com.system.eas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.system.eas.model.Employee;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> listAllEmployee();

    void addEmployee(Employee employee);

    void deleteEmployee(Long employeeId);

    void updateEmployee(Long employeeId);

    Optional<Employee> getEmployeeById(Long employeeId);
}