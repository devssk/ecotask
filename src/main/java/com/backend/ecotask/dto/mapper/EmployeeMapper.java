package com.backend.ecotask.dto.mapper;

import com.backend.ecotask.dto.employees.EmployeeHistoryInfoDto;
import com.backend.ecotask.dto.employees.EmployeeHistoryNowInfoDto;
import com.backend.ecotask.dto.employees.EmployeeNowInfoDto;
import com.backend.ecotask.entity.*;
import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
@Transactional(readOnly = true)
public interface EmployeeMapper extends LazyLoadingAwareMapper {

    EmployeeNowInfoDto employeesToEmployeeNowInfoDto(Employees employees);

    EmployeeHistoryNowInfoDto employeesToEmployeeHistoryNowInfoDto(Employees employees);

    @Mapping(target = "employeeId", source = "jobHistory.jobHistoryId.employees.employeeId")
    @Mapping(target = "startDate", source = "jobHistory.jobHistoryId.startDate")
    EmployeeHistoryInfoDto jobHistoryToEmployeeHistoryInfoDto(JobHistory jobHistory);

    @Condition
    default boolean isNotLazyLoadedJobs(Collection<Jobs> sourceCollection) {
        return isNotLazyLoaded(sourceCollection);
    }

    @Condition
    default boolean isNotLazyLoadedDepartments(Collection<Departments> sourceCollection) {
        return isNotLazyLoaded(sourceCollection);
    }

    @Condition
    default boolean isNotLazyLoadedLocations(Collection<Locations> sourceCollection) {
        return isNotLazyLoaded(sourceCollection);
    }

    @Condition
    default boolean isNotLazyLoadedCountries(Collection<Countries> sourceCollection) {
        return isNotLazyLoaded(sourceCollection);
    }

    @Condition
    default boolean isNotLazyLoadedRegions(Collection<Regions> sourceCollection) {
        return isNotLazyLoaded(sourceCollection);
    }

}
