package com.backend.ecotask;

import com.backend.ecotask.dto.employees.EmployeeInfoUpdateReqDto;
import com.backend.ecotask.entity.Departments;
import com.backend.ecotask.entity.Employees;
import com.backend.ecotask.entity.Jobs;
import com.backend.ecotask.exception.CustomException;
import com.backend.ecotask.repository.DepartmentsRepository;
import com.backend.ecotask.repository.EmployeesRepository;
import com.backend.ecotask.repository.JobsRepository;
import com.backend.ecotask.service.EmployeesInfoUpdateServiceImpl;
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
import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class EmployeesInfoUpdateServiceTest {

    @Mock
    EmployeesRepository employeesRepository;

    @Mock
    JobsRepository jobsRepository;

    @Mock
    DepartmentsRepository departmentsRepository;

    @InjectMocks
    EmployeesInfoUpdateServiceImpl employeesInfoUpdateService;

    @Test
    @DisplayName("직원 정보 변경 테스트")
    void updateEmployeeInfo01() {
        // given
        Jobs job = createJob(
                "AC_ACCOUNT",
                "Public Accountant",
                new BigDecimal(4200),
                new BigDecimal(9000)
        );
        Departments department = createDepartment(
                1L,
                "Finance"
        );
        Employees employee = createEmployee(
                1L,
                "GilDong",
                "Hong",
                "EMAIL",
                "123456",
                LocalDate.of(2000, 05, 16),
                job,
                new BigDecimal(5000),
                null,
                null,
                department
        );
        EmployeeInfoUpdateReqDto requestDto = createDto(
                "DongGil",
                "Hong",
                "EMAIL",
                "123456",
                LocalDate.of(2000, 05, 16),
                "AC_ACCOUNT",
                new BigDecimal(6000),
                null,
                null,
                1L
        );

        Long employeeId = 1L;

        Mockito.doReturn(Optional.of(employee)).when(employeesRepository).findFetchEmployee(any(Long.class));
        Mockito.doReturn(Optional.of(job)).when(jobsRepository).findById(any(String.class));
        Mockito.doReturn(Optional.of(department)).when(departmentsRepository).findById(any(Long.class));

        // when
        Long result = employeesInfoUpdateService.updateEmployeeInfo(employeeId, requestDto);

        // then
        Assertions.assertEquals(result, 1L);
    }

    @Test
    @DisplayName("직원 정보 변경 테스트 - 잘못된 연봉 기입")
    void updateEmployeeInfo02() {
        // given
        Jobs job = createJob(
                "AC_ACCOUNT",
                "Public Accountant",
                new BigDecimal(4200),
                new BigDecimal(9000)
        );
        Departments department = createDepartment(
                1L,
                "Finance"
        );
        Employees employee = createEmployee(
                1L,
                "GilDong",
                "Hong",
                "EMAIL",
                "123456",
                LocalDate.of(2000, 05, 16),
                job,
                new BigDecimal(5000),
                null,
                null,
                department
        );
        EmployeeInfoUpdateReqDto requestDto = createDto(
                "DongGil",
                "Hong",
                "EMAIL",
                "123456",
                LocalDate.of(2000, 05, 16),
                "AC_ACCOUNT",
                new BigDecimal(10000),
                null,
                null,
                1L
        );

        Long employeeId = 1L;

        Mockito.doReturn(Optional.of(employee)).when(employeesRepository).findFetchEmployee(any(Long.class));

        // when
        Throwable exception = Assertions.assertThrows(CustomException.class, () -> {
            employeesInfoUpdateService.updateEmployeeInfo(employeeId, requestDto);
        });

        // then
        Assertions.assertEquals("직업별 연봉 하한과 상한을 확인해주세요.", exception.getMessage());
    }

    private Employees createEmployee(Long employeeId, String firstName, String lastName, String email, String phoneNumber, LocalDate hireDate, Jobs jobs, BigDecimal salary, BigDecimal commissionPct, Employees manager, Departments departments) {
        return Employees.builder()
                .employeeId(employeeId)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phoneNumber(phoneNumber)
                .hireDate(hireDate)
                .jobs(jobs)
                .salary(salary)
                .commissionPct(commissionPct)
                .manager(manager)
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

    private EmployeeInfoUpdateReqDto createDto(String firstName, String lastName, String email, String phoneNumber, LocalDate hireDate, String jobId, BigDecimal salary, BigDecimal commissionPct, Long managerId, Long departmentId) {
        EmployeeInfoUpdateReqDto result = new EmployeeInfoUpdateReqDto();
        result.setFirstName(firstName);
        result.setLastName(lastName);
        result.setEmail(email);
        result.setPhoneNumber(phoneNumber);
        result.setHireDate(hireDate);
        result.setJobId(jobId);
        result.setSalary(salary);
        result.setCommissionPct(commissionPct);
        result.setManagerId(managerId);
        result.setDepartmentId(departmentId);
        return result;
    }

}
