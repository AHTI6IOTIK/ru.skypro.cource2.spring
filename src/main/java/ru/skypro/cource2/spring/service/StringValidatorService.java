package ru.skypro.cource2.spring.service;

import org.springframework.stereotype.Service;
import ru.skypro.cource2.spring.exception.InvalidInputString;
import ru.skypro.cource2.spring.validator.ForbiddenCharactersValidator;
import ru.skypro.cource2.spring.validator.ValidatorInterface;

import java.util.ArrayList;
import java.util.List;

@Service
public class StringValidatorService {

    private final List<String> errors = new ArrayList<>();
    private final ValidatorInterface[] validators = {
        new ForbiddenCharactersValidator()
    };

    public boolean validate(String str) {

        for (ValidatorInterface validator : validators) {
            try {
                validator.validate(str);
            } catch (InvalidInputString e) {
                errors.add(e.getMessage());
            }
        }

        if (errors.size() != 0) {
            System.out.println("errors = " + errors);
            return false;
        }

        return true;
    }
}
