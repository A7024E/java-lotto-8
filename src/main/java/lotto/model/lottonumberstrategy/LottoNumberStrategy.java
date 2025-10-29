package lotto.model.lottonumberstrategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberStrategy implements RandomNumberStrategy {

    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
