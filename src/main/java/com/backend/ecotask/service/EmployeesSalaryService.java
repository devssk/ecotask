package com.backend.ecotask.service;

import com.backend.ecotask.dto.employees.EmployeeSalaryRateReqDto;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface EmployeesSalaryService {
    void updateEmployeesSalaryInDepartment(Long departmentId, @Valid EmployeeSalaryRateReqDto rate);
    void returnEmployeesSalaryToOriginal();
}
