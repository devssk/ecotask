package com.backend.ecotask.controller;

import com.backend.ecotask.dto.employees.EmployeeHistoryNowInfoDto;
import com.backend.ecotask.dto.employees.EmployeeNowInfoDto;
import com.backend.ecotask.service.EmployeesCheckService;
import com.backend.ecotask.service.EmployeesSalaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeesCheckService employeesCheckService;

    private final EmployeesSalaryService employeesSalaryService;

    @Operation(summary = "직원 현재 정보 검색", description = "", tags = {"EmployeesController"})
    @Parameter(name = "employeeId", description = "직원 PK")
    @GetMapping("/{employeeId}")
    public EmployeeNowInfoDto getEmployeeNowInfo(@PathVariable Long employeeId) {
        EmployeeNowInfoDto result = employeesCheckService.getEmployeeNowInfo(employeeId);
        return result;
    }

    @Operation(summary = "직원 이력 정보 검색", description = "", tags = {"EmployeesController"})
    @Parameter(name = "employeeId", description = "직원 PK")
    @GetMapping("/history/{employeeId}")
    public EmployeeHistoryNowInfoDto getEmployeeHistoryInfo(@PathVariable Long employeeId) {
        return employeesCheckService.getEmployeeHistoryInfo(employeeId);
    }

    @Operation(summary = "부서별 직원 급여 인상", description = "", tags = {"EmployeesController"})
    @Parameters(value = {
            @Parameter(name = "departmentId", description = "부서 PK"),
            @Parameter(name = "rate", description = "급여 인상율", example = "0.05")
    }
    )
    @PatchMapping("/department/{departmentId}")
    public void updateEmployeesSalaryInDepartment(@PathVariable Long departmentId, @RequestBody BigDecimal rate) {
        employeesSalaryService.updateEmployeesSalaryInDepartment(departmentId, rate);
    }

    @Operation(summary = "직원 급여 인상 원상 복구", description = "", tags = {"EmployeesController"})
    @PatchMapping("/salary")
    public void returnEmployeesSalaryToOriginal() {
        employeesSalaryService.returnEmployeesSalaryToOriginal();
    }

}
