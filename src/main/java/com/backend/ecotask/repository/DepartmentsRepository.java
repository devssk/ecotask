package com.backend.ecotask.repository;

import com.backend.ecotask.entity.Departments;
import com.backend.ecotask.repository.querydsl.QDepartmentsRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentsRepository extends JpaRepository<Departments, Long>, QDepartmentsRepository {
}
