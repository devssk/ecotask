package com.backend.ecotask.service;

import java.math.BigDecimal;

public interface EmployeesSalaryService {
    void updateEmployeesSalaryInDepartment(Long departmentId, BigDecimal rate);
}
