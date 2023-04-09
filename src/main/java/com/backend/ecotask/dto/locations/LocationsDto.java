package com.backend.ecotask.dto.locations;

import com.backend.ecotask.dto.countries.CountriesDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationsDto {
    @Schema(description = "장소 PK")
    private Long locationId;
    @Schema(description = "도로주소")
    private String streetAddress;
    @Schema(description = "우편번호")
    private String postalCode;
    @Schema(description = "도시이름")
    private String city;
    @Schema(description = "도 또는 주 이름")
    private String stateProvince;
    @Schema(description = "나라 정보")
    private CountriesDto countries;
}
