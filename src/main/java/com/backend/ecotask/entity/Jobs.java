package com.backend.ecotask.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Getter
public class Jobs {

    @Id
    private String jobId;

    @Column(nullable = false)
    private String jobTitle;

    private BigDecimal minSalary;

    private BigDecimal maxSalary;

}
