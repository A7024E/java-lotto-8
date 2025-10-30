package lotto.exception;

public enum ErrorMessages {

    ERROR_PREFIX("[ERROR]"),
    INVALID_EMPTY_INPUT("빈 값을 입력할 수 없습니다. 다시 입력해 주세요."),
    INVALID_ONLY_NUMERIC("정수만 입력 가능합니다 다시 입력해 주세요."),
    INVALID_CONTAINS_WHITESPACE("공백을 입력할 수 없습니다. 공백을 제외하고 다시 입력해 주세요."),
    INVALID_NOT_DIVIDE_PURCHASE_AMOUNT("금액은 1000원 단위로 입력해야 합니다"),
    INVALID_PURCHASE_AMOUNT_MINIMUM("시작 금액은 1000원 부터입니다."),
    INVALID_LOTTO_NUMBER_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45까지 입니다"),
    INVALID_LOTTO_NUMBER_DUPLICATES("로또 번호는 중복될 수 없습니다");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message+this.message;
    }
}