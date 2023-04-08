package com.backend.ecotask.dto.mapper;

import com.backend.ecotask.dto.departments.DepartmentInfoDto;
import com.backend.ecotask.entity.Departments;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper {

    DepartmentInfoDto departmentToDepartmentInfoDto(Departments departments);

}
