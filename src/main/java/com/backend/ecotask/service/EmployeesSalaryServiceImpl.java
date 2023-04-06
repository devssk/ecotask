package com.backend.ecotask.service;

import com.backend.ecotask.entity.Employees;
import com.backend.ecotask.repository.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeesSalaryServiceImpl implements EmployeesSalaryService{

    private final EmployeesRepository employeesRepository;

    @Override
    public void updateEmployeesSalaryInDepartment(Long departmentId, BigDecimal rate) {
        List<Employees> findEmployeesList = employeesRepository.findFetchEmployeesInDepartment(departmentId);
        for (Employees employees : findEmployeesList) {
            BigDecimal maxSalary = employees.getJobs().getMaxSalary();
            BigDecimal salary = employees.getSalary().add(employees.getSalary().multiply(rate));
            if (salary.compareTo(maxSalary) == 1) {
                salary = maxSalary;
            }
            employees.updateSalary(salary);
        }
    }
}
