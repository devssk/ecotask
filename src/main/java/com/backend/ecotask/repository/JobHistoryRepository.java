package com.backend.ecotask.repository;

import com.backend.ecotask.entity.JobHistory;
import com.backend.ecotask.entity.JobHistoryId;
import com.backend.ecotask.repository.querydsl.QJobHistoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId>, QJobHistoryRepository {
}
