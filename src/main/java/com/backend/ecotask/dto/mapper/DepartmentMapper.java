package com.backend.ecotask.dto.mapper;

import com.backend.ecotask.dto.departments.DepartmentsDto;
import com.backend.ecotask.entity.Departments;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper {

    DepartmentsDto departmentToDepartmentsDto(Departments departments);

}
