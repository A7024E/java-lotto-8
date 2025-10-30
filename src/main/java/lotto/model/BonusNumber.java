package lotto.model;

import lotto.exception.ErrorMessages;

public class BonusNumber {
    private int bonusNumber;

    private BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber of(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    private static void validateBonusNumberRange(int bonusNumber){
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }



}
