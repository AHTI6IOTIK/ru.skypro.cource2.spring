package ru.skypro.cource2.spring.collections.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
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
