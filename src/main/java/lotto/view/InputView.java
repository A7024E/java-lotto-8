package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.io.InputValidation;
import lotto.utils.Converter;

public class InputView {

    public int inputPurchaseAmount(){
        String input = Console.readLine();
        InputValidation.validate(input);
        return Converter.toInt(input);
    }

}
