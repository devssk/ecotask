package com.backend.ecotask.dto.employees;

import com.backend.ecotask.entity.Jobs;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class JobsDto {
    private String jobId;
    private String jobTitle;
    private BigDecimal minSalary;
    private BigDecimal maxSalary;
}
