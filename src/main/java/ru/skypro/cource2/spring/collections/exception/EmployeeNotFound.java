package ru.skypro.cource2.spring.collections.exception;

public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound(String name) {
        super(
            String.format(
                "Сотрудник %s не найден",
                name
            )
        );
    }
}
