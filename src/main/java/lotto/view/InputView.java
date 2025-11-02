package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.function.Consumer;
import lotto.exception.io.InputValidation;
import lotto.utils.Converter;

public class InputView {

    public int inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        validate(purchaseAmount,InputValidation::validateNumeric);
        return Converter.toInt(purchaseAmount);
    }

    public List<Integer> inputWinningNumber() {
        String winningNumbers = Console.readLine();
        validate(winningNumbers,InputValidation::validateDelimiter);
        return Converter.toIntList(winningNumbers);
    }

    public int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        validate(bonusNumber,InputValidation::validateNumeric);
        return Converter.toInt(bonusNumber);
    }

    private void validate(String input, Consumer<String> extraValidator) {
        InputValidation.validateNullOrEmpty(input);
        InputValidation.validateBlankContains(input);
        extraValidator.accept(input);
    }
}
