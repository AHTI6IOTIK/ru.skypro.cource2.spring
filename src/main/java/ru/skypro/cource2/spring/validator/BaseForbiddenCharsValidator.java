package ru.skypro.cource2.spring.validator;

import org.apache.commons.lang3.StringUtils;
import ru.skypro.cource2.spring.exception.InvalidInputString;

import java.util.Arrays;

abstract public class BaseForbiddenCharsValidator implements ValidatorInterface {
    private String[] forbiddenSymbols = null;

    public BaseForbiddenCharsValidator() {
        throw new RuntimeException("Нужно определить последовательность запрещенных символов");
    }

    public BaseForbiddenCharsValidator(String[] forbiddenSymbols) {
        this.forbiddenSymbols = forbiddenSymbols;
    }

    public boolean validate(String value) {
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
