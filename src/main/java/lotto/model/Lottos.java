package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public Map<LottoRank,Integer> calculateResults(WinningNumbers winningNumbers) {
        Map<LottoRank,Integer> lottoRanks = new EnumMap<>(LottoRank.class);
        for (Lotto lotto : lottos) {
            LottoRank LottoRank = winningNumbers.calculateRank(lotto);
            lottoRanks.put(LottoRank,lottoRanks.getOrDefault(LottoRank,0) + 1);
        }
        return lottoRanks;
    }
}
