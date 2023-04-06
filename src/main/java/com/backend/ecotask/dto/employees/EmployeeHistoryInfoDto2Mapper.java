package com.backend.ecotask.dto.employees;

import com.backend.ecotask.entity.Employees;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.function.Function;

@Component
public class EmployeeHistoryInfoDto2Mapper implements Function<Employees, EmployeeHistoryInfoDto2> {

    @Override
    public EmployeeHistoryInfoDto2 apply(Employees employees) {
        return new EmployeeHistoryInfoDto2(
                employees.getEmployeeId(),
                employees.getFirstName(),
                employees.getLastName(),
                employees.getHireDate(),
                new JobsDto(employees.getJobs()),
                new DepartmentsDto(employees.getDepartments()),
                new ArrayList<>()
        );
    }
}
