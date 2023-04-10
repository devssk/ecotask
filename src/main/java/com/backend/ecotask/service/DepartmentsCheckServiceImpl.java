package com.backend.ecotask.service;

import com.backend.ecotask.dto.departments.DepartmentsDto;
import com.backend.ecotask.dto.mapper.DepartmentMapper;
import com.backend.ecotask.entity.Departments;
import com.backend.ecotask.exception.CustomException;
import com.backend.ecotask.exception.ErrorCode;
import com.backend.ecotask.repository.DepartmentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepartmentsCheckServiceImpl implements DepartmentsCheckService{

    private final DepartmentsRepository departmentsRepository;

    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentsDto getDepartmentInfo(Long departmentId) {

        Departments department = findDepartment(departmentId);

        return departmentMapper.departmentToDepartmentsDto(department);
    }

    private Departments findDepartment(Long departmentId) {
        if (departmentId == null) {
            throw new CustomException(ErrorCode.DEPARTMENT_ID_IS_NULL);
        }

        return departmentsRepository.findFetchDepartment(departmentId).orElseThrow(
                () -> new CustomException(ErrorCode.DEPARTMENT_NOT_FOUND)
        );
    }
}
