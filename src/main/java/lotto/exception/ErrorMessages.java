package lotto.exception;

public enum ErrorMessages {

    ERROR_PREFIX("[ERROR]"),
    INVALID_EMPTY_INPUT("빈 값을 입력할 수 없습니다. 다시 입력해 주세요."),
    INVALID_ONLY_NUMERIC("정수만 입력 가능합니다 다시 입력해 주세요."),
    INVALID_CONTAINS_WHITESPACE("공백을 입력할 수 없습니다. 공백을 제외하고 다시 입력해 주세요.");


    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message+this.message;
    }
}