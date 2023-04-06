package com.backend.ecotask.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class JobHistoryId implements Serializable {

    @EqualsAndHashCode.Include
    public Long employees;

    @EqualsAndHashCode.Include
    public LocalDate startDate;
}
