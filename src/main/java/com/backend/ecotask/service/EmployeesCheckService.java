package com.backend.ecotask.service;

import com.backend.ecotask.dto.employees.EmployeeHistoryInfoDto;
import com.backend.ecotask.dto.employees.EmployeeNowInfoDto;

public interface EmployeesCheckService {
    EmployeeNowInfoDto getEmployeeNowInfo(Long employeeId);
    EmployeeHistoryInfoDto getEmployeeHistoryInfo(Long employeeId);
}
