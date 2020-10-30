package com.example.r2dbc.controller;

import com.example.r2dbc.entity.Employee;
import com.example.r2dbc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author rishi
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  private EmployeeRepository employeeRepository;

  @PostMapping
  public Mono<Employee> saveEmployee(@RequestBody Employee employee){
    return employeeRepository.save(employee);
  }

  @GetMapping("/{id}")
  public Mono<Employee> findOne(@PathVariable("id") Long id){
    return employeeRepository.findById(id);
  }

  @PutMapping
  public Mono<Employee> updateEmployee(@RequestBody Employee employee){
    return employeeRepository.save(employee);
  }

  @DeleteMapping("/{id}")
  public Mono<Employee> deleteEmployee(@PathVariable("id") Long id){
    return employeeRepository.findById(id)
        .doOnSuccess(employee -> employeeRepository.delete(employee).subscribe());
  }

  @GetMapping
  public Flux<Employee> findAll(){
    return employeeRepository.findAll();
  }
}
