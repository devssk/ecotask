package com.backend.ecotask.controller;

import com.backend.ecotask.dto.employees.EmployeeHistoryInfoDto;
import com.backend.ecotask.entity.Employees;
import com.backend.ecotask.entity.Jobs;
import com.backend.ecotask.entity.Locations;
import com.backend.ecotask.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
@Transactional
public class TestController {

    private final TestService testService;

    @GetMapping("/1")
    public List<EmployeeHistoryInfoDto> test01() {
        return testService.test();
    }

    @GetMapping("/2")
    public List<Employees> test02() {
        List<Employees> result = testService.test2();
        return result;
    }

    @GetMapping("/3")
    public List<Jobs> test03() {
        List<Jobs> result = testService.test3();
        return result;
    }

    @GetMapping("/4")
    public List<Locations> test04() {
        List<Locations> result = testService.test4();
        return null;
    }

}
