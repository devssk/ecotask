package com.backend.ecotask.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@IdClass(JobHistoryId.class)
public class JobHistory {

    @Id
    @ManyToOne
    @JoinColumn(name = "employeeId", nullable = false)
    private Employees employees;

    @Id
    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobId", nullable = false)
    private Jobs jobs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId", nullable = false)
    private Departments departments;

}
