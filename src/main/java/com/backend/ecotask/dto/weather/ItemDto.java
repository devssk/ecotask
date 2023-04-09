package com.backend.ecotask.dto.weather;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemDto {
    private List<ItemDetailDto> item;
}
