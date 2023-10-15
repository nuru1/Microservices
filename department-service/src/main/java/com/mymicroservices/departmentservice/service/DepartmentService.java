package com.mymicroservices.departmentservice.service;

import com.mymicroservices.departmentservice.entity.Department;
import com.mymicroservices.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        log.info("Inside DepartmentService - save");
        return departmentRepository.save(department);
    }


    public Department findDepartmentById(Long departmentId) {
        log.info("Inside DepartmentService - findDepartmentById");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
