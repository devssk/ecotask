package com.backend.ecotask.service;

import com.backend.ecotask.dto.employees.EmployeeHistoryNowInfoDto;
import com.backend.ecotask.dto.employees.EmployeeNowInfoDto;

public interface EmployeesCheckService {
    EmployeeNowInfoDto getEmployeeNowInfo(Long employeeId);
    EmployeeNowInfoDto getEmployeeNowInfo2(Long employeeId);
    EmployeeHistoryNowInfoDto getEmployeeHistoryInfo(Long employeeId);
}
