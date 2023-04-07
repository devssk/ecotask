package com.backend.ecotask.dto.employees;

import com.backend.ecotask.entity.Locations;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
