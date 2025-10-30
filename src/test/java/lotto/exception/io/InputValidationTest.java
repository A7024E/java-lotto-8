package lotto.exception.io;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.exception.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidationTest {
    @DisplayName("입력값이 null 이거나 빈칸이면 예외를 발생한다")
    @ParameterizedTest
    @NullAndEmptySource
    void inputIsNullOrEmpty(String input) {
        // given//when// then
        assertThatThrownBy(()->InputValidation.validateNullOrEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_EMPTY_INPUT.getMessage());
    }

    @DisplayName("입력값에 공백이 들어가면 예외를 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {" ","1000 ","1 000"," 1000","1000 "})
    void inputIsWhitespace(String input) {
        // given//when// then
        assertThatThrownBy(()->InputValidation.validateBlankContains(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_CONTAINS_WHITESPACE.getMessage());
    }

    @DisplayName("입력값에 문자열이 들어가면 예외를 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"a","-","1000원","100@","1000a"})
    void inputIsNumeric(String input) {
        // given//when// then
        assertThatThrownBy(()->InputValidation.validateNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_ONLY_NUMERIC.getMessage());
    }

    @DisplayName("입력값이 Null 또는 빈칸이 아니면 예외를 발생하지 않는다")
    @Test
    void nonErrorNullOrEmpty() {
        // given
        String input = "1000";

        // when// then
        assertThatCode(()->InputValidation.validateNullOrEmpty(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("입력값이 공백이 포함되지 않으면 예외를 발생하지 않는다")
    @Test
    void nonErrorBlank() {
        // given
        String input = "2000";

        // when// then
        assertThatCode(()->InputValidation.validateBlankContains(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("입력값이 정확한 정수값을 입력할 경우 예외를 발생핮지않는다")
    @Test
    void nonErrorNumerical() {
        // given
        String input = "3000";

        // when// then
        assertThatCode(()->InputValidation.validateNumeric(input))
                .doesNotThrowAnyException();
    }


}