package com.glo.Employee.controller;

import com.glo.Employee.EmployeeDTO.PagingResponseDTO;
import com.glo.Employee.model.Employee;
import com.glo.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/api/employees")
    public ResponseEntity<Employee> createEmployee( @RequestBody Employee emp)
    {
        Employee employee = employeeService.createEmployee(emp);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }
    @GetMapping("/api/employees")
    public ResponseEntity<Employee> getAllEmployees()
    {
        Employee allEmployees = employeeService.getAllEmployees();
        return new ResponseEntity<>(allEmployees,HttpStatus.OK);
    }
    @GetMapping("/api/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
    {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @DeleteMapping("/api/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id)
    {
        Employee employee = employeeService.deleteEmployee(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    //@PutMapping("/api/employees/{id}")
    @RequestMapping(value = "api/employees/{id}",
            produces = "application/json",
            method=RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee emp)
    {
        Employee employee = employeeService.updateEmployee(id, emp);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

   
}
