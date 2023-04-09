package com.backend.ecotask.dto.employees;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagerDto {
    @Schema(description = "관리자 PK")
    private Long employeeId;
    @Schema(description = "이름")
    private String firstName;
    @Schema(description = "성")
    private String lastName;
}
