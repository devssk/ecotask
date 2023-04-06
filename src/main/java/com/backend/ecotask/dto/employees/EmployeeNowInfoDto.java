package com.backend.ecotask.dto.employees;

import com.backend.ecotask.entity.Employees;
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

    public EmployeeNowInfoDto(Employees employees) {
        this.employeeId = employees.getEmployeeId();
        this.firstName = employees.getFirstName() != null ? employees.getFirstName() : "";
        this.lastName = employees.getLastName();
        this.email = employees.getEmail();
        this.phoneNumber = employees.getPhoneNumber() != null ? employees.getPhoneNumber() : "";
        this.hireDate = employees.getHireDate();
        this.jobs = new JobsDto(employees.getJobs());
        this.salary = employees.getSalary();
        this.commissionPct = employees.getCommissionPct() != null ? employees.getCommissionPct() : BigDecimal.valueOf(0);
        this.manager = employees.getManager() != null ? new ManagerDto(employees.getManager()) : null;
        this.departments = employees.getDepartments() != null ? new DepartmentsDto(employees.getDepartments()) : null;
    }
}
