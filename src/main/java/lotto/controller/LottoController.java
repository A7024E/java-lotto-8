package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView;
    OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run(){
        while (true){
            try {
                outputView.printPurchaseAmountMessage();
                inputView.inputPurchaseAmount();
            }catch (IllegalArgumentException exception){
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
