package ru.skypro.cource2.spring;

import ru.skypro.cource2.spring.collections.exception.EmployeeAlreadyAdded;
import ru.skypro.cource2.spring.collections.exception.EmployeeNotFound;
import ru.skypro.cource2.spring.stream.exception.NotFoundEmployeesByDepartment;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeBook {
    private final List<Employee> employees = new ArrayList<>();

    public EmployeeBook add(Employee employee) {
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAdded(employee.getFullName());
        }
        employees.add(employee);
        return this;
    }

    public void remove(String fullName) {
        this.removeByIndex(this.findIndexByFullName(fullName));
    }

    public void remove(int employeeId) {
        this.removeByIndex(this.findIndexByEmployeeId(employeeId));
    }

    public void removeByIndex(int index) {
        if (index < 0) {
            return;
        }
        employees.remove(index);
    }

    private int findIndexByFullName(String fullName) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFullName().equals(fullName)) {
                return i;
            }
        }

        throw new EmployeeNotFound(fullName);
    }

    private int findIndexByEmployeeId(int employeeId) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == employeeId) {
                return i;
            }
        }

        throw new EmployeeNotFound("с ID " + employeeId);
    }

    public List<Employee> findEmployeesByDepartmentNum(Integer department) {
        return employees
            .stream()
            .filter(e -> e.getDepartment().getDepartmentNum() == department)
            .collect(Collectors.toList())
        ;
    }

    public Employee findEmployeeByFullName(String fullName) {
        return employees.get(
            findIndexByFullName(fullName)
        );
    }


    public List<Employee> getEmployees() {
        return employees;
    }

    public double getAmountSalaryEmployees() {
        double amountSalaries = 0;

        for (Employee employee : employees) {
            amountSalaries += employee.getSalary();
        }

        return amountSalaries;
    }

    public Employee getEmployeeWithMinimumSalary() {
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (
                null == minSalaryEmployee ||
                    minSalaryEmployee.getSalary() > employee.getSalary()
            ) {
                minSalaryEmployee = employee;
            }
        }

        return minSalaryEmployee;
    }

    public Employee getEmployeeWithMaximumSalary() {
        Employee maxSalaryEmployee = null;

        for (Employee employee : employees) {
            if (
                null == maxSalaryEmployee ||
                maxSalaryEmployee.getSalary() < employee.getSalary()
            ) {
                maxSalaryEmployee = employee;
            }
        }

        return maxSalaryEmployee;
    }

    public double getAvgSalary() {
        double amountSalaryEmployees = this.getAmountSalaryEmployees();

        return amountSalaryEmployees / employees.size();
    }

    public List<String> getFullNameEmployees() {
        List<String> fullNameEmployees = new ArrayList<>();

        for (Employee employee : employees) {
            fullNameEmployees.add(employee.getFullName());
        }

        return fullNameEmployees;
    }

    public void indexSalaryByPercentage(double percent) throws Exception {

        if (0 > percent || percent > 1) {
            throw new Exception("Не корректное значение процента индексации ЗП");
        }

        percent += 1;

        for (Employee employee : employees) {
            double currentSalary = employee.getSalary();
            employee.setSalary(currentSalary * percent);
        }
    }

    public Employee getEmployeeWithMinimumSalaryByDepartment(Integer department) {
        List<Employee> listEmployeesByDepartment = findEmployeesByDepartmentNum(department);

        return listEmployeesByDepartment
            .stream()
            .max(Comparator.comparing(Employee::getSalary))
            .orElseThrow(() -> new NotFoundEmployeesByDepartment(department.toString()))
        ;
    }

    public Employee getEmployeeWithMaximumSalaryByDepartment(Integer department) {
        List<Employee> listEmployeesByDepartment = findEmployeesByDepartmentNum(department);

        return listEmployeesByDepartment
            .stream()
            .max(Comparator.comparing(Employee::getSalary))
            .orElseThrow(() -> new NotFoundEmployeesByDepartment(department.toString()))
        ;
    }

    public double getAmountSalaryEmployeesByDepartment(Integer department) {
        double amountSalaries = 0;

        for (Employee employee : this.findEmployeesByDepartmentNum(department)) {
            amountSalaries += employee.getSalary();
        }

        return amountSalaries;
    }

    public double getAvgSalary(Integer department) {
        List<Employee> departmentEmployees = this.findEmployeesByDepartmentNum(department);
        double amountSalaryEmployees = this.getAmountSalaryEmployeesByDepartment(department);

        return amountSalaryEmployees / departmentEmployees.size();
    }

    public void indexSalaryDepartmentByPercentage(Integer department, double percent) throws Exception {

        if (0 > percent || percent > 1) {
            throw new Exception("Не корректное значение процента индексации ЗП");
        }

        percent += 1;

        for (Employee employee : this.findEmployeesByDepartmentNum(department)) {
            double currentSalary = employee.getSalary();
            employee.setSalary(currentSalary * percent);
        }
    }

    public void printDepartmentEmployees(List<Employee> employees) {
        List<String> result = new ArrayList<>();

        for (Employee employee : employees) {
            result.add(
                String.format(
                    "Ф.И.О: %s. Запралата: %s",
                    employee.getFullName(),
                    employee.getSalary()
                )
            );
        }

        System.out.println(result);
    }

    public List<Employee> getEmployeesWithLessSalaryByNumber(double number) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSalary() < number) {
                result.add(employee);
            }
        }

        return result;
    }

    public List<Employee> getEmployeesWithGreaterThanSalaryByNumber(double number) {
        List<Employee> result = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getSalary() > number) {
                employees.add(employee);
            }
        }

        return result;
    }

    public void printExternalEmployees(Employee[] employees) {
        String[] result = new String[employees.length];
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            result[i] = String.format(
                    "id: %s. Ф.И.О: %s. Запралата: %s",
                    employee.getId(),
                    employee.getFullName(),
                    employee.getSalary()
            );
        }

        System.out.println(Arrays.toString(result));
    }

    public Employee getEmployeeByFullName(String fullName) {
        int index = this.findIndexByFullName(fullName);

        return employees.get(index);
    }

    public boolean changeSalaryEmployeeByFullName(String fullName, double newSalary) {
        Employee employee = this.getEmployeeByFullName(fullName);
        if (Objects.isNull(employee)) {
            return false;
        }

        employee.setSalary(newSalary);
        return true;
    }

    public boolean changeDepartmentEmployeeByFullName(String fullName, Department newDepartment) {
        Employee employee = this.getEmployeeByFullName(fullName);
        if (Objects.isNull(employee)) {
            return false;
        }

        employee.setDepartment(newDepartment);
        return true;
    }

    public List<String> getEmployeeNamesByDepartment(Integer department) {
        List<Employee> employees = this.findEmployeesByDepartmentNum(department);
        List<String> names = new ArrayList<>();
        for (Employee employee : employees) {
            names.add(employee.getFullName());
        }

        return names;
    }
}
