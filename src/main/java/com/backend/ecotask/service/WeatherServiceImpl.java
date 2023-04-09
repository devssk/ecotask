package com.backend.ecotask.service;

import com.backend.ecotask.dto.weather.ResponseDto;
import com.backend.ecotask.dto.weather.WeatherDto;
import com.backend.ecotask.enums.StationCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherServiceImpl implements WeatherService{

    private final WebClient webClient;

    @Value("${publicData.service-key}")
    String SERVICE_KEY;

    @Override
    public WeatherDto weatherTest(LocalDate date, String location) {
        if (date == null) {
            throw new IllegalArgumentException("date is null");
        }
        if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("dont now tomorrow");
        }
        if (date.isEqual(LocalDate.now())) {
            throw new IllegalArgumentException("available from the previous day");
        }
        if (date.isEqual(LocalDate.now().minusDays(1))) {
            if (LocalTime.now().isBefore(LocalTime.of(11,0))) {
                throw new IllegalArgumentException("yesterday is available after am 11:00");
            }
        }

        String stringDate = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        StationCode stationCode = StationCode.find(location);

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("apis.data.go.kr")
                .path("/1360000/AsosDalyInfoService/getWthrDataList")
                .queryParam("serviceKey", SERVICE_KEY)
                .queryParam("numOfRows", 10)
                .queryParam("dataType", "JSON")
                .queryParam("pageNo", 1)
                .queryParam("dataCd", "ASOS")
                .queryParam("dateCd", "DAY")
                .queryParam("startDt", stringDate)
                .queryParam("endDt", stringDate)
                .queryParam("stnIds", stationCode.getCode())
                .build(true);

        ResponseDto response = webClient.get()
                .uri(uri.toString())
                .retrieve()
                .bodyToMono(ResponseDto.class)
                .block();

        if (response == null) {
            throw new IllegalArgumentException("open api response failed");
        }

        if (!response.getResponse().getHeader().getResultCode().equals("00")) {
            log.info("open api 에러");
            throw new IllegalArgumentException("open api error");
        }

        return new WeatherDto(
                new BigDecimal(response.getResponse().getBody().getItems().getItem().get(0).getAvgTa()),
                new BigDecimal(response.getResponse().getBody().getItems().getItem().get(0).getMinTa()),
                LocalTime.parse(response.getResponse().getBody().getItems().getItem().get(0).getMinTaHrmt(), DateTimeFormatter.ofPattern("HHmm")),
                new BigDecimal(response.getResponse().getBody().getItems().getItem().get(0).getMaxTa()),
                LocalTime.parse(response.getResponse().getBody().getItems().getItem().get(0).getMaxTaHrmt(), DateTimeFormatter.ofPattern("HHmm")),
                !response.getResponse().getBody().getItems().getItem().get(0).getSumRn().equals("") ? Integer.parseInt(response.getResponse().getBody().getItems().getItem().get(0).getSumRn()) : 0
        );
    }

}
