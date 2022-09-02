package ru.skypro.cource2.spring;

import java.util.Objects;

public class Employee {

    private static int counter = 0;

    private final int id;

    private final String fullName;

    private Department department;

    private double salary;

    public Employee(String fullName, Department department, double salary) {
        this.id = ++counter;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public Employee setDepartment(Department department) {
        this.department = department;
        return this;
    }

    public Employee setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Double.compare(employee.salary, salary) == 0 && Objects.equals(fullName, employee.fullName) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, department, salary);
    }

    @Override
    public String toString() {
        return String.format(
                "id: %s. Ф.И.О: %s. Департамент: %s. Запралата: %s",
                id,
                fullName,
                department,
                salary
        );
    }
}
