package ru.skypro.cource2.spring.stream.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.cource2.spring.Department;
import ru.skypro.cource2.spring.Employee;
import ru.skypro.cource2.spring.EmployeeBook;
import ru.skypro.cource2.spring.service.EmployeeBookService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final EmployeeBook employeeBook;
    private final EmployeeBookService bookService;

    public DepartmentController(EmployeeBookService bookService) {
        employeeBook = bookService.createBook();
        this.bookService = bookService;
    }

    @GetMapping( "/max-salary")
    public Employee findMaxSalaryByDepartment(@RequestParam int departmentId) {
        System.out.println(employeeBook.getEmployees());
        return employeeBook.getEmployeeWithMaximumSalaryByDepartment(departmentId);
    }

    @GetMapping( "/min-salary")
    public Employee findMixSalaryByDepartment(@RequestParam int departmentId) {
        System.out.println(employeeBook.getEmployees());
        return employeeBook.getEmployeeWithMinimumSalaryByDepartment(departmentId);
    }

    @GetMapping(path = "/all", params = {"departmentId"})
    public List<Employee> findAllEmployeesByDepartment(@RequestParam(required = false) int departmentId) {
        return employeeBook.findEmployeesByDepartmentNum(departmentId);
    }

    @GetMapping("/all")
    public Map<Department, List<Employee>> getEmployeesGroupByDepartment() {
        return bookService.getPreparedByDepartment(employeeBook.getEmployees());
    }
}
