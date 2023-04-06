package com.backend.ecotask.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;

@Entity
@Getter
@Immutable
public class EmpDetailsView {

    @Id
    private Long employeeId;

    private String jobId;

    private Long managerId;

    private Long departmentId;

    private Long locationId;

    @Column(columnDefinition = "CHAR")
    private String countryId;

    private String firstName;

    private String lastName;

    private BigDecimal salary;

    private BigDecimal commissionPct;

    private String departmentName;

    private String jobTitle;

    private String city;

    private String stateProvince;

    private String countryName;

    private String regionName;

}
