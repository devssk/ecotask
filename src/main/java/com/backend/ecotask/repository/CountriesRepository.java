package com.backend.ecotask.repository;

import com.backend.ecotask.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepository extends JpaRepository<Countries, String> {
}
