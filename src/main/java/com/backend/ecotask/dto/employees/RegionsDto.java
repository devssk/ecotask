package com.backend.ecotask.dto.employees;

import com.backend.ecotask.entity.Regions;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class RegionsDto {
    private Long regionId;
    private String regionName;
}
