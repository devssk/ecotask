package com.backend.ecotask.repository.querydsl;

import com.backend.ecotask.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.backend.ecotask.entity.QDepartments.*;
import static com.backend.ecotask.entity.QEmployees.*;
import static com.backend.ecotask.entity.QJobHistory.*;
import static com.backend.ecotask.entity.QJobs.*;

@Repository
public class QJobHistoryRepositoryImpl implements QJobHistoryRepository{

    private final JPAQueryFactory query;

    private final EntityManager em;

    public QJobHistoryRepositoryImpl(EntityManager em) {
        this.query = new JPAQueryFactory(em);
        this.em = em;
    }

    @Override
    public Optional<JobHistory> findFetchJobHistory(Long employeeId) {
        JobHistory result = query
                .select(jobHistory)
                .from(jobHistory)
                .leftJoin(jobHistory.employees, employees).fetchJoin()
                .leftJoin(jobHistory.jobs, jobs).fetchJoin()
                .leftJoin(jobHistory.departments, departments).fetchJoin()
                .where(jobHistory.employees.employeeId.eq(employeeId))
                .fetchOne();
        return Optional.ofNullable(result);
    }
}
