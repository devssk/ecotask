package com.backend.ecotask.service;

import com.backend.ecotask.dto.departments.DepartmentsDto;

public interface DepartmentsCheckService {
    DepartmentsDto getDepartmentInfo(Long departmentId);
}
