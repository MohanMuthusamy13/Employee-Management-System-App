package com.example.Employee.Management.System.Final.dto;

import com.example.Employee.Management.System.Final.entities.Employee;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EmployeeResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;

    public static EmployeeResponse fromEmployee(Employee employee) {
        return new EmployeeResponse()
                .setId(employee.getId())
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setUsername(employee.getUsername())
                .setEmail(employee.getEmailId());
    }
}
