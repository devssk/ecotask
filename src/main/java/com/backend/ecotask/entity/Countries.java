package com.backend.ecotask.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
public class Countries {

    @Id
    @Column(columnDefinition = "CHAR")
    private String CountryId;

    private String countryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regionId", nullable = false)
    private Regions regions;

}
