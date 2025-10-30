package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.exception.io.InputValidation;
import lotto.utils.Converter;

public class InputView {

    public int inputPurchaseAmount(){
        String input = Console.readLine();
        InputValidation.validateNullOrEmpty(input);
        InputValidation.validateBlankContains(input);
        InputValidation.validateNumeric(input);
        return Converter.toInt(input);
    }

    public List<Integer> inputWinningNumber(){
        String input = Console.readLine();
        String[] inputs = input.split(",");
        InputValidation.validateNullOrEmpty(input);
        InputValidation.validateBlankContains(input);
        InputValidation.validateDelimiter(input);
        return Converter.toIntList(inputs);
    }

    public int inputBonusNumber(){
        String input = Console.readLine();
        InputValidation.validateNullOrEmpty(input);
        InputValidation.validateBlankContains(input);
        InputValidation.validateNumeric(input);
        return Converter.toInt(input);
    }


}
