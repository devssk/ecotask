package com.backend.ecotask.dto.employees;

import com.backend.ecotask.entity.Departments;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class DepartmentsDto {
    private Long departmentId;
    private String departmentName;
    private ManagerDto manager;
    private LocationsDto locations;
}
