package com.backend.ecotask.service;

import com.backend.ecotask.dto.employees.EmployeeInfoUpdateReqDto;
import com.backend.ecotask.entity.Departments;
import com.backend.ecotask.entity.Employees;
import com.backend.ecotask.entity.Jobs;
import com.backend.ecotask.exception.CustomException;
import com.backend.ecotask.exception.ErrorCode;
import com.backend.ecotask.repository.DepartmentsRepository;
import com.backend.ecotask.repository.EmployeesRepository;
import com.backend.ecotask.repository.JobsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeesInfoUpdateServiceImpl implements EmployeesInfoUpdateService{

    private final EmployeesRepository employeesRepository;

    private final JobsRepository jobsRepository;

    private final DepartmentsRepository departmentsRepository;

    @Override
    public Long updateEmployeeInfo(Long employeeId, EmployeeInfoUpdateReqDto requestDto) {

        Employees findEmployee = findEmployee(employeeId);

        if (requestDto.getSalary().compareTo(findEmployee.getJobs().getMinSalary()) == -1 || requestDto.getSalary().compareTo(findEmployee.getJobs().getMaxSalary()) == 1) {
            throw new CustomException(ErrorCode.CHECK_JOB_SALARY);
        }

        Jobs findJob = findJob(requestDto.getJobId());

        if (requestDto.getFirstName() != null) {
            if (findEmployee.getEmployeeId() == null) {
                findEmployee.updateFirstName(requestDto.getFirstName());
            } else {
                if (!findEmployee.getFirstName().equals(requestDto.getFirstName())) {
                    findEmployee.updateFirstName(requestDto.getFirstName());
                }
            }
        }

        if (!findEmployee.getLastName().equals(requestDto.getLastName())) {
            findEmployee.updateLastName(requestDto.getLastName());
        }

        if (!findEmployee.getEmail().equals(requestDto.getEmail())) {
            findEmployee.updateEmail(requestDto.getEmail());
        }

        if (requestDto.getPhoneNumber() != null) {
            if (findEmployee.getPhoneNumber() == null) {
                findEmployee.updatePhoneNumber(requestDto.getPhoneNumber());
            } else {
                if (!findEmployee.getPhoneNumber().equals(requestDto.getPhoneNumber())) {
                    findEmployee.updatePhoneNumber(requestDto.getPhoneNumber());
                }
            }
        }

        if (findEmployee.getHireDate() != requestDto.getHireDate()) {
            findEmployee.updateHireDate(requestDto.getHireDate());
        }

        if (findJob != null) {
            if (findEmployee.getJobs() != findJob) {
                findEmployee.updateJobs(findJob);
            }
        }

        if (!findEmployee.getSalary().equals(requestDto.getSalary())) {
            findEmployee.updateSalary(requestDto.getSalary());
        }

        if (requestDto.getCommissionPct() != null) {
            if (findEmployee.getCommissionPct() == null) {
                findEmployee.updateCommissionPct(requestDto.getCommissionPct());
            } else {
                if (!findEmployee.getCommissionPct().equals(requestDto.getCommissionPct())) {
                    findEmployee.updateCommissionPct(requestDto.getCommissionPct());
                }
            }
        }

        if (requestDto.getManagerId() != null) {
            Employees findManager = findManager(requestDto.getManagerId());
            if (findEmployee.getManager() == null) {
                findEmployee.updateManager(findManager);
            } else {
                if (findEmployee.getManager() != findManager) {
                    findEmployee.updateManager(findManager);
                }
            }
        }

        if (requestDto.getDepartmentId() != null) {
            Departments findDepartment = findDepartment(requestDto.getDepartmentId());
            if (findEmployee.getDepartments() == null) {
                findEmployee.updateDepartments(findDepartment);
            } else {
                if (findEmployee.getDepartments() != findDepartment) {
                    findEmployee.updateDepartments(findDepartment);
                }
            }
        }

        return findEmployee.getEmployeeId();
    }

    private Employees findEmployee(Long employeeId) {

        if (employeeId == null) {
            throw new CustomException(ErrorCode.EMPLOYEE_ID_IS_NULL);
        }

        return employeesRepository.findFetchEmployee(employeeId).orElseThrow(
                () -> new CustomException(ErrorCode.EMPLOYEE_NOT_FOUND)
        );
    }

    private Jobs findJob(String jobId) {
        return jobsRepository.findById(jobId).orElseThrow(
                () -> new CustomException(ErrorCode.JOB_NOT_FOUND)
        );
    }

    private Employees findManager(Long managerId) {
        return employeesRepository.findById(managerId).orElseThrow(
                () -> new CustomException(ErrorCode.MANAGER_NOT_FOUND)
        );
    }

    private Departments findDepartment(Long departmentId) {
        return departmentsRepository.findById(departmentId).orElseThrow(
                () -> new CustomException(ErrorCode.DEPARTMENT_NOT_FOUND)
        );
    }
}
