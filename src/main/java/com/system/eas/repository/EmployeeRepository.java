package com.system.eas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.eas.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}