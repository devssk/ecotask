package com.backend.ecotask.repository.querydsl;

import com.backend.ecotask.entity.JobHistory;

import java.util.List;
import java.util.Optional;

public interface QJobHistoryRepository {
    List<JobHistory> findFetchJobHistory(Long employeeId);
    List<JobHistory> findFetchAllJobHistory();
}
