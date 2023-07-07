package com.example.Employee.Management.System.Final.service;

import com.example.Employee.Management.System.Final.dto.EmployeeRequest;
import com.example.Employee.Management.System.Final.dto.EmployeeResponse;
import com.example.Employee.Management.System.Final.entities.Employee;
import com.example.Employee.Management.System.Final.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {

    EmployeeResponse getEmployeeById(long id);

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse saveEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse updateEmployee(long id, EmployeeRequest employeeRequest);

    String deleteEmployee(long id);

}
