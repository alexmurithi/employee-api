package com.employee.controller;

import com.employee.exception.ResourceNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    //GET A LIST OF EMPLOYEES
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //CREATE A NEW EMPLOYEE
    @PostMapping(path = "/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //GET EMPLOYEE BY ID
    @GetMapping(path = "employees/{id}")
    public ResponseEntity <Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee does not exist with id: "+ id));
        return ResponseEntity.ok(employee);
    }
}
