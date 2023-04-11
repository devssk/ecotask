package com.backend.ecotask.dto.mapper;

import com.backend.ecotask.dto.employees.EmployeeHistoryInfoDto;
import com.backend.ecotask.dto.employees.EmployeeHistoryNowInfoDto;
import com.backend.ecotask.dto.employees.EmployeeNowInfoDto;
import com.backend.ecotask.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {

    EmployeeNowInfoDto employeesToEmployeeNowInfoDto(Employees employees);

    EmployeeHistoryNowInfoDto employeesToEmployeeHistoryNowInfoDto(Employees employees);

    @Mapping(target = "employeeId", source = "jobHistory.jobHistoryId.employees.employeeId")
    @Mapping(target = "startDate", source = "jobHistory.jobHistoryId.startDate")
    EmployeeHistoryInfoDto jobHistoryToEmployeeHistoryInfoDto(JobHistory jobHistory);

}
