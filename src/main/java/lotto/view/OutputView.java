package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import lotto.model.Lotto;
import lotto.model.LottoRank;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    public void printPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printQuantity(int quantity) {
        System.out.println(LINE_SEPARATOR + quantity + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningNumberMessage() {
        System.out.println(LINE_SEPARATOR + "당첨 번호를 입력해 주세요.");
    }

    public void printBonusMessage() {
        System.out.println(LINE_SEPARATOR + "보너스 번호를 입력해 주세요.");
    }

    public void printWinningResultMessage() {
        System.out.println(LINE_SEPARATOR + "당첨 통계" + LINE_SEPARATOR + "---");
    }

    public void printLottoWinningResult(Map<LottoRank, Integer> winningResult) {
        StringJoiner formatResult = formatWinningResult(winningResult);
        System.out.println(formatResult);
    }

    public void printRateOrReturn(double rateOfReturn) {
        String formatRateOfReturn = String.format("%,.1f", rateOfReturn);
        System.out.println("총 수익률은 " + formatRateOfReturn + "%입니다.");
    }

    private StringJoiner formatWinningResult(Map<LottoRank, Integer> winningResult) {
        StringJoiner sj = new StringJoiner(LINE_SEPARATOR);
        for (LottoRank lottoRank : LottoRank.values()) {
            if (isWinningAmount(lottoRank)) {
                appendWinningResult(winningResult, lottoRank, sj);
            }
        }
        return sj;
    }

    private boolean isWinningAmount(LottoRank lottoRank) {
        return lottoRank.getWinningAmount() > 0L;
    }

    private void appendWinningResult(Map<LottoRank, Integer> winningResult, LottoRank lottoRank, StringJoiner sj) {
        sj.add(lottoRank.getDescription() + " - " + winningResult.getOrDefault(lottoRank, 0) + "개");
    }

    public void printErrorMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}
