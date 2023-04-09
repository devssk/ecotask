package com.backend.ecotask.enums;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
public enum StationCode {
    SOKCHO("속초", 90),
    CHEORWON("철원", 95),
    PAJU("파주", 99),
    SEOUL("서울", 108),
    INCHEON("인천", 112),
    SUWON("수원", 119),
    DAEJEON("대전", 133),
    DAEGU("대구", 143),
    JEONJU("전주", 146),
    GWANGJU("광주", 156),
    BUSAN("부산", 159),
    JEJU("제주", 184);

    private String location;
    private Integer code;

    public String getLocaion() {
        return location;
    }

    public Integer getCode() {
        return code;
    }

    public static StationCode find(String location) {
        Optional<StationCode> result = Arrays.stream(values()).filter(stationCode -> stationCode.getLocaion().equals(location)).findAny();
        return result.orElseThrow(
                () -> new IllegalArgumentException("station not found")
        );
    }

}
