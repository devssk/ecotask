package com.backend.ecotask.dto.employees;

import com.backend.ecotask.entity.Departments;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentsDto {
    private Long departmentId;
    private String departmentName;
    private ManagerDto manager;
    private LocationsDto locations;

    public DepartmentsDto(Departments departments) {
        this.departmentId = departments.getDepartmentId();
        this.departmentName = departments.getDepartmentName();
        this.manager = departments.getManager() != null ? new ManagerDto(departments.getManager()) : null;
        this.locations = departments.getLocations() != null ? new LocationsDto(departments.getLocations()) : null;
    }
}
