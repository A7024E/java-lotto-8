package lotto.model.lottonumberstrategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberStrategy implements RandomNumberStrategy {

    @Override
    public List<Integer> generateNumbers() {
        List<Integer> numbers = generateUniqueNumbers();
        return sort(numbers);
    }

    private List<Integer> generateUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private List<Integer> sort(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }


}
