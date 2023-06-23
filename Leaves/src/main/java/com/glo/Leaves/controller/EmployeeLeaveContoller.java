package com.glo.Leaves.controller;

import com.glo.Leaves.model.Employee;
import com.glo.Leaves.model.EmployeeLeaves;
import com.glo.Leaves.model.ResponseDTO;
import com.glo.Leaves.service.EmployeeLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeLeaveContoller {
@Autowired
private EmployeeLeaveService employeeLeaveService;
    @PostMapping("/apii/employees/leaves")
    public ResponseEntity<EmployeeLeaves> addLeave(@RequestBody EmployeeLeaves employeeLeaves)
    {
        EmployeeLeaves employeeLeave = employeeLeaveService.createEmployeeLeave(employeeLeaves);
         return new ResponseEntity<>(employeeLeave, HttpStatus.CREATED);
    }
    @GetMapping("/apii/employees/leaves/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeeByEmpId(@PathVariable int empId)
    {
        ResponseDTO allEmployeeLeavesByEmpId = employeeLeaveService.getAllEmployeeLeavesByEmpId(empId);
        return new ResponseEntity<>(allEmployeeLeavesByEmpId,HttpStatus.OK);

    }
    @GetMapping("/apii/employees/leaves/details/{leaveId}")
    public ResponseEntity<Employee> getEmployeeByLeaveId(@PathVariable int leaveId)
    {
        Employee employeeByLeaveId = employeeLeaveService.getEmployeeByLeaveId(leaveId);
        return new ResponseEntity<>(employeeByLeaveId,HttpStatus.OK);

    }

}
