package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import lotto.exception.ErrorMessages;

public class Lotto {

    private final List<Integer> numbers;

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    protected Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicates(numbers);
        validateNumbersRange(numbers);
    }

    public int countMatches(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::isContains)
                .count();
    }

    public boolean isDuplicateBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private static void validateLottoSize(List<Integer> numbers) {
        if (isLottoSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_SIZE.getMessage());
        }
    }

    private static void validateDuplicates(List<Integer> numbers) {
        HashSet<Integer> duplicateNumbers = new HashSet<>(numbers);
        if (isSameSize(numbers, duplicateNumbers)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_DUPLICATES.getMessage());
        }
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(isRange(number)) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    private static boolean isLottoSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBER_COUNT;
    }

    private static boolean isSameSize(List<Integer> numbers, HashSet<Integer> duplicateNumbers) {
        return duplicateNumbers.size() != numbers.size();
    }

    private static boolean isRange(Integer number) {
        return number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER;
    }

    private boolean isContains(Integer number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
      return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }
}
