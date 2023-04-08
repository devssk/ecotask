package com.backend.ecotask.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Jobs {

    @Id
    private String jobId;

    @Column(nullable = false)
    private String jobTitle;

    private BigDecimal minSalary;

    private BigDecimal maxSalary;

}
