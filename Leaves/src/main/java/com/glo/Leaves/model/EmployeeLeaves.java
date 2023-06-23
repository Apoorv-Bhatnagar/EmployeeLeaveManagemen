package com.glo.Leaves.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class EmployeeLeaves {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Leave_Id;
    private int empId;
    private LocalDate applicationDate;
    private LocalDate leaveStartDate;
    private LocalDate leaveEndDate;
    private String leaveType;
    private String reason;
}
