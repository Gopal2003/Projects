package com.ems.EmployeeManagementSystem.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//EmployeeDto class is responsible to transfer the data between client and server;
//DTOs encapsulate data and prevent the exposure of internal models directly to external clients, thus adding a layer of security and abstraction.
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
