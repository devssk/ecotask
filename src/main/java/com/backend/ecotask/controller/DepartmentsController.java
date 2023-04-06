package com.backend.ecotask.controller;

import com.backend.ecotask.dto.departments.DepartmentInfoDto;
import com.backend.ecotask.service.DepartmentsCheckService;
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

    @GetMapping("/{departmentId}")
    public DepartmentInfoDto getDepartmentInfo(@PathVariable Long departmentId) {
        return departmentsCheckService.getDepartmentInfo(departmentId);
    }

}
