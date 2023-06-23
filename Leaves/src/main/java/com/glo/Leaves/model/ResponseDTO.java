package com.glo.Leaves.model;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseDTO {
    private int empId;
    private String first_name;
    private String last_name;
    private String email;
    private String department;
    private String position;
    private double salary;
    List<EmployeeLeaves> employeeLeavesList;
}
