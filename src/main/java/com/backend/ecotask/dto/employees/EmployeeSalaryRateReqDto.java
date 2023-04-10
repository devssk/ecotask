package com.backend.ecotask.dto.employees;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EmployeeSalaryRateReqDto {
    @NotNull
    private BigDecimal rate;
}
