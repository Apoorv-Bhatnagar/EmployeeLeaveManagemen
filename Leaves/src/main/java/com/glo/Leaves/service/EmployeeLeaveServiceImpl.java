package com.glo.Leaves.service;
import com.glo.Leaves.model.Employee;
import com.glo.Leaves.model.EmployeeLeaves;
import com.glo.Leaves.model.ResponseDTO;
import com.glo.Leaves.repository.EmployeeLeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService{
    @Autowired
    private RestTemplate restTemplate;
    private final String ROOT_URI = "http://localhost:8081";

    @Autowired
    private EmployeeLeaveRepository employeeLeaveRepository;

    @Override
    public EmployeeLeaves createEmployeeLeave(EmployeeLeaves employeeLeaves) {
        EmployeeLeaves save = employeeLeaveRepository.save(employeeLeaves);
        return save;
    }

    @Override
    public Employee getEmployeeByLeaveId(int leaveID) {
        Optional<EmployeeLeaves> byId = employeeLeaveRepository.findById(leaveID);
        if(byId.isPresent())
        {
            int empId=byId.get().getEmpId();
            ResponseEntity<Employee> forEntity = restTemplate.getForEntity(ROOT_URI + "/api/employees/" + empId, Employee.class);
            Employee body = forEntity.getBody();
            return body;
        }
        return null;

    }

    @Override
    public ResponseDTO getAllEmployeeLeavesByEmpId(int empId) {
        ResponseDTO responseDto = new ResponseDTO();
        ResponseEntity<Employee> forEntity = restTemplate.getForEntity(ROOT_URI + "/api/employees/" + empId, Employee.class);
        Employee emp=forEntity.getBody();
        ResponseDTO responseDTO = setEmployeeDetails(emp, responseDto);
        List<EmployeeLeaves> allLeaves = employeeLeaveRepository.findAll();
        List<EmployeeLeaves> allFilteredLeaves = allLeaves.stream().filter(e -> e.getEmpId() == empId).collect(Collectors.toList());
        responseDTO.setEmployeeLeavesList(allFilteredLeaves);
        return responseDTO;
    }

    private ResponseDTO setEmployeeDetails(Employee emp,ResponseDTO responseDTO) {
    responseDTO.setEmpId(emp.getEmpId());
    responseDTO.setFirst_name(emp.getFirst_name());
    responseDTO.setLast_name(emp.getLast_name());
    responseDTO.setEmail(emp.getEmail());
    responseDTO.setDepartment(emp.getDepartment());
    responseDTO.setPosition(emp.getPosition());
    responseDTO.setSalary(emp.getSalary());
    return responseDTO;
    }
}
