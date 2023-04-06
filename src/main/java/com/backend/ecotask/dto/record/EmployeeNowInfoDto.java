package com.backend.ecotask.dto.record;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeNowInfoDto(
        Long employeeId,
        String firstName,
        String lastName,
        String Email,
        String phoneNumber,
        LocalDate hireDate,
        JobsDto jobs,
        BigDecimal salary,
        BigDecimal commissionPct,
        ManagerDto manager,
        DepartmentsDto departments
) {
}
