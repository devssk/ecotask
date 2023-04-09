package com.backend.ecotask.dto.departments;

import com.backend.ecotask.dto.locations.LocationsDto;
import com.backend.ecotask.dto.employees.ManagerDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentsDto {
    @Schema(description = "부서 PK")
    private Long departmentId;
    @Schema(description = "부서 이름")
    private String departmentName;
    @Schema(description = "관리자 정보")
    private ManagerDto manager;
    @Schema(description = "장소 정보")
    private LocationsDto locations;
}
