package ru.skypro.cource2.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidInputString extends RuntimeException {
    public InvalidInputString(String message) {
        super(message);
    }
}
