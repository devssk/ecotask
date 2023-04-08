package com.backend.ecotask.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Getter
public class OriginalEmployees {

    @Id
    private Long employeeId;

    private BigDecimal salary;
}
