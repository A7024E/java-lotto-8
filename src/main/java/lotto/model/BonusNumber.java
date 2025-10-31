package lotto.model;

import java.util.Objects;
import lotto.exception.ErrorMessages;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber of(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public boolean isMatches(Lotto winningLotto) {
        return winningLotto.isDuplicateBonusNumber(bonusNumber);
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (isRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private static boolean isRange(int bonusNumber) {
        return bonusNumber < 1 || bonusNumber > 45;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BonusNumber that = (BonusNumber) o;
        return bonusNumber == that.bonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bonusNumber);
    }
}
