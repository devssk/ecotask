package com.backend.ecotask.dto.employees;

import com.backend.ecotask.dto.Jobs.JobsDto;
import com.backend.ecotask.dto.departments.DepartmentsDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeNowInfoDto {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate hireDate;
    private JobsDto jobs;
    private BigDecimal salary;
    private BigDecimal commissionPct;
    private ManagerDto manager;
    private DepartmentsDto departments;
}
