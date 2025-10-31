package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningResultsTest {
    @DisplayName("총 수익률을 계산한다")
    @Test
    void calculateWinningPrize() {
        // given
        Map<LottoRank, Integer> lottoRank = new EnumMap<>(LottoRank.class);
        lottoRank.put(LottoRank.FIFTH, 1);
        LottoWinningResults results = LottoWinningResults.from(lottoRank);
        PurchaseAmount quantity = PurchaseAmount.from(8000);
        // when
        double prize = results.calculateRateOfReturn(quantity);
        // then
        assertThat(prize).isEqualTo(62.5);
    }
}