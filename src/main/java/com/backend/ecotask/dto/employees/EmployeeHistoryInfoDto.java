package com.backend.ecotask.dto.employees;

import com.backend.ecotask.dto.Jobs.JobsDto;
import com.backend.ecotask.dto.departments.DepartmentsDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeHistoryInfoDto {
    @Schema(description = "직원 PK")
    private Long employeeId;
    @Schema(description = "직업 시작 날짜")
    private LocalDate startDate;
    @Schema(description = "직업 끝 날짜")
    private LocalDate endDate;
    @Schema(description = "직업 정보")
    private JobsDto jobs;
    @Schema(description = "부서 정보")
    private DepartmentsDto departments;
}
