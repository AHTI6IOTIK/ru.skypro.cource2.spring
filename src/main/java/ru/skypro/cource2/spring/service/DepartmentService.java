package ru.skypro.cource2.spring.service;

import org.springframework.stereotype.Service;
import ru.skypro.cource2.spring.Department;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    private static final int DEPARTMENT_SIZE = 5;
    List<Department> departments = new ArrayList<>();

    public DepartmentService() {
        initial();
    }

    private void initial() {
        for (int i = 0; i < DEPARTMENT_SIZE; i++) {
            departments.add(new Department(i + 1));
        }
    }

    public Department createRandomByNum(Integer num) {
        return new Department(num % DEPARTMENT_SIZE);
    }
}
