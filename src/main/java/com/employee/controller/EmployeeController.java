package com.employee.controller;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
