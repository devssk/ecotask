package com.backend.ecotask.service;

import com.backend.ecotask.dto.employees.EmployeeHistoryInfoDto;
import com.backend.ecotask.dto.employees.EmployeeHistoryInfoDtoMapper;
import com.backend.ecotask.entity.Employees;
import com.backend.ecotask.entity.JobHistory;
import com.backend.ecotask.entity.Jobs;
import com.backend.ecotask.entity.Locations;
import com.backend.ecotask.repository.EmployeesRepository;
import com.backend.ecotask.repository.JobHistoryRepository;
import com.backend.ecotask.repository.JobsRepository;
import com.backend.ecotask.repository.LocationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TestService {

    private final JobHistoryRepository jobHistoryRepository;
    private final EmployeesRepository employeesRepository;
    private final JobsRepository jobsRepository;
    private final LocationsRepository locationsRepository;
    private final EmployeeHistoryInfoDtoMapper employeeHistoryInfoMapper;

    public List<EmployeeHistoryInfoDto> test() {
        List<JobHistory> all = jobHistoryRepository.findAll();

        return all.stream().map(employeeHistoryInfoMapper).toList();
    }

    public List<Employees> test2() {
        List<Employees> all = employeesRepository.findAll();
        for (Employees employees : all) {
            System.out.println(employees.toString());
        }
        return all;
    }

    public List<Jobs> test3() {
        List<Jobs> all = jobsRepository.findAll();
        return all;
    }

    public List<Locations> test4() {
        List<Locations> all = locationsRepository.findAll();
        for (Locations locations : all) {
            System.out.println(locations.toString());
        }
        return all;
    }

}
