package com.backend.ecotask.service;

import com.backend.ecotask.dto.departments.DepartmentInfoDto;

public interface DepartmentsCheckService {
    DepartmentInfoDto getDepartmentInfo(Long departmentId);
}
