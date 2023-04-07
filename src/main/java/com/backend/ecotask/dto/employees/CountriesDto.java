package com.backend.ecotask.dto.employees;

import com.backend.ecotask.entity.Countries;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CountriesDto {
    private String countryId;
    private String countryName;
    private RegionsDto regions;
}
