package lotto.model;

@FunctionalInterface
public interface LottoRankMatcher {
    boolean matchRank(int matchCount, boolean bonus);
}
