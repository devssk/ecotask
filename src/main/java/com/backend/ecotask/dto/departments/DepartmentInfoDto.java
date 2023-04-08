package com.backend.ecotask.dto.departments;

import com.backend.ecotask.dto.locations.LocationsDto;
import com.backend.ecotask.dto.employees.ManagerDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentInfoDto {
    private Long departmentId;
    private String departmentName;
    private ManagerDto manager;
    private LocationsDto locations;
}
