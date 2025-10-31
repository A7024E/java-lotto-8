package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningCalculatorTest {
    @DisplayName("당첨 결과를 계산한다")
    @Test
    void calculateMatchRank() {
        // given
        Lottos lottos = Lottos.from(List.of(
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.from(List.of(7, 8, 9, 10, 11, 12))
        ));
        WinningNumbers winningNumbers = WinningNumbers.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), 7);

        // when
        LottoWinningCalculator lottoWinningCalculator = LottoWinningCalculator.create();
        LottoWinningResults lottoWinningResults = lottoWinningCalculator.calculateWinningResults(lottos,winningNumbers);
        // then
        Map<LottoRank, Integer> result = Map.of(
                LottoRank.FIRST, 1,
                LottoRank.MISS, 1
        );

        assertThat(lottoWinningResults.getLottoRankResults())
                .isEqualTo(result);
    }

}