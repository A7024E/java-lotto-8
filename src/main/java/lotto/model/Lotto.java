package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import lotto.exception.ErrorMessages;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicates(numbers);
        validateNumbersRange(numbers);
    }

    private static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_SIZE.getMessage());
        }
    }

    private static void validateDuplicates(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_DUPLICATES.getMessage());
        }
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    public int countMatches(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::isContains)
                .count();
    }

    public boolean isDuplicateBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private boolean isContains(Integer number) {
        return this.numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
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
