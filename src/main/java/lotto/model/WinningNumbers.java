package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.exception.ErrorMessages;

public class WinningNumbers {
    private List<Integer> winningNumbers;
    private BonusNumber bonusNumber;

    private WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers,bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = BonusNumber.of(bonusNumber);
    }

    public static WinningNumbers from(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public void validateWinningNumbers(List<Integer> winningNumbers,int bonusNumber) {
        if(isDuplicateBonusNumber(winningNumbers, bonusNumber)){
            throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    public static boolean isDuplicateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        return winningNumbers.contains(bonusNumber);
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
