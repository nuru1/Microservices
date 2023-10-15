package com.mymicroservices.departmentservice.controller;

import com.mymicroservices.departmentservice.entity.Department;
import com.mymicroservices.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public Department saveDepartment(@RequestBody Department department){
        log.info("Inside DepartmentController - saveDepartment");
        return departmentService.save(department);
    }

    @GetMapping("/find/{id}")
    public Department findDepartment(@PathVariable("id") Long departmentId){
        log.info("Inside DepartmentController - findDepartment");
        return departmentService.findDepartmentById(departmentId);
    }
}
