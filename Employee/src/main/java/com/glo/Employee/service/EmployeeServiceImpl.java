package com.glo.Employee.service;

import com.glo.Employee.EmployeeDTO.PagingResponseDTO;
import com.glo.Employee.exception.EmployeeNotFoundException;
import com.glo.Employee.model.Employee;
import com.glo.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee createEmployee(Employee employee) {
      return   employeeRepository.save(employee);
    }

    @Override
    public Employee getAllEmployees() {
       return employeeRepository.findAll();

    }

    @Override
    public Employee getEmployeeById(int empid) {
        Optional<Employee> byId = employeeRepository.findById(empid);
        if(byId.isPresent()) {
            return byId.get();
        }
        else
        {
            throw new EmployeeNotFoundException("cant find the employee with this id");
        }
    }

    @Override
    public Employee updateEmployee(int empid,Employee emp) {
        Optional<Employee> em=employeeRepository.findById(empid);
        if(em.isPresent()) {
            em.get().setFirst_name(emp.getFirst_name());
            em.get().setLast_name(emp.getLast_name());
            em.get().setEmail(emp.getEmail());
            em.get().setPosition(emp.getPosition());
            em.get().setDepartment(emp.getDepartment());
            em.get().setSalary(emp.getSalary());
            em.get().setEmpId(empid);
            return employeeRepository.save(em.get());
        }
        else {
            throw new EmployeeNotFoundException("cant find the employee with this id");
        }
    }

    @Override
    public Employee deleteEmployee(int empid) {
        Optional<Employee> emp=employeeRepository.findById(empid);
        if(emp.isPresent()) {
            employeeRepository.deleteById(empid);
        }
        else
        {
            throw new EmployeeNotFoundException("cant find the employee with this id");
        }
         return emp.get();
    }
}
