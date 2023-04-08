package com.backend.ecotask.dto.locations;

import com.backend.ecotask.dto.countries.CountriesDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationsDto {
    private Long locationId;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private CountriesDto countries;
}
