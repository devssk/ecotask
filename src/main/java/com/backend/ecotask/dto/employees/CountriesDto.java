package com.backend.ecotask.dto.employees;

import com.backend.ecotask.entity.Countries;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountriesDto {
    private String countryId;
    private String countryName;
    private RegionsDto region;

    public CountriesDto(Countries countries) {
        this.countryId = countries.getCountryId();
        this.countryName = countries.getCountryName() != null ? countries.getCountryName() : "";
        this.region = new RegionsDto(countries.getRegions());
    }
}
