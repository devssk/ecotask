package com.backend.ecotask.dto.countries;

import com.backend.ecotask.dto.regions.RegionsDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountriesDto {
    @Schema(description = "나라 PK")
    private String countryId;
    @Schema(description = "나라 이름")
    private String countryName;
    @Schema(description = "대륙 정보")
    private RegionsDto regions;
}
