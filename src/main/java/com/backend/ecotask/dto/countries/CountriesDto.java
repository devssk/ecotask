package com.backend.ecotask.dto.countries;

import com.backend.ecotask.dto.regions.RegionsDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountriesDto {
    private String countryId;
    private String countryName;
    private RegionsDto regions;
}
