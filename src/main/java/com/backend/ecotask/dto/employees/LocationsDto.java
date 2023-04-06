package com.backend.ecotask.dto.employees;

import com.backend.ecotask.entity.Locations;
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

    public LocationsDto(Locations locations) {
        this.locationId = locations.getLocationId();
        this.streetAddress = locations.getStreetAddress() != null ? locations.getStreetAddress() : "";
        this.postalCode = locations.getPostalCode() != null ? locations.getPostalCode() : "";
        this.city = locations.getCity();
        this.stateProvince = locations.getStateProvince() != null ? locations.getStateProvince() : "";
        this.countries = new CountriesDto(locations.getCountries());
    }
}
