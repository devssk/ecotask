package com.backend.ecotask.repository.querydsl;

import com.backend.ecotask.entity.JobHistory;

import java.util.Optional;

public interface QJobHistoryRepository {
    Optional<JobHistory> findFetchJobHistory(Long employeeId);
}
