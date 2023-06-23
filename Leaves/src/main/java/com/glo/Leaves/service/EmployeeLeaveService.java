package com.glo.Leaves.service;

import com.glo.Leaves.model.Employee;
import com.glo.Leaves.model.EmployeeLeaves;
import com.glo.Leaves.model.ResponseDTO;

public interface EmployeeLeaveService {
    EmployeeLeaves createEmployeeLeave(EmployeeLeaves employeeLeaves);
    Employee getEmployeeByLeaveId(int leaveID);
    ResponseDTO getAllEmployeeLeavesByEmpId(int empId);

}
