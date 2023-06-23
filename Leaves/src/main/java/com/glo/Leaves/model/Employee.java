package com.glo.Leaves.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    private int empId;
    private String first_name;
    private String last_name;
    private String email;
    private String department;
    private String position;
    private double salary;
}
