package com.backend.ecotask.controller;

import com.backend.ecotask.dto.employees.EmployeeHistoryNowInfoDto;
import com.backend.ecotask.dto.employees.EmployeeInfoUpdateReqDto;
import com.backend.ecotask.dto.employees.EmployeeNowInfoDto;
import com.backend.ecotask.dto.employees.EmployeeSalaryRateReqDto;
import com.backend.ecotask.service.EmployeesCheckService;
import com.backend.ecotask.service.EmployeesInfoUpdateService;
import com.backend.ecotask.service.EmployeesSalaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeesCheckService employeesCheckService;

    private final EmployeesSalaryService employeesSalaryService;

    private final EmployeesInfoUpdateService employeesInfoUpdateService;

    @Operation(summary = "직원 현재 정보 검색", description = "직원의 현재 정보를 검색합니다.", tags = {"EmployeesController"})
    @Parameter(name = "employeeId", description = "직원 PK")
    @GetMapping("/{employeeId}")
    public EmployeeNowInfoDto getEmployeeNowInfo(@PathVariable Long employeeId) {
        EmployeeNowInfoDto result = employeesCheckService.getEmployeeNowInfo(employeeId);
        return result;
    }

    @Operation(summary = "직원 정보 업데이트", description = "직원의 정보를 변경합니다.", tags = {"EmployeesController"})
    @Parameter(name = "employeeId", description = "직원 PK")
    @PatchMapping("/{employeeId}")
    public Long updateEmployeeInfo(@PathVariable Long employeeId, @RequestBody EmployeeInfoUpdateReqDto requestDto) {
        return employeesInfoUpdateService.updateEmployeeInfo(employeeId, requestDto);
    }

    @Operation(summary = "직원 이력 정보 검색", description = "직원의 이력 정보를 검색합니다.", tags = {"EmployeesController"})
    @Parameter(name = "employeeId", description = "직원 PK")
    @GetMapping("/history/{employeeId}")
    public EmployeeHistoryNowInfoDto getEmployeeHistoryInfo(@PathVariable Long employeeId) {
        return employeesCheckService.getEmployeeHistoryInfo(employeeId);
    }

    @Operation(summary = "부서별 직원 급여 인상", description = "부서별 직원의 급여를 특정 비율로 모두 인상합니다.", tags = {"EmployeesController"})
    @Parameter(name = "departmentId", description = "부서 PK")
    @PatchMapping("/department/{departmentId}")
    public void updateEmployeesSalaryInDepartment(@PathVariable Long departmentId, @RequestBody EmployeeSalaryRateReqDto rate) {
        employeesSalaryService.updateEmployeesSalaryInDepartment(departmentId, rate);
    }

    @Operation(summary = "부서별 급여 인상 원상 복구", description = "모든 직원의 급여를 전부 처음으로 되돌립니다.", tags = {"EmployeesController"})
    @PatchMapping("/salary")
    public void returnEmployeesSalaryToOriginal() {
        employeesSalaryService.returnEmployeesSalaryToOriginal();
    }

}
