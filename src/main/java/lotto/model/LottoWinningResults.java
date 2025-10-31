package lotto.model;

import java.util.Map;
import java.util.Map.Entry;

public class LottoWinningResults {

    private final Map<LottoRank, Integer> lottoRankResults;

    private LottoWinningResults(Map<LottoRank, Integer> lottoRankResults) {
        this.lottoRankResults = lottoRankResults;
    }

    public static LottoWinningResults from(Map<LottoRank, Integer> lottoRankResults) {
        return new LottoWinningResults(lottoRankResults);
    }

    public double calculateRateOfReturn(PurchaseAmount purchaseAmount) {
        long proceeds = calculateTotalWinningPrice();
        int investmentAmount = purchaseAmount.getQuantity();
        return calculatePercentage(proceeds, investmentAmount);
    }

    private long calculateTotalWinningPrice() {
        return lottoRankResults.entrySet().stream().mapToLong((this::sumWinningAmount)).sum();
    }

    private long sumWinningAmount(Entry<LottoRank, Integer> rank) {
        return rank.getKey().getWinningAmount() * rank.getValue();
    }

    private double calculatePercentage(long proceeds, int investmentAmount) {
        return (double) proceeds / investmentAmount * 100.0;
    }

    public Map<LottoRank, Integer> getLottoRankResults() {
        return Map.copyOf(lottoRankResults);
    }
}
