package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeservice;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeservice) {
        employeeservice = theEmployeeservice;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeservice.findAll();
    }

    //add mapping for GET/employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeservice.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }

    //add mapping for POST/employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        //also just in case they pass id in JSON...set id to 0
        //force save of a new item instead of update
        theEmployee.setId(0);
        Employee dbEmployee = employeeservice.save(theEmployee);
        return dbEmployee;
    }

    //add mapping for PUT/employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeservice.save(theEmployee);
        return dbEmployee;
    }

    //add mapping for DELETE/employees/{employeeId}
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee dbEmployee = employeeservice.findById(employeeId);
        //throw exception if null
        if (dbEmployee == null) {
            throw new RuntimeException("Employee not found for id" + employeeId);
        }
        employeeservice.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }
}
