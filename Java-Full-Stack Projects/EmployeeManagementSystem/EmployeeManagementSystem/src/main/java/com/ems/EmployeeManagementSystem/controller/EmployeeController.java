package com.ems.EmployeeManagementSystem.controller;


import com.ems.EmployeeManagementSystem.dto.EmployeeDto;
import com.ems.EmployeeManagementSystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees") //Defines Base Url for all the APIs.
public class EmployeeController {

    private EmployeeService employeeService;

    //Build Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) { // @RequestBody annotation extracts the JSON file and convert it into the type EmployeeDto.

        System.out.println("Inside the Controller");
      EmployeeDto savedEmployee =  employeeService.createEmployee(employeeDto);
      return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDetails = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDetails, HttpStatus.OK);
    }
}
