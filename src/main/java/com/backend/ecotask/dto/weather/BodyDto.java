package com.backend.ecotask.dto.weather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodyDto {
    private String dataType;
    private ItemDto items;
}
