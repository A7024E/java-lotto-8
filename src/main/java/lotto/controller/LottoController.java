package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.PurchaseQuantity;
import lotto.model.lottonumberstrategy.LottoNumberStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView;
    OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        PurchaseQuantity purchaseQuantity = tryPurchaseAmount();
        int quantity = purchaseQuantity.calculateQuantity();
        outputView.printQuantity(quantity);

        List<Lotto> lottos = issueLottos(quantity);
        outputView.printLottos(lottos);

    }

    private List<Lotto> issueLottos(int quantity) {
        LottoGenerator lottoGenerator = LottoGenerator.from(new LottoNumberStrategy());
        return lottoGenerator.issueLottos(quantity);
    }

    private PurchaseQuantity tryPurchaseAmount() {
        while (true) {
            try {
                outputView.printPurchaseAmountMessage();
                int inputPurchaseAmount = inputView.inputPurchaseAmount();
                return PurchaseQuantity.from(inputPurchaseAmount);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
