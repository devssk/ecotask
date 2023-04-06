package com.backend.ecotask.dto.employees;

import java.time.LocalDate;
import java.util.List;

public record EmployeeHistoryInfoDto2(
        Long employeeId,
        String firstName,
        String lastName,
        LocalDate hireDate,
        JobsDto jobs,
        DepartmentsDto departments,
        List<EmployeeHistoryInfoDto> history
) {
}
