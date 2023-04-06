package com.backend.ecotask.service;

import com.backend.ecotask.dto.departments.DepartmentInfoDto;
import com.backend.ecotask.entity.Departments;
import com.backend.ecotask.repository.DepartmentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepartmentsCheckServiceImpl implements DepartmentsCheckService{

    private final DepartmentsRepository departmentsRepository;

    @Override
    public DepartmentInfoDto getDepartmentInfo(Long departmentId) {

        if (departmentId == null) {
            throw new IllegalArgumentException("departmentId is null");
        }

        Optional<Departments> findDepartments = departmentsRepository.findFetchDepartment(departmentId);

        return findDepartments.map(DepartmentInfoDto::new).orElse(null);
    }
}
