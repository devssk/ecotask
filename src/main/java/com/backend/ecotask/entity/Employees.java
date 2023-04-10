package com.backend.ecotask.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employees {

    @Id
    private Long employeeId;

    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    private String phoneNumber;

    @Column(nullable = false)
    private LocalDate hireDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobId", nullable = false)
    private Jobs jobs;

    @Column(nullable = false)
    private BigDecimal salary;

    private BigDecimal commissionPct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "managerId")
    private Employees manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId")
    private Departments departments;

    public void updateFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void updateLastName(String lastName) {
        this.lastName = lastName;
    }

    public void updateEmail(String email) {
        this.email = email;
    }

    public void updatePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void updateHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public void updateJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public void updateSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void updateCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

    public void updateManager(Employees manager) {
        this.manager = manager;
    }

    public void updateDepartments(Departments departments) {
        this.departments = departments;
    }

}
