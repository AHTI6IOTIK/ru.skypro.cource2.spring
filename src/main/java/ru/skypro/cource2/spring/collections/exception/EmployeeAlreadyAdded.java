package ru.skypro.cource2.spring.collections.exception;

public class EmployeeAlreadyAdded extends RuntimeException {
    public EmployeeAlreadyAdded(String fullName) {
        super(
            String.format(
                "Сотрудник %s, добавле ранее",
                fullName
            )
        );
    }
}
