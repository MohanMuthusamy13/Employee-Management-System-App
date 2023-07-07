package com.example.Employee.Management.System.Final.entities;

import com.example.Employee.Management.System.Final.dto.EmployeeRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "employees")
@Accessors(chain = true)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "username")
    private String username;
    @Column(name = "email_id")
    private String emailId;
    private String password;

    public static Employee fromEmployeeRequest(EmployeeRequest employeeRequest) {
        return new Employee()
                .setFirstName(employeeRequest.getFirstName())
                .setLastName(employeeRequest.getLastName())
                .setUsername(employeeRequest.getUsername())
                .setEmailId(employeeRequest.getEmail())
                .setPassword(employeeRequest.getPassword());
    }
}
