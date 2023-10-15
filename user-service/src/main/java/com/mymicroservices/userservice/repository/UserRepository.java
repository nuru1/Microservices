package com.mymicroservices.userservice.repository;

import com.mymicroservices.userservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Employee, Long> {
    Employee findEmployeeByUserId(Long userId);
}
