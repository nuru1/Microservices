package com.mymicroservices.userservice.controller;

import com.mymicroservices.userservice.VO.ResponseTemplate;
import com.mymicroservices.userservice.entity.Employee;
import com.mymicroservices.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee){
        log.info("inside UserController - save");
        try {
            employee = userService.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    @GetMapping("/find/{id}")
    public Employee findUser(@PathVariable("id") Long userId){
        log.info("inside UserController - findUser");
        return userService.findUserById(userId);
    }

    @GetMapping("/findUserWithDepartment/{id}")
    public ResponseTemplate getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("inside UserController - getUserWithDepartment");
        return userService.getUserWithDepartment(userId);
    }
}
