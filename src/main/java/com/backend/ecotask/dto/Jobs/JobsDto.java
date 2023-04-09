package com.backend.ecotask.dto.Jobs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class JobsDto {
    @Schema(description = "직업 PK")
    private String jobId;
    @Schema(description = "직업 이름")
    private String jobTitle;
    @Schema(description = "최저 연봉")
    private BigDecimal minSalary;
    @Schema(description = "최대 연봉")
    private BigDecimal maxSalary;
}
