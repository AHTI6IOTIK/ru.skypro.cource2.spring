package ru.skypro.cource2.spring.service;

import org.springframework.stereotype.Service;
import ru.skypro.cource2.spring.validator.ForbiddenCharactersValidator;
import ru.skypro.cource2.spring.validator.ValidatorInterface;
import ru.skypro.cource2.spring.validator.WithoutDigitsValidator;

@Service
public class StringValidatorService {

    private final ValidatorInterface[] validators = {
        new ForbiddenCharactersValidator(),
        new WithoutDigitsValidator()
    };

    public void validate(String str) {
        for (ValidatorInterface validator : validators) {
            validator.validate(str);
        }
    }
}
