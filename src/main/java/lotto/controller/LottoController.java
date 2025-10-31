package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoWinningCalculator;
import lotto.model.LottoWinningResults;
import lotto.model.Lottos;
import lotto.model.PurchaseQuantity;
import lotto.model.WinningNumbers;
import lotto.model.lottonumberstrategy.LottoNumberStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        PurchaseQuantity purchaseAmount = tryInputPurchaseAmount();
        Lottos lottos = issueLottos(purchaseAmount);
        WinningNumbers winningNumbers = issueWinningNumbers();
        LottoWinningResults winningResult = getWinningResult(lottos, winningNumbers);
        displayWinningResult(winningResult);
        disPlayRateOfReturn(winningResult, purchaseAmount);
    }

    private Lottos issueLottos(PurchaseQuantity purchaseAmount) {
        int quantity = purchaseAmount.calculateQuantity();
        Lottos lottos = issueLottoByQuantity(quantity);
        displayIssuedLottoByQuantity(quantity, lottos);
        return lottos;
    }

    private Lottos issueLottoByQuantity(int quantity) {
        LottoGenerator lottoGenerator = LottoGenerator.from(new LottoNumberStrategy());
        return lottoGenerator.issueLottos(quantity);
    }

    private WinningNumbers issueWinningNumbers() {
        Lotto winningLottoNumbers = tryInputWinningLottoNumbers();
        return tryInputBonusNumber(winningLottoNumbers);
    }

    private LottoWinningResults getWinningResult(Lottos lottos, WinningNumbers winningNumbers) {
        return calculateWinningByLotto(lottos, winningNumbers);
    }

    private LottoWinningResults calculateWinningByLotto(Lottos lottos, WinningNumbers winningNumbers) {
        LottoWinningCalculator winningCalculator = LottoWinningCalculator.create();
        return winningCalculator.calculateWinningResults(lottos, winningNumbers);
    }

    private void disPlayRateOfReturn(LottoWinningResults winningResult, PurchaseQuantity purchaseAmount) {
        double rateOfReturn = winningResult.calculateRateOfReturn(purchaseAmount);
        outputView.printRateOrReturn(rateOfReturn);
    }

    private PurchaseQuantity tryInputPurchaseAmount() {
        while (true) {
            try {
                outputView.printPurchaseAmountMessage();
                int purchaseAmount = inputView.inputPurchaseAmount();
                return PurchaseQuantity.from(purchaseAmount);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private Lotto tryInputWinningLottoNumbers() {
        while (true) {
            try {
                outputView.printWinningNumberMessage();
                List<Integer> winningLottoNumbers = inputView.inputWinningNumber();
                return Lotto.from(winningLottoNumbers);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private WinningNumbers tryInputBonusNumber(Lotto winningLottoNumbers) {
        while (true) {
            try {
                outputView.printBonusMessage();
                int bonusNumber = inputView.inputBonusNumber();
                return WinningNumbers.of(winningLottoNumbers, bonusNumber);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private void displayIssuedLottoByQuantity(int quantity, Lottos lottos) {
        outputView.printQuantity(quantity);
        outputView.printLottos(lottos);
    }

    private void displayWinningResult(LottoWinningResults winningResult) {
        outputView.printLottoWinningResult(winningResult.getLottoRankResults());
    }

}