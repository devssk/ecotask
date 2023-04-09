package com.backend.ecotask.service;

import com.backend.ecotask.dto.departments.DepartmentsDto;
import com.backend.ecotask.dto.mapper.DepartmentMapper;
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

    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentsDto getDepartmentInfo(Long departmentId) {

        if (departmentId == null) {
            throw new IllegalArgumentException("departmentId is null");
        }

        Optional<Departments> findDepartments = departmentsRepository.findFetchDepartment(departmentId);

        return findDepartments.map(departmentMapper::departmentToDepartmentsDto).orElseThrow(
                () -> new IllegalArgumentException("department is null")
        );
    }
}
