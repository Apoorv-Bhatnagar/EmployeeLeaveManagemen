package com.glo.Employee.EmployeeDTO;

import com.glo.Employee.model.Employee;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PagingResponseDTO {
    private int page;
    private int pageSize;
    private long totalEmployees;
    private int totalPages;
    List<Employee> employeeList;
}
