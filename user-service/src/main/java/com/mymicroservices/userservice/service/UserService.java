package com.mymicroservices.userservice.service;

import com.mymicroservices.userservice.VO.Department;
import com.mymicroservices.userservice.VO.ResponseTemplate;
import com.mymicroservices.userservice.entity.Employee;
import com.mymicroservices.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired

    private RestTemplate restTemplate;
    public Employee save(Employee employee) {
        return userRepository.save(employee);
    }

    public Employee findUserById(Long userId) {
        return userRepository.findEmployeeByUserId(userId);
    }

    public ResponseTemplate getUserWithDepartment(Long userId) {
        Employee employee = userRepository.findEmployeeByUserId(userId);

        Department department = restTemplate.getForObject("http://localhost:9001/departments/find/"+employee.getDepartmentId(),
                Department.class);

        ResponseTemplate responseTemplate = new ResponseTemplate(employee, department);
        log.info("UserService - getUserWithDepartment : "+userId+" : "+responseTemplate);
        return responseTemplate;
    }
}
