package com.backend.ecotask.service;

import com.backend.ecotask.dto.employees.*;
import com.backend.ecotask.dto.mapper.EmployeeMapper;
import com.backend.ecotask.entity.Employees;
import com.backend.ecotask.entity.JobHistory;
import com.backend.ecotask.repository.EmployeesRepository;
import com.backend.ecotask.repository.JobHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmployeesCheckServiceImpl implements EmployeesCheckService{

    private final EmployeesRepository employeesRepository;

    private final JobHistoryRepository jobHistoryRepository;

    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeNowInfoDto getEmployeeNowInfo(Long employeeId) {

        if (employeeId != null) {
            Optional<Employees> findEmployees = employeesRepository.findFetchEmployee(employeeId);
            if (findEmployees.isPresent()) {
                EmployeeNowInfoDto result = employeeMapper.employeesToEmployeeNowInfoDto(findEmployees.get());
                return result;
            }
        }

        return null;
    }

    @Override
    public EmployeeHistoryNowInfoDto getEmployeeHistoryInfo(Long employeeId) {

        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId is null");
        }

        Optional<Employees> findEmployee = employeesRepository.findFetchEmployee(employeeId);
        if (!findEmployee.isPresent()) {
            throw new IllegalArgumentException("employee not find");
        }

        EmployeeHistoryNowInfoDto result = employeeMapper.employeesToEmployeeHistoryNowInfoDto(findEmployee.get());

        List<JobHistory> findJobHistoryList = jobHistoryRepository.findFetchJobHistory(employeeId);
        for (JobHistory jobHistory : findJobHistoryList) {
            result.getHistory().add(employeeMapper.jobHistoryToEmployeeHistoryInfoDto(jobHistory));
        }

        return result;

    }
}
