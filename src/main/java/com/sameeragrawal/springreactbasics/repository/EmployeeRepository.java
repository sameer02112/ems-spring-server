package com.sameeragrawal.springreactbasics.repository;

import com.sameeragrawal.springreactbasics.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
