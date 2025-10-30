package lotto.model;

import java.util.Map;
import java.util.Map.Entry;

public class LottoWinningResults {
    private final Map<LottoRank,Integer> lottoRankResults;

    private LottoWinningResults(Map<LottoRank, Integer> lottoRankResults) {
        this.lottoRankResults = lottoRankResults;
    }

    public static LottoWinningResults from(Map<LottoRank, Integer> lottoRankResults) {
        return new LottoWinningResults(lottoRankResults);
    }

    public double calculateTotalWinningPrice(int purchaseAmount) {
        long totalWinningPrice = 0;
        for (Entry<LottoRank, Integer> lottoRankIntegerEntry : lottoRankResults.entrySet()) {
            LottoRank rank = lottoRankIntegerEntry.getKey();
            int count = lottoRankIntegerEntry.getValue();
            totalWinningPrice+= rank.getWinningAmount() * count;
        }
        return (double) totalWinningPrice / purchaseAmount * 100;
    }

    public Map<LottoRank, Integer> getLottoRankResults() {
        return lottoRankResults;
    }
}
