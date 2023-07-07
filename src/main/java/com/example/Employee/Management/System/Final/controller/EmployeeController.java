package com.example.Employee.Management.System.Final.controller;

import com.example.Employee.Management.System.Final.dto.EmployeeRequest;
import com.example.Employee.Management.System.Final.dto.EmployeeResponse;
import com.example.Employee.Management.System.Final.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee-management/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<List<EmployeeResponse>> getEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(
            @PathVariable(value = "id") long id
    ) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<EmployeeResponse> saveEmployee(
            @RequestBody EmployeeRequest employeeRequest
    ) {
        return new ResponseEntity<>(employeeService.saveEmployee(employeeRequest), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(
            @PathVariable(value = "id") long id,
            @RequestBody EmployeeRequest employeeRequest
    ) {
        return new ResponseEntity<>(employeeService.updateEmployee(id, employeeRequest), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable(value = "id") long id
    ) {
        return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK);
    }

}
