package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lottonumberstrategy.RandomNumberStrategy;

public class LottoGenerator {
    private final RandomNumberStrategy randomNumberStrategy;

    private LottoGenerator(RandomNumberStrategy randomNumberStrategy) {
        this.randomNumberStrategy = randomNumberStrategy;
    }

    public static LottoGenerator from(RandomNumberStrategy randomNumberStrategy) {
        return new LottoGenerator(randomNumberStrategy);
    }

    public List<Lotto> issueLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(issue());
        }
        return lottos;
    }

    private Lotto issue() {
        List<Integer> numbers = randomNumberStrategy.generateNumbers();
        return new Lotto(numbers);
    }

}
