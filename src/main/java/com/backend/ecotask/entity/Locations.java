package com.backend.ecotask.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
public class Locations {

    @Id
    private Long locationId;

    private String streetAddress;

    private String postalCode;

    @Column(nullable = false)
    private String city;

    private String stateProvince;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryId", nullable = false)
    private Countries countries;

}
