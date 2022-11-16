package ru.skypro.cource2.spring.validator;

public class WithoutDigitsValidator extends BaseForbiddenCharsValidator {
    private static final String[] forbiddenSymbols = {"1", "2", "3", "4", "5", "6", "7", "8", "9","0"};

    public WithoutDigitsValidator() {
        super(forbiddenSymbols);
    }
}
