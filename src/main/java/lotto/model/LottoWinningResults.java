package lotto.model;

import java.util.Map;

public class LottoWinningResults {
    private final Map<LottoRank,Integer> lottoRankResults;

    private LottoWinningResults(Map<LottoRank, Integer> lottoRankResults) {
        this.lottoRankResults = lottoRankResults;
    }

    public static LottoWinningResults from(Map<LottoRank, Integer> lottoRankResults) {
        return new LottoWinningResults(lottoRankResults);
    }

    public Map<LottoRank, Integer> getLottoRankResults() {
        return lottoRankResults;
    }
}
