package ru.skypro.cource2.spring.validator;

import ru.skypro.cource2.spring.exception.InvalidInputString;

public interface ValidatorInterface {
    boolean validate(String value) throws InvalidInputString;
}
