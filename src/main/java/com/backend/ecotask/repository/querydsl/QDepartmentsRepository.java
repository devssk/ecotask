package com.backend.ecotask.repository.querydsl;

import com.backend.ecotask.entity.Departments;

import java.util.Optional;

public interface QDepartmentsRepository {
    Optional<Departments> findFetchDepartment(Long departmentId);
}
