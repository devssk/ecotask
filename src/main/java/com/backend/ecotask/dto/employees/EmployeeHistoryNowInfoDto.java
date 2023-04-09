package com.backend.ecotask.dto.employees;

import com.backend.ecotask.dto.Jobs.JobsDto;
import com.backend.ecotask.dto.departments.DepartmentsDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EmployeeHistoryNowInfoDto {
    @Schema(description = "직원 PK")
    private Long employeeId;
    @Schema(description = "이름")
    private String firstName;
    @Schema(description = "성")
    private String lastName;
    @Schema(description = "고용 날짜")
    private LocalDate hireDate;
    @Schema(description = "직업 정보")
    private JobsDto jobs;
    @Schema(description = "부서 정보")
    private DepartmentsDto departments;
    @Schema(description = "이력 정보 리스트")
    private List<EmployeeHistoryInfoDto> history = new ArrayList<>();
}
