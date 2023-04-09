package com.backend.ecotask.service;

import com.backend.ecotask.dto.weather.WeatherDto;

import java.time.LocalDate;

public interface WeatherService {
    WeatherDto weatherTest(LocalDate date, String location);
}
