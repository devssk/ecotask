package com.backend.ecotask.repository.querydsl;

import com.backend.ecotask.entity.Employees;

import java.util.List;
import java.util.Optional;

public interface QEmployeesRepository {
    Optional<Employees> findFetchEmployee(Long employeeId);
    List<Employees> findFetchEmployeesInDepartment(Long departmentId);
}
