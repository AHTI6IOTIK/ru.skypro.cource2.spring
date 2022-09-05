package ru.skypro.cource2.spring.collections.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.cource2.spring.Employee;
import ru.skypro.cource2.spring.EmployeeBook;
import ru.skypro.cource2.spring.service.EmployeeBookService;
import ru.skypro.cource2.spring.service.StringValidatorService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeBook employeeBook;

    private final StringValidatorService stringValidatorService;

    public EmployeeController(EmployeeBookService bookService, StringValidatorService stringValidatorService) {
        employeeBook = bookService.createBook();
        this.stringValidatorService = stringValidatorService;
    }

    @RequestMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Employee> index() {
        return employeeBook.getEmployees();
    }

    @RequestMapping("/findByName")
    public Employee findEmployeeByName(@RequestParam String fullName) {
        stringValidatorService.validate(fullName);
        return employeeBook.findEmployeeByFullName(StringUtils.capitalize(fullName));
    }

    @RequestMapping("/findByDepartment")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Employee> findEmployeeByDepartment(@RequestParam int departmentNum) {
        return employeeBook.findEmployeesByDepartmentNum(departmentNum);
    }
}
