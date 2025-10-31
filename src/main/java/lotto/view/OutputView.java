package lotto.view;

import java.util.Map;
import lotto.model.LottoRank;
import lotto.model.Lottos;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String MESSAGE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String MESSAGE_INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String MESSAGE_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String MESSAGE_WINNING_STATISTICS = "당첨 통계";
    public static final String WINNING_STATISTICS_SEPARATOR_LINE = "---";

    public void printPurchaseAmountMessage() {
        System.out.println(MESSAGE_INPUT_PURCHASE_AMOUNT);
    }

    public void printQuantity(int quantity) {
        String formatingQuantity = OutputFormatter.formatingQuantity(quantity);
        System.out.println(formatingQuantity);
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public void printWinningNumberMessage() {
        System.out.println(LINE_SEPARATOR + MESSAGE_INPUT_WINNING_NUMBERS);
    }

    public void printBonusMessage() {
        System.out.println(LINE_SEPARATOR + MESSAGE_INPUT_BONUS_NUMBER);
    }

    public void printLottoWinningResult(Map<LottoRank, Integer> winningResult) {
        printWinningResultMessage();
        String formatWinningResult = OutputFormatter.formatingWinningResult(winningResult);
        System.out.println(formatWinningResult);
    }

    public void printWinningResultMessage() {
        System.out.println(LINE_SEPARATOR + MESSAGE_WINNING_STATISTICS);
        System.out.println(WINNING_STATISTICS_SEPARATOR_LINE);
    }

    public void printRateOrReturn(double rateOfReturn) {
        String formatRateOfReturn = OutputFormatter.formatingRateOfReturn(rateOfReturn);
        System.out.println(formatRateOfReturn);
    }

    public void printErrorMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}
