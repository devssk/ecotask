package com.backend.ecotask.dto.employees;

import com.backend.ecotask.dto.Jobs.JobsDto;
import com.backend.ecotask.dto.departments.DepartmentsDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EmployeeHistoryNowInfoDto {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate hireDate;
    private JobsDto jobs;
    private DepartmentsDto departments;
    private List<EmployeeHistoryInfoDto> history = new ArrayList<>();
}
