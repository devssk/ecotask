package com.backend.ecotask.repository.querydsl;

import com.backend.ecotask.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.backend.ecotask.entity.QCountries.*;
import static com.backend.ecotask.entity.QDepartments.*;
import static com.backend.ecotask.entity.QEmployees.*;
import static com.backend.ecotask.entity.QJobs.*;
import static com.backend.ecotask.entity.QLocations.*;
import static com.backend.ecotask.entity.QRegions.*;

@Repository
public class QEmployeesRepositoryImpl implements QEmployeesRepository{

    private final JPAQueryFactory query;

    private final EntityManager em;

    public QEmployeesRepositoryImpl(EntityManager em) {
        this.query = new JPAQueryFactory(em);
        this.em = em;
    }

    QEmployees manager = new QEmployees("manager");
    QEmployees manager2 = new QEmployees("manager2");

    @Override
    public Optional<Employees> findFetchEmployee(Long employeeId) {
        Employees result = query
                .select(employees)
                .from(employees)
                .leftJoin(employees.jobs, jobs).fetchJoin()
                .leftJoin(employees.manager, manager).fetchJoin()
                .leftJoin(employees.departments, departments).fetchJoin()
                .leftJoin(departments.locations, locations).fetchJoin()
                .leftJoin(departments.manager, manager2).fetchJoin()
                .leftJoin(locations.countries, countries).fetchJoin()
                .leftJoin(countries.regions, regions).fetchJoin()
                .where(employees.employeeId.eq(employeeId))
                .fetchOne();
        return Optional.ofNullable(result);
    }
}
