package ru.skypro.cource2.spring.validator;

import org.apache.commons.lang3.StringUtils;
import ru.skypro.cource2.spring.exception.InvalidInputString;

import java.util.Arrays;

public class ForbiddenCharactersValidator implements ValidatorInterface {
    private static final String[] forbiddenSymbols = {",.!?«»\"'()[]<>|/"};

    @Override
    public boolean validate(String value) throws InvalidInputString {
        if (StringUtils.containsAny(value, forbiddenSymbols)) {
            throw new InvalidInputString(String.format(
                "В строке \"%s\" есть запрещенные символы {%s} ",
                value,
                Arrays.toString(forbiddenSymbols)
            ));
        }

        return true;
    }
}
