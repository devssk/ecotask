package com.backend.ecotask.controller;

import com.backend.ecotask.dto.employees.EmployeeHistoryInfoDto;
import com.backend.ecotask.dto.employees.EmployeeHistoryInfoDto2;
import com.backend.ecotask.dto.employees.EmployeeNowInfoDto;
import com.backend.ecotask.service.EmployeesCheckService;
import com.backend.ecotask.service.EmployeesSalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeesCheckService employeesCheckService;

    private final EmployeesSalaryService employeesSalaryService;

    @GetMapping("/{employeeId}")
    public EmployeeNowInfoDto getEmployeeNowInfo(@PathVariable Long employeeId) {
        EmployeeNowInfoDto result = employeesCheckService.getEmployeeNowInfo(employeeId);
        return result;
    }

    @GetMapping("/history/{employeeId}")
    public EmployeeHistoryInfoDto2 getEmployeeHistoryInfo(@PathVariable Long employeeId) {
        return employeesCheckService.getEmployeeHistoryInfo(employeeId);
    }

    @PatchMapping("/department/{departmentId}")
    public void updateEmployeesSalaryInDepartment(@PathVariable Long departmentId, @RequestBody BigDecimal rate) {
        employeesSalaryService.updateEmployeesSalaryInDepartment(departmentId, rate);
    }

}
