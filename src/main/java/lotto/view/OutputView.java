package lotto.view;

import java.util.Map;
import lotto.model.LottoRank;
import lotto.model.Lottos;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    public void printPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printQuantity(int quantity) {
        String formatingQuantity = OutputFormatter.formatingQuantity(quantity);
        System.out.println(formatingQuantity);
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public void printWinningNumberMessage() {
        System.out.println(LINE_SEPARATOR + "당첨 번호를 입력해 주세요.");
    }

    public void printBonusMessage() {
        System.out.println(LINE_SEPARATOR + "보너스 번호를 입력해 주세요.");
    }

    public void printLottoWinningResult(Map<LottoRank, Integer> winningResult) {
        printWinningResultMessage(winningResult);
        String formatWinningResult = OutputFormatter.formatingWinningResult(winningResult);
        System.out.println(formatWinningResult);
    }

    public void printWinningResultMessage(Map<LottoRank, Integer> winningResult) {
        System.out.println(LINE_SEPARATOR + "당첨 통계");
        System.out.println("---");
    }

    public void printRateOrReturn(double rateOfReturn) {
        String formatRateOfReturn = OutputFormatter.formatingRateOfReturn(rateOfReturn);
        System.out.println(formatRateOfReturn);
    }


    public void printErrorMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}
