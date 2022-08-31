package ru.skypro.cource2.spring.service;

import org.springframework.stereotype.Service;
import ru.skypro.cource2.spring.EmployeeBook;

@Service
public class EmployeeBookService {
    private final static int EMPLOYEES_SIZE = 10;

    private final DepartmentService departmentService;

    private final EmployeeService employeeService;

    public EmployeeBookService(DepartmentService departmentService1, EmployeeService employeeService) {
        this.departmentService = departmentService1;
        this.employeeService = employeeService;
    }

    public EmployeeBook createBook() {
        EmployeeBook employeeBook = new EmployeeBook();
        for (int i = 0; i < EMPLOYEES_SIZE; i++) {
            int baseNum = i + 1;
            employeeBook.add(employeeService.createEmployee(
                String.format("Сотрудник %s", baseNum),
                departmentService.createRandomByNum(baseNum),
                baseNum * 100
            ));
        }
        return employeeBook;
    }
}
