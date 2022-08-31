package ru.skypro.cource2.spring.collections.service;

import org.springframework.stereotype.Service;
import ru.skypro.cource2.spring.collections.Department;
import ru.skypro.cource2.spring.collections.Employee;

@Service
public class EmployeeService {
    public Employee createEmployee(String fullName, Department department, double salary) {
        return new Employee(fullName, department, salary);
    }
}
