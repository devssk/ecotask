package com.backend.ecotask.dto.employees;

import com.backend.ecotask.dto.Jobs.JobsDto;
import com.backend.ecotask.dto.departments.DepartmentsDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeNowInfoDto {
    @Schema(description = "직원 PK")
    private Long employeeId;
    @Schema(description = "이름")
    private String firstName;
    @Schema(description = "성")
    private String lastName;
    @Schema(description = "이메일")
    private String email;
    @Schema(description = "폰 전화번호")
    private String phoneNumber;
    @Schema(description = "고용 날짜")
    private LocalDate hireDate;
    @Schema(description = "직업 정보")
    private JobsDto jobs;
    @Schema(description = "연봉")
    private BigDecimal salary;
    @Schema(description = "성과급 퍼센트")
    private BigDecimal commissionPct;
    @Schema(description = "관리자 정보")
    private ManagerDto manager;
    @Schema(description = "부서 정보")
    private DepartmentsDto departments;
}
