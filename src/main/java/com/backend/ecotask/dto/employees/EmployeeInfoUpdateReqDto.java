package com.backend.ecotask.dto.employees;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeInfoUpdateReqDto {
    @Size(max = 20)
    @Schema(description = "이름", maxLength = 20)
    private String firstName;
    @NotBlank
    @Size(max = 25)
    @Schema(description = "성", maxLength = 25)
    private String lastName;
    @NotBlank
    @Size(max = 25)
    @Schema(description = "이메일", maxLength = 25)
    private String email;
    @Size(max = 20)
    @Schema(description = "폰 전화번호", maxLength = 20)
    private String phoneNumber;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Schema(description = "고용 날짜")
    private LocalDate hireDate;
    @NotBlank
    @Size(max = 10)
    @Schema(description = "직업 ID", maxLength = 10)
    private String jobId;
    @NotNull
    @Schema(description = "연봉")
    private BigDecimal salary;
    @Schema(description = "성과급 퍼센트")
    private BigDecimal commissionPct;
    @Schema(description = "관리자 직원 ID")
    private Long managerId;
    @Schema(description = "부서 ID")
    private Long departmentId;
}
