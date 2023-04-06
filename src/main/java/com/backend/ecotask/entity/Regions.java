package com.backend.ecotask.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
public class Regions {

    @Id
    private Long RegionId;

    private String RegionName;

}
