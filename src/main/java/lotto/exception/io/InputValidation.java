package lotto.exception.io;

import lotto.exception.ErrorMessages;

public class InputValidation {

    public static void validateNullOrEmpty(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_EMPTY_INPUT.getMessage());
        }
    }

    public static void validateBlankContains(String input) {
        if (isBlankContains(input)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CONTAINS_WHITESPACE.getMessage());
        }
    }

    public static void validateNumeric(String input) {
        if (isNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_ONLY_NUMERIC.getMessage());
        }
    }

    public static void validateDelimiter(String input) {
        if (!input.matches("^-?\\d+(,-?\\d+)*$")) {
            throw new IllegalArgumentException("당첨 번호는 공백없이 쉼표로 구분된 정수들로 입력해야 합니다.");
        }
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean isBlankContains(String input) {
        return input.contains(" ");
    }

    private static boolean isNumeric(String input) {
        return !input.matches("^[0-9]*$");
    }

}
