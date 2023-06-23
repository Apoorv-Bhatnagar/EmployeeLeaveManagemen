package com.glo.Employee.service;

import com.glo.Employee.EmployeeDTO.PagingResponseDTO;
import com.glo.Employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee getAllEmployees();
    Employee getEmployeeById(int empid);
    Employee updateEmployee(int empid,Employee emp);
    Employee deleteEmployee(int empid);
}
