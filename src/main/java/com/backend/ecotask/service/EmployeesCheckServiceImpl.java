package com.backend.ecotask.service;

import com.backend.ecotask.dto.employees.*;
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

    private final EmployeeHistoryInfoDtoMapper employeeHistoryInfoMapper;

    private final EmployeeHistoryInfoDto2Mapper employeeHistoryInfoDto2Mapper;

    @Override
    public EmployeeNowInfoDto getEmployeeNowInfo(Long employeeId) {

        if (employeeId != null) {
            Optional<Employees> findEmployees = employeesRepository.findFetchEmployee(employeeId);
            if (findEmployees.isPresent()) {
                System.out.println(findEmployees.get().toString());
//                EmployeeNowInfoDto result = modelMapper.map(findEmployees.get(), EmployeeNowInfoDto.class);
                EmployeeNowInfoDto result = new EmployeeNowInfoDto(findEmployees.get());
                System.out.println(result.toString());
                return result;
            }
        }

//        if (lastName != null) {
//            Optional<Employees> findEmployees = employeesRepository.findByLastName(lastName);
//            if (findEmployees.isPresent()) {
//                EmployeeCheckDto.HistoryInfoRes result = modelMapper.map(findEmployees.get(), EmployeeCheckDto.HistoryInfoRes.class);
//                System.out.println(result.toString());
//            }
//        }

        return null;
    }

    @Override
    public EmployeeHistoryInfoDto2 getEmployeeHistoryInfo(Long employeeId) {

        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId is null");
        }

        Optional<Employees> findEmployee = employeesRepository.findFetchEmployee(employeeId);
        if (!findEmployee.isPresent()) {
            throw new IllegalArgumentException("employee not find");
        }

        EmployeeHistoryInfoDto2 result = employeeHistoryInfoDto2Mapper.apply(findEmployee.get());

        List<JobHistory> findJobHistoryList = jobHistoryRepository.findFetchJobHistory(employeeId);
        for (JobHistory jobHistory : findJobHistoryList) {
            result.history().add(employeeHistoryInfoMapper.apply(jobHistory));
        }

        return result;

    }
}
