package com.example.Employee.Management.System.Final.service;

import com.example.Employee.Management.System.Final.dto.EmployeeRequest;
import com.example.Employee.Management.System.Final.dto.EmployeeResponse;
import com.example.Employee.Management.System.Final.entities.Employee;
import com.example.Employee.Management.System.Final.exception.EmployeeNotFoundException;
import com.example.Employee.Management.System.Final.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.Employee.Management.System.Final.utils.Constants.*;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse getEmployeeById(long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            return EmployeeResponse.fromEmployee(employee);
        }
        else {
            throw new EmployeeNotFoundException("Employee not found with the given id");
        }
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream()
                .map(EmployeeResponse::fromEmployee).collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.save(Employee.fromEmployeeRequest(employeeRequest));
        return EmployeeResponse.fromEmployee(employee);
    }

    @Override
    public EmployeeResponse updateEmployee(long id, EmployeeRequest employeeRequest) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee not found with the given id");
        }
        Employee updatedEmployee = employee.get();
        updatedEmployee.setFirstName(employeeRequest.getFirstName());
        updatedEmployee.setLastName(employeeRequest.getLastName());
        updatedEmployee.setUsername(employeeRequest.getUsername());
        updatedEmployee.setEmailId(employeeRequest.getEmail());
        updatedEmployee.setPassword(employeeRequest.getPassword());
        return EmployeeResponse.fromEmployee(updatedEmployee);
    }

    @Override
    public String deleteEmployee(long id) {
        employeeRepository.deleteById(id);
        return DELETED_SUCCESSFULLY;
    }
}
