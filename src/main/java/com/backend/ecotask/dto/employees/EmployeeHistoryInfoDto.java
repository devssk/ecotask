package com.backend.ecotask.dto.employees;

import java.time.LocalDate;

public record EmployeeHistoryInfoDto(
        Long employeeId,
        LocalDate startDate,
        LocalDate endDate,
        JobsDto jobs,
        DepartmentsDto departments
) {
}
