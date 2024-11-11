package com.ems.EmployeeManagementSystem.service.Implementations;

import com.ems.EmployeeManagementSystem.dto.EmployeeDto;
import com.ems.EmployeeManagementSystem.entity.Employee;
import com.ems.EmployeeManagementSystem.exception.ResourceNotFoundException;
import com.ems.EmployeeManagementSystem.mapper.EmployeeMapper;
import com.ems.EmployeeManagementSystem.repository.EmployeeRepository;
import com.ems.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
//@Autowired //Field Injection
    private final EmployeeRepository employeeRepository;

    //Constructor Injection - Prefered
    //Constructor Injection makes it possible to create immutable objects by requiring dependencies to be passed in at the time of object creation.
    // This makes the dependencies final, ensuring that they cannot be changed after the object is created.
    //Field Injection does not enforce immutability since the dependency is injected into the field directly, which can be changed unintentionally.
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        System.out.println("Employee " + employee.toString());
        Employee savedEmployee = employeeRepository.save(employee);
        System.out.println("Saved Employee " + savedEmployee.toString());

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

       Employee returnedEmployeeDetails = employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourceNotFoundException("Employee does not Exists with the given id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(returnedEmployeeDetails);
    }
}
