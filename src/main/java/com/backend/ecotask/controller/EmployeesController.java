package com.backend.ecotask.controller;

import com.backend.ecotask.dto.EmployeeCheckDto;
import com.backend.ecotask.dto.employees.EmployeeHistoryInfoDto;
import com.backend.ecotask.dto.employees.EmployeeNowInfoDto;
import com.backend.ecotask.service.EmployeesCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeesCheckService employeesCheckService;

    @GetMapping("/{employeeId}")
    public EmployeeNowInfoDto getEmployeeNowInfo(@PathVariable Long employeeId) {
        EmployeeNowInfoDto result = employeesCheckService.getEmployeeNowInfo(employeeId);
        return result;
    }

    @GetMapping("/history/{employeeId}")
    public EmployeeHistoryInfoDto getEmployeeHistoryInfo(@PathVariable Long employeeId) {
        return employeesCheckService.getEmployeeHistoryInfo(employeeId);
    }

}
