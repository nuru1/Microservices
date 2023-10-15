package com.mymicroservices.userservice.VO;

import com.mymicroservices.userservice.VO.Department;
import com.mymicroservices.userservice.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseTemplate implements Serializable {

    private Employee employee;
    private Department department;
}
