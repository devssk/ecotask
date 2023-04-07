package com.backend.ecotask.service;

import com.backend.ecotask.dto.employees.EmployeeHistoryInfoDto;
import com.backend.ecotask.entity.Employees;
import com.backend.ecotask.entity.JobHistory;
import com.backend.ecotask.entity.Jobs;
import com.backend.ecotask.entity.Locations;
import com.backend.ecotask.repository.EmployeesRepository;
import com.backend.ecotask.repository.JobHistoryRepository;
import com.backend.ecotask.repository.JobsRepository;
import com.backend.ecotask.repository.LocationsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TestService {

    private final JobHistoryRepository jobHistoryRepository;
    private final EmployeesRepository employeesRepository;
    private final JobsRepository jobsRepository;
    private final LocationsRepository locationsRepository;

    public List<EmployeeHistoryInfoDto> test() {
        List<JobHistory> all = jobHistoryRepository.findAll();

//        return all.stream().map(employeeHistoryInfoMapper).toList();
        return null;
    }

    public List<Employees> test2() {
        List<Employees> all = employeesRepository.findAll();
        for (Employees employees : all) {
            System.out.println(employees.toString());
        }
        return all;
    }

    public List<Jobs> test3() {
        List<Jobs> all = jobsRepository.findAll();
        return all;
    }

    public List<Locations> test4() {
        List<Locations> all = locationsRepository.findAll();
        for (Locations locations : all) {
            System.out.println(locations.toString());
        }
        return all;
    }

    public void openAPITest() throws JsonProcessingException {

        String apiKey = "7fN%2FKywNXf7jyzbwLC1pSwpHnEpj5jMZhenQSVmc9hGUCtWjyWwFfaZc5QxCmzwoHol2fZ%2BzPMBRs6uGdINzVQ%3D%3D";
        String apiKey2 = "7fN/KywNXf7jyzbwLC1pSwpHnEpj5jMZhenQSVmc9hGUCtWjyWwFfaZc5QxCmzwoHol2fZ+zPMBRs6uGdINzVQ==";

        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustWeekFrcstDspth?serviceKey=" + apiKey + "&returnType=json&numOfRows=100&pageNo=1";



        HttpHeaders headers = new HttpHeaders();

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory();
        defaultUriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
        restTemplate.setUriTemplateHandler(defaultUriBuilderFactory);
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response);
        JsonNode jsonResponse = new ObjectMapper().readTree(response.getBody());
        System.out.println(jsonResponse);
    }

}
