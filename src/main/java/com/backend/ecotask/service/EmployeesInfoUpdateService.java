package com.backend.ecotask.service;

import com.backend.ecotask.dto.employees.EmployeeInfoUpdateReqDto;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface EmployeesInfoUpdateService {
    Long updateEmployeeInfo(Long employeeId, @Valid EmployeeInfoUpdateReqDto requestDto);
}
