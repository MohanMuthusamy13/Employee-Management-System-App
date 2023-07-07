package com.example.Employee.Management.System.Final.repository;

import com.example.Employee.Management.System.Final.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
