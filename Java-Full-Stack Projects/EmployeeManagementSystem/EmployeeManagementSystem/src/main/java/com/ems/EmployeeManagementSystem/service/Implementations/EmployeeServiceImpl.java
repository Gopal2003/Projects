package com.ems.EmployeeManagementSystem.service.Implementations;

import com.ems.EmployeeManagementSystem.dto.EmployeeDto;
import com.ems.EmployeeManagementSystem.entity.Employee;
import com.ems.EmployeeManagementSystem.exception.ResourceNotFoundException;
import com.ems.EmployeeManagementSystem.mapper.EmployeeMapper;
import com.ems.EmployeeManagementSystem.repository.EmployeeRepository;
import com.ems.EmployeeManagementSystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
//@Autowired //Field Injection
    private final EmployeeRepository employeeRepository;

    //Constructor Injection - Prefered
    //Constructor Injection makes it possible to create immutable objects by requiring dependencies to be passed in at the time of object creation.
    // This makes the dependencies final, ensuring that they cannot be changed after the object is created.
    //Field Injection does not enforce immutability since the dependency is injected into the field directly, which can be changed unintentionally.
//    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

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

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
//        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
//                .collect(Collectors.toList());
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployeeDto) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee doesn't Exists with the given id: " + employeeId));

        employee.setFirstName(updatedEmployeeDto.getFirstName());
        employee.setLastName(updatedEmployeeDto.getLastName());
        employee.setEmail(updatedEmployeeDto.getEmail());

        //.save() method is responsible for both saving the new employee details and updating the existing employee details.
        // If the employeeId is present in the database, then update operation is performed, else new employee details is inserted.
        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
         employeeRepository.findById(employeeId).orElseThrow(()->
                 new ResourceNotFoundException("Employee doesn't Exists with the given id: " + employeeId));

         employeeRepository.deleteById(employeeId);
    }
}
