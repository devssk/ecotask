package com.backend.ecotask.service;

import com.backend.ecotask.dto.employees.EmployeeHistoryInfoDto;
import com.backend.ecotask.dto.employees.EmployeeHistoryInfoDtoMapper;
import com.backend.ecotask.dto.employees.EmployeeNowInfoDto;
import com.backend.ecotask.entity.Employees;
import com.backend.ecotask.entity.JobHistory;
import com.backend.ecotask.repository.EmployeesRepository;
import com.backend.ecotask.repository.JobHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmployeesCheckServiceImpl implements EmployeesCheckService{

    private final EmployeesRepository employeesRepository;

    private final JobHistoryRepository jobHistoryRepository;

    private final EmployeeHistoryInfoDtoMapper employeeHistoryInfoMapper;

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
    public EmployeeHistoryInfoDto getEmployeeHistoryInfo(Long employeeId) {

        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId is null");
        }

        Optional<JobHistory> findJobHistory = jobHistoryRepository.findFetchJobHistory(employeeId);

        return findJobHistory.map(employeeHistoryInfoMapper).orElse(null);


    }
}
