package com.backend.ecotask.service;

import com.backend.ecotask.dto.employees.EmployeeSalaryRateReqDto;
import com.backend.ecotask.entity.Employees;
import com.backend.ecotask.entity.OriginalEmployees;
import com.backend.ecotask.repository.EmployeesRepository;
import com.backend.ecotask.repository.OriginalEmployeesRepository;
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

    private final OriginalEmployeesRepository originalEmployeesRepository;

    @Override
    public void updateEmployeesSalaryInDepartment(Long departmentId, EmployeeSalaryRateReqDto rate) {
        List<Employees> findEmployeesList = employeesRepository.findFetchEmployeesInDepartment(departmentId);
        for (Employees employees : findEmployeesList) {
            BigDecimal maxSalary = employees.getJobs().getMaxSalary();
            BigDecimal salary = employees.getSalary().add(employees.getSalary().multiply(rate.getRate()));
            if (salary.compareTo(maxSalary) == 1) {
                salary = maxSalary;
            }
            employees.updateSalary(salary);
        }
    }

    @Override
    public void returnEmployeesSalaryToOriginal() {
        List<Employees> employeeList = employeesRepository.findAll();
        List<OriginalEmployees> originalEmployeeList = originalEmployeesRepository.findAll();

        for (Employees employees : employeeList) {
            for (OriginalEmployees originalEmployees : originalEmployeeList) {
                if (employees.getEmployeeId() == originalEmployees.getEmployeeId()) {
                    employees.updateSalary(originalEmployees.getSalary());
                }
            }
        }
    }
}
