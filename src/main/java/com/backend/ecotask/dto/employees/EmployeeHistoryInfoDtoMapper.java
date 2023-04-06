package com.backend.ecotask.dto.employees;

import com.backend.ecotask.entity.JobHistory;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class EmployeeHistoryInfoDtoMapper implements Function<JobHistory, EmployeeHistoryInfoDto> {

    @Override
    public EmployeeHistoryInfoDto apply(JobHistory jobHistory) {
        return new EmployeeHistoryInfoDto(
                jobHistory.getJobHistoryId().getEmployees().getEmployeeId(),
                jobHistory.getJobHistoryId().getStartDate(),
                jobHistory.getEndDate(),
                new JobsDto(jobHistory.getJobs()),
                new DepartmentsDto(jobHistory.getDepartments())
        );
    }

}
