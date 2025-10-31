package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.exception.ErrorMessages;

public class WinningNumbers {

    private Lotto winningNumbers;
    private BonusNumber bonusNumber;

    private WinningNumbers(Lotto winningNumbers, int bonusNumber) {
        validateDuplicate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = BonusNumber.of(bonusNumber);
    }

    public static WinningNumbers of(Lotto winningLotto, int bonusNumber) {
        return new WinningNumbers(winningLotto, bonusNumber);
    }

    public LottoRank calculateRank(Lotto lotto) {
        int matchCount = winningNumbers.countMatches(lotto);
        boolean bonusMatch = bonusNumber.isMatches(lotto);
        return LottoRank.matchRank(matchCount, bonusMatch);
    }

    private void validateDuplicate(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.isDuplicateBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(winningNumbers, that.winningNumbers) && Objects.equals(bonusNumber,
                that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber);
    }
}
