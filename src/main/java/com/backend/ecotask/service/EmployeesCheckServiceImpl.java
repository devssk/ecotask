package com.backend.ecotask.service;

import com.backend.ecotask.dto.employees.*;
import com.backend.ecotask.dto.mapper.EmployeeMapper;
import com.backend.ecotask.entity.Employees;
import com.backend.ecotask.entity.JobHistory;
import com.backend.ecotask.exception.CustomException;
import com.backend.ecotask.exception.ErrorCode;
import com.backend.ecotask.repository.EmployeesRepository;
import com.backend.ecotask.repository.JobHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmployeesCheckServiceImpl implements EmployeesCheckService{

    private final EmployeesRepository employeesRepository;

    private final JobHistoryRepository jobHistoryRepository;

    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeNowInfoDto getEmployeeNowInfo(Long employeeId) {

        Employees findEmployee = findEmployee(employeeId);

        return employeeMapper.employeesToEmployeeNowInfoDto(findEmployee);
    }

    @Override
    public EmployeeHistoryNowInfoDto getEmployeeHistoryInfo(Long employeeId) {

        Employees findEmployee = findEmployee(employeeId);

        EmployeeHistoryNowInfoDto result = employeeMapper.employeesToEmployeeHistoryNowInfoDto(findEmployee);

        List<JobHistory> findJobHistoryList = jobHistoryRepository.findFetchJobHistory(employeeId);
        for (JobHistory jobHistory : findJobHistoryList) {
            result.getHistory().add(employeeMapper.jobHistoryToEmployeeHistoryInfoDto(jobHistory));
        }

        return result;

    }

    private Employees findEmployee(Long employeeId) {

        if (employeeId == null) {
            throw new CustomException(ErrorCode.EMPLOYEE_ID_IS_NULL);
        }

        return employeesRepository.findFetchEmployee(employeeId).orElseThrow(
                () -> new CustomException(ErrorCode.EMPLOYEE_NOT_FOUND)
        );
    }
}
