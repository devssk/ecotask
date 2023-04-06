package com.backend.ecotask.repository.querydsl;

import com.backend.ecotask.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.backend.ecotask.entity.QCountries.*;
import static com.backend.ecotask.entity.QDepartments.*;
import static com.backend.ecotask.entity.QLocations.*;
import static com.backend.ecotask.entity.QRegions.*;

@Repository
public class QDepartmentsRepositoryImpl implements QDepartmentsRepository{

    private final JPAQueryFactory query;

    private final EntityManager em;

    public QDepartmentsRepositoryImpl(EntityManager em) {
        this.query = new JPAQueryFactory(em);
        this.em = em;
    }

    QEmployees manager = new QEmployees("manager");

    @Override
    public Optional<Departments> findFetchDepartment(Long departmentId) {
        Departments result = query
                .select(departments)
                .from(departments)
                .leftJoin(departments.manager, manager).fetchJoin()
                .leftJoin(departments.locations, locations).fetchJoin()
                .leftJoin(locations.countries, countries).fetchJoin()
                .leftJoin(countries.regions, regions).fetchJoin()
                .where(departments.departmentId.eq(departmentId))
                .fetchOne();
        return Optional.ofNullable(result);
    }
}
