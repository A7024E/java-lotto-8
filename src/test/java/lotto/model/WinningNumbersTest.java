package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {
    @DisplayName("당첨 번호 객체를 생성한다")
    @Test
    void generateWinningNumbers() {
        // given
        Lotto inputWinningNumbers = Lotto.from(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;
        // when
        WinningNumbers winningNumbers = WinningNumbers.of(inputWinningNumbers, bonusNumber);
        // then
        assertThat(winningNumbers).isEqualTo(WinningNumbers.of(inputWinningNumbers, bonusNumber));
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복된다면 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    void duplicateWinningNumbers(int numbers) {
        // when// then
        assertThatThrownBy(()->WinningNumbers.of(Lotto.from(List.of(1,2,3,4,5,6)), numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_BONUS_NUMBER_DUPLICATE.getMessage());
    }

    @DisplayName("당첨 번호에 보너스 넘버가 중복되지 않으면 예외를 발생시키지 않는다")
    @ParameterizedTest
    @ValueSource(ints = {7,8,9,10,11,12})
    void notDuplicateWinningNumbers(int numbers) {
        // when// then
        assertThatCode(()->WinningNumbers.of(Lotto.from(List.of(1,2,3,4,5,6)), numbers))
                .doesNotThrowAnyException();
    }

}