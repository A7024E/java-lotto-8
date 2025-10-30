package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
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
        PurchaseQuantity purchaseQuantity = tryPurchaseAmount();

        LottoGenerator lottoGenerator = LottoGenerator.from(new LottoNumberStrategy());
        int quantity = purchaseQuantity.calculateQuantity();
        List<Lotto> lottos = lottoGenerator.issueLottos(quantity);

        outputView.printQuantity(quantity);
        outputView.printLottos(lottos);

        WinningNumbers winningNumbers = issueWinningNumbers();

        LottoWinningResults winningResult = calculateWinningResults(lottos, winningNumbers);
        outputView.printWinningResultMessage();
        outputView.printLottoWinningResult(winningResult.getLottoRankResults());

        double prize = winningResult.calculateTotalWinningPrice(quantity);
        outputView.printRateOrReturn(prize);
    }

    private LottoWinningResults calculateWinningResults(List<Lotto> lottos, WinningNumbers winningNumbers) {
        LottoWinningCalculator winningCalculator = LottoWinningCalculator.create();
        return winningCalculator.calculateWinningResults(Lottos.from(lottos), winningNumbers);
    }

    private WinningNumbers issueWinningNumbers() {
        Lotto winningLottoNumbers = tryWinningLottoNumbers();
        return tryBonusNumber(winningLottoNumbers);
    }

    private PurchaseQuantity tryPurchaseAmount() {
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

    private Lotto tryWinningLottoNumbers() {
        while (true) {
            try {
                outputView.printWinningNumberMessage();
                List<Integer> winningLottoNumbers = inputView.inputWinningNumber();
                return Lotto.of(winningLottoNumbers);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private WinningNumbers tryBonusNumber(Lotto winningLottoNumbers) {
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
}
