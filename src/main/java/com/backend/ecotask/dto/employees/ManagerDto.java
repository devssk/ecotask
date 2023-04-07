package com.backend.ecotask.dto.employees;

import com.backend.ecotask.entity.Employees;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ManagerDto {
    private Long employeeId;
    private String firstName;
    private String lastName;
}
