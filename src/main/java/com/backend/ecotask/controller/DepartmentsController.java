package com.backend.ecotask.controller;

import com.backend.ecotask.dto.departments.DepartmentsDto;
import com.backend.ecotask.service.DepartmentsCheckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentsController {

    private final DepartmentsCheckService departmentsCheckService;

    @Operation(summary = "부서 검색", description = "", tags = {"DepartmentsController"})
    @Parameter(name = "departmentId", description = "부서 PK")
    @GetMapping("/{departmentId}")
    public DepartmentsDto getDepartmentInfo(

            @PathVariable Long departmentId) {
        return departmentsCheckService.getDepartmentInfo(departmentId);
    }

}
