package com.example.r2dbc.repository;

import com.example.r2dbc.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author rishi
 */
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {}
