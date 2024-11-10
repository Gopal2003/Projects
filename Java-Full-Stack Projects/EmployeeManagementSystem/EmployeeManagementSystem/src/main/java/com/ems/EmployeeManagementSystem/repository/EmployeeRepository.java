package com.ems.EmployeeManagementSystem.repository;

import com.ems.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    No need to write @Repository because, SimpleJpaRepository which is the implementation of JpaRepository interface has @Repository annotation.

    The reason why you don't need to explicitly annotate @Repository on repository interfaces like EmployeeRepository is:
    Auto-detection: Spring automatically detects interfaces extending JpaRepository (or other Spring Data repository interfaces) and creates proxy
    implementations for them at runtime. The underlying implementation class (SimpleJpaRepository) already has the @Repository annotation.

*/

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
