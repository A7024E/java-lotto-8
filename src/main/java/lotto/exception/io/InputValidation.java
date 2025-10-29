package lotto.exception.io;

import lotto.exception.ErrorMessages;

public class InputValidation {

    public static void validate(String input){
        if(isNullOrEmpty(input)){
            throw new IllegalArgumentException(ErrorMessages.INVALID_EMPTY_INPUT.getMessage());
        }
        if(isBlankContains(input)){
            throw new IllegalArgumentException(ErrorMessages.INVALID_CONTAINS_WHITESPACE.getMessage());
        }
        if(isNumeric(input)){
            throw new IllegalArgumentException(ErrorMessages.INVALID_ONLY_NUMERIC.getMessage());
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
