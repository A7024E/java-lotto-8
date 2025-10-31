package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또의 숫자 범위가 1부터 45가 아니라면 예외를 발생한다")
    @Test
    void outRangeLottoNumbers() {
        // given
        List<Integer> numbers = List.of(0, 2, 3, 4, 5, 6, 7);
        // when// then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.from(numbers));
    }

    @DisplayName("로또번호와 당첨번호가 일치하면 일치 개수를 계산할수있다")
    @Test
    void countWinningMatches() {
        // given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        // when
        int matchCount = lotto.countMatches(winningNumbers);
        // then
        assertThat(matchCount).isEqualTo(6);
    }
}
