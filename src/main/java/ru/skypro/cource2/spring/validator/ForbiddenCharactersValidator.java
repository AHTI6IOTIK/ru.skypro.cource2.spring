package ru.skypro.cource2.spring.validator;

public class ForbiddenCharactersValidator extends BaseForbiddenCharsValidator {
    private static final String[] forbiddenSymbols = {",", ".", "!", "?", "«", "»", "\"", "'", "(",")", "[", "]", "<", ">", "|", "/"};

    public ForbiddenCharactersValidator() {
        super(forbiddenSymbols);
    }
}
