package com.backend.ecotask.dto.weather;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class WeatherDto {
    @Schema(description = "평균 기온")
    private BigDecimal avgTa;
    @Schema(description = "최저 기온")
    private BigDecimal minTa;
    @Schema(description = "최저 기온 시각")
    private LocalTime minTaHrmt;
    @Schema(description = "최고 기온")
    private BigDecimal maxTa;
    @Schema(description = "최고 기온 시각")
    private LocalTime maxTaHrmt;
    @Schema(description = "강수량")
    private Integer sumRn;
}
