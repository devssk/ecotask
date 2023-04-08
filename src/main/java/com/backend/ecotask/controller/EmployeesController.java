package com.backend.ecotask.controller;

import com.backend.ecotask.dto.employees.EmployeeHistoryNowInfoDto;
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

    @GetMapping("/1/{employeeId}")
    public EmployeeNowInfoDto getEmployeeNowInfo2(@PathVariable Long employeeId) {
        EmployeeNowInfoDto result = employeesCheckService.getEmployeeNowInfo2(employeeId);
        return result;
    }

    @GetMapping("/history/{employeeId}")
    public EmployeeHistoryNowInfoDto getEmployeeHistoryInfo(@PathVariable Long employeeId) {
        return employeesCheckService.getEmployeeHistoryInfo(employeeId);
    }

    @PatchMapping("/department/{departmentId}")
    public void updateEmployeesSalaryInDepartment(@PathVariable Long departmentId, @RequestBody BigDecimal rate) {
        employeesSalaryService.updateEmployeesSalaryInDepartment(departmentId, rate);
    }

    @PatchMapping("/salary")
    public void returnEmployeesSalaryToOriginal() {
        employeesSalaryService.returnEmployeesSalaryToOriginal();
    }

}
