package lotto.model;

import java.util.Arrays;

public enum LottoRank {

    MISS("3개 미만 일치 (0원)", 0L, (matchCount, bonus) -> matchCount < 3 && !bonus),
    FIFTH("3개 일치 (5,000원)", 5_000L, (matchCount, bonus) -> matchCount == 3 && !bonus),
    FOURTH("4개 일치 (50,000원)", 50_000L, (matchCount, bonus) -> matchCount == 4 && !bonus),
    THIRD("5개 일치 (1,500,000원)", 1_500_000L, (matchCount, bonus) -> matchCount == 5 && !bonus),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000L, (matchCount, bonus) -> matchCount == 5 && bonus),
    FIRST("6개 일치 (2,000,000,000원)", 2_000_000_000L, (matchCount, bonus) -> matchCount == 6 && !bonus);

    private final String description;
    private final long winningAmount;
    private final LottoRankMatcher lottoRankMatcher;

    LottoRank(String description, long winningAmount, LottoRankMatcher lottoRankMatcher) {
        this.description = description;
        this.winningAmount = winningAmount;
        this.lottoRankMatcher = lottoRankMatcher;
    }

    public static LottoRank matchRank(int matchCount, boolean bonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> isMatching(matchCount, bonus, lottoRank))
                .findFirst()
                .orElse(MISS);
    }

    private static boolean isMatching(int matchCount, boolean bonus, LottoRank lottoRank) {
        return extractMatcher(lottoRank).matchRank(matchCount, bonus);
    }

    private static LottoRankMatcher extractMatcher(LottoRank lottoRank) {
        return lottoRank.lottoRankMatcher;
    }

    public String getDescription() {
        return description;
    }

    public long getWinningAmount() {
        return winningAmount;
    }
}
