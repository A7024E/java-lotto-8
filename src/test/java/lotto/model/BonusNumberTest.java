package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.exception.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {
    @DisplayName("BonusNumber 객체 생성")
    @Test
    void generateBonusNumber() {
        // given
        int bonus = 7;
        // when
        BonusNumber bonusNumber = BonusNumber.of(bonus);
        // then
        assertThat(bonusNumber).isEqualTo(BonusNumber.of(bonus));
    }

    @DisplayName("보너스 번호의 범위가 1 부터 45 까지의 범위가 아니라면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void generateBonusNumberWithInvalidNumber(int bonus) {
        // when// then
        assertThatThrownBy(() -> BonusNumber.of(bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_BONUS_NUMBER_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 로또 번호와 일치하면 true를 반환한다.")
    @Test
    void isMatch() {
        // given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.of(2);
        // when
        boolean matches = bonusNumber.isMatches(lotto);
        // then
        assertThat(matches).isTrue();
    }
}