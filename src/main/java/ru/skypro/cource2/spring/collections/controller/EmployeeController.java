package ru.skypro.cource2.spring.collections.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.cource2.spring.Employee;
import ru.skypro.cource2.spring.EmployeeBook;
import ru.skypro.cource2.spring.collections.service.EmployeeBookService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeBook employeeBook;

    public EmployeeController(EmployeeBookService bookService) {
        employeeBook = bookService.createBook();
    }

    @RequestMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Employee> index() {
        return employeeBook.getEmployees();
    }

    @RequestMapping("/findByName")
    @ResponseStatus(code = HttpStatus.OK)
    public Employee findEmployeeByName(@RequestParam String fullName) {
        return employeeBook.findEmployeeByFullName(fullName);
    }

    @RequestMapping("/findByDepartment")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Employee> findEmployeeByDepartment(@RequestParam int departmentNum) {
        return employeeBook.findEmployeesByDepartmentNum(departmentNum);
    }
}
