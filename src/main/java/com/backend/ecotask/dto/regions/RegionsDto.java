package com.backend.ecotask.dto.regions;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionsDto {
    @Schema(description = "대륙 PK")
    private Long regionId;
    @Schema(description = "대륙 이름")
    private String regionName;
}
