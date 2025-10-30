package lotto.model;

import java.util.List;

public enum LottoRank {
    MISS("3개 미만 일치 (0원)", 0L),
    FIFTH("3개 일치 (5,000원)", 5_000L),
    FOURTH("4개 일치 (50,000원)", 50_000L),
    THIRD("5개 일치 (1,500,000원)", 1_500_000L),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000L),
    FIRST("6개 일치 (2,000,000,000원)", 2_000_000_000L);

    private final String description;
    private final long winningAmount;

    LottoRank(String description, long winningAmount) {
        this.description = description;
        this.winningAmount = winningAmount;
    }

    public static LottoRank matchRank(int matchCount, boolean bonus) {
        if(matchCount == 6 && !bonus){
            return FIRST;
        }
        if(matchCount == 5 && bonus){
            return SECOND;
        }
        if(matchCount == 5 && !bonus){
            return THIRD;
        }
        if(matchCount == 4 && !bonus){
            return FOURTH;
        }
        if(matchCount == 3&& !bonus) {
            return FIFTH;
        }
        return MISS;
    }




    public String getDescription() {
        return description;
    }

    public long getWinningAmount() {
        return winningAmount;
    }
}
