package com.ems.EmployeeManagementSystem.service;

import com.ems.EmployeeManagementSystem.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);
}
