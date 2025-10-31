package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

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

    @Override
    public String toString() {
        StringJoiner lottoLines = new StringJoiner("\n");
        for (Lotto lotto : lottos) {
            lottoLines.add(lotto.toString());
        }
        return lottoLines.toString();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
