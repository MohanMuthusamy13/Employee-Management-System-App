package com.example.Employee.Management.System.Final.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
}
