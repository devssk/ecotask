package com.backend.ecotask.controller;

import com.backend.ecotask.dto.weather.WeatherDto;
import com.backend.ecotask.service.WeatherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
@Transactional
public class WeatherController {

    private final WeatherService weatherService;

    @Operation(summary = "open api 이용 기상 정보 가져오기", description = "공공데이터포털의 기상정보 open api를 이용하여 기상정보를 검색합니다.", tags = {"WeatherController"})
    @Parameters(value = {
            @Parameter(name = "date", description = "알고 싶은 기상정보 날짜, 전일(D-1)까지 제공, 전일은 오전 11:00 이후 가능", example = "2023-04-08"),
            @Parameter(name = "location", description = "알고싶은 도시 (속초, 철원, 파주, 서울, 인천, 수원, 대전, 대구, 전주, 광주, 부산, 제주)", example = "서울")
    }
    )
    @GetMapping("")
    public WeatherDto getWeatherInfo(@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                             @RequestParam(value = "location") String location) {
        return weatherService.weatherTest(date, location);
    }

}
