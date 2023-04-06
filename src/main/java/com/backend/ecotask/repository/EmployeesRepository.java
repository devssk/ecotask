package com.backend.ecotask.repository;

import com.backend.ecotask.dto.EmployeeCheckDto;
import com.backend.ecotask.entity.Employees;
import com.backend.ecotask.repository.querydsl.QEmployeesRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<Employees, Long>, QEmployeesRepository {
    Optional<Employees> findByLastName(String lastName);
}
