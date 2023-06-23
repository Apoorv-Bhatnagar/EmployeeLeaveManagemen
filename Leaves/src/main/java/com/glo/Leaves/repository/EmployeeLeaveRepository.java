package com.glo.Leaves.repository;

import com.glo.Leaves.model.EmployeeLeaves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeaves,Integer> {
}
