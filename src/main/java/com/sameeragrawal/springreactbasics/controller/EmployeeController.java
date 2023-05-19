package com.sameeragrawal.springreactbasics.controller;

import com.sameeragrawal.springreactbasics.exception.ResourceNotFound;
import com.sameeragrawal.springreactbasics.model.Employee;
import com.sameeragrawal.springreactbasics.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRespository;
    
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRespository.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRespository.save(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRespository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("not exist"));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRespository.findById(id)
                .orElseThrow(()->new ResourceNotFound(("not exsit")));

        updateEmployee.setFirstName((employeeDetails.getFirstName()));
        updateEmployee.setLastName((employeeDetails.getLastName()));
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRespository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRespository.findById(id)
                .orElseThrow(()-> new ResourceNotFound(("not found")));

        employeeRespository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
