package com.backend.ecotask.dto.weather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDetailDto {
    private HeaderDto header;
    private BodyDto body;
    private Integer pageNo;
    private Integer numOfRows;
    private Integer totalCount;
}
