package com.backend.ecotask.dto.employees;

import com.backend.ecotask.entity.Regions;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionsDto {
    private Long regionId;
    private String regionName;

    public RegionsDto(Regions regions) {
        this.regionId = regions.getRegionId();
        this.regionName = regions.getRegionName() != null ? regions.getRegionName() : "";
    }
}
