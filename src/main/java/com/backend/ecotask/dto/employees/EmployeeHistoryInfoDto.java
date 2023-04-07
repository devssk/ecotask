package com.backend.ecotask.dto.employees;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeHistoryInfoDto {
    private Long employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private JobsDto jobs;
    private DepartmentsDto departments;
}
