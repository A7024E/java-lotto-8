package lotto.model;

import java.util.Map;

public class LottoWinningCalculator {

    private LottoWinningCalculator() {
    }

    public static LottoWinningCalculator create() {
        return new LottoWinningCalculator();
    }

    public LottoWinningResults calculateWinningResults(Lottos lottos, WinningNumbers winningNumbers) {
        Map<LottoRank, Integer> lottoResults = lottos.calculateResults(winningNumbers);
        return LottoWinningResults.from(lottoResults);
    }
}