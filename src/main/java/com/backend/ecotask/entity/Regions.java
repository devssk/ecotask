package com.backend.ecotask.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Regions {

    @Id
    private Long RegionId;

    private String RegionName;

}
