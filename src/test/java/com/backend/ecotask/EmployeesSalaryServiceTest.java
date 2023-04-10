package com.backend.ecotask;

import com.backend.ecotask.dto.employees.EmployeeSalaryRateReqDto;
import com.backend.ecotask.entity.Departments;
import com.backend.ecotask.entity.Employees;
import com.backend.ecotask.entity.Jobs;
import com.backend.ecotask.repository.EmployeesRepository;
import com.backend.ecotask.service.EmployeesSalaryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class EmployeesSalaryServiceTest {

    @Mock
    EmployeesRepository employeesRepository;

    @InjectMocks
    EmployeesSalaryServiceImpl employeesSalaryService;

    @Test
    @DisplayName("부서별 급여 일정비율 인상 테스트 - 연봉 상한 없음")
    void updateEmployeesSalaryInDepartmentTest01() {
        // given
        Jobs job1 = createJob("SA_MAN", "Sales Manager", BigDecimal.valueOf(10000), BigDecimal.valueOf(20000));
        Jobs job2 = createJob("AD_ASST", "Administration Assistant", BigDecimal.valueOf(3000), BigDecimal.valueOf(6000));
        Jobs job3 = createJob("ST_CLERK", "Stock Clerk", BigDecimal.valueOf(2000), BigDecimal.valueOf(5000));

        Departments department1 = createDepartment(60L, "IT");

        Employees employee1 = createEmployee(1L, "Gil", "Hong", job1, BigDecimal.valueOf(12000), department1);
        Employees employee2 = createEmployee(2L, "Dong", "Hong", job1, BigDecimal.valueOf(17500), department1);
        Employees employee3 = createEmployee(3L, "Un", "Song", job2, BigDecimal.valueOf(3000), department1);
        Employees employee4 = createEmployee(4L, "Sang", "Kim", job2, BigDecimal.valueOf(4500), department1);
        Employees employee5 = createEmployee(5L, "Hoo", "Hwang", job3, BigDecimal.valueOf(2500), department1);
        Employees employee6 = createEmployee(6L, "Jin", "Ha", job3, BigDecimal.valueOf(3000), department1);
        Employees employee7 = createEmployee(7L, "Sin", "Lee", job3, BigDecimal.valueOf(4000), department1);

        Map<Long, BigDecimal> originalEmployeesList = new HashMap<>();
        originalEmployeesList.put(employee1.getEmployeeId(), employee1.getSalary());
        originalEmployeesList.put(employee2.getEmployeeId(), employee2.getSalary());
        originalEmployeesList.put(employee3.getEmployeeId(), employee3.getSalary());
        originalEmployeesList.put(employee4.getEmployeeId(), employee4.getSalary());
        originalEmployeesList.put(employee5.getEmployeeId(), employee5.getSalary());
        originalEmployeesList.put(employee6.getEmployeeId(), employee6.getSalary());
        originalEmployeesList.put(employee7.getEmployeeId(), employee7.getSalary());

        List<Employees> employeesList = new ArrayList<>();
        employeesList.add(employee1);
        employeesList.add(employee2);
        employeesList.add(employee3);
        employeesList.add(employee4);
        employeesList.add(employee5);
        employeesList.add(employee6);
        employeesList.add(employee7);

        Long departmentId = 60L;
        BigDecimal rate = BigDecimal.valueOf(0.05);
        EmployeeSalaryRateReqDto requestDto = createDto(rate);

        Mockito.doReturn(employeesList).when(employeesRepository).findFetchEmployeesInDepartment(departmentId);

        // when
        employeesSalaryService.updateEmployeesSalaryInDepartment(departmentId, requestDto);

        // then
        for (Employees employee : employeesList) {
            Assertions.assertEquals(employee.getSalary(), originalEmployeesList.get(employee.getEmployeeId()).add(originalEmployeesList.get(employee.getEmployeeId()).multiply(rate)));
        }
    }

    @Test
    @DisplayName("부서별 급여 일정비율 인상 테스트 - 연봉 상한 도달")
    void updateEmployeesSalaryInDepartmentTest02() {
        Jobs job1 = createJob("SA_MAN", "Sales Manager", BigDecimal.valueOf(10000), BigDecimal.valueOf(20000));
        Jobs job2 = createJob("AD_ASST", "Administration Assistant", BigDecimal.valueOf(3000), BigDecimal.valueOf(6000));
        Jobs job3 = createJob("ST_CLERK", "Stock Clerk", BigDecimal.valueOf(2000), BigDecimal.valueOf(5000));

        Departments department1 = createDepartment(60L, "IT");

        Employees employee1 = createEmployee(1L, "Gil", "Hong", job1, BigDecimal.valueOf(19900), department1);
        Employees employee2 = createEmployee(2L, "Dong", "Hong", job1, BigDecimal.valueOf(20000), department1);
        Employees employee3 = createEmployee(3L, "Un", "Song", job2, BigDecimal.valueOf(5900), department1);
        Employees employee4 = createEmployee(4L, "Sang", "Kim", job3, BigDecimal.valueOf(5000), department1);

        List<Employees> employeesList = new ArrayList<>();
        employeesList.add(employee1);
        employeesList.add(employee2);
        employeesList.add(employee3);
        employeesList.add(employee4);

        Long departmentId = 60L;
        BigDecimal rate = BigDecimal.valueOf(0.05);
        EmployeeSalaryRateReqDto requestDto = createDto(rate);

        Mockito.doReturn(employeesList).when(employeesRepository).findFetchEmployeesInDepartment(any(Long.class));

        // when
        employeesSalaryService.updateEmployeesSalaryInDepartment(departmentId, requestDto);

        // then
        for (Employees employee : employeesList) {
            Assertions.assertEquals(employee.getSalary(), employee.getJobs().getMaxSalary());
        }
    }

    private Employees createEmployee(Long employeeId, String firstName, String lastName, Jobs jobs, BigDecimal salary, Departments departments) {
        return Employees.builder()
                .employeeId(employeeId)
                .firstName(firstName)
                .lastName(lastName)
                .jobs(jobs)
                .salary(salary)
                .departments(departments)
                .build();
    }

    private Departments createDepartment(Long departmentId, String departmentName) {
        return Departments.builder()
                .departmentId(departmentId)
                .departmentName(departmentName)
                .build();
    }

    private Jobs createJob(String jobId, String jobTitle, BigDecimal minSalary, BigDecimal maxSalary) {
        return Jobs.builder()
                .jobId(jobId)
                .jobTitle(jobTitle)
                .minSalary(minSalary)
                .maxSalary(maxSalary)
                .build();
    }

    private EmployeeSalaryRateReqDto createDto(BigDecimal rate) {
        EmployeeSalaryRateReqDto result = new EmployeeSalaryRateReqDto();
        result.setRate(rate);
        return result;
    }

}
