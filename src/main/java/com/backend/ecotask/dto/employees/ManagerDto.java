package com.backend.ecotask.dto.employees;

import com.backend.ecotask.entity.Employees;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagerDto {
    private Long employeeId;
    private String firstName;
    private String lastName;

    public ManagerDto(Employees manager) {
        this.employeeId = manager.getEmployeeId();
        this.firstName = manager.getFirstName();
        this.lastName = manager.getLastName();
    }
}
