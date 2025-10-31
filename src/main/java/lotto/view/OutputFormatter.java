package lotto.view;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.LottoRank;

public class OutputFormatter {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %,.1f%%입니다.";
    private static final String PURCHASE_QUANTITY_FORMAT = "%s%d개를 구매했습니다.";
    private static final String RESULT_SEPARATOR = " - ";
    private static final String LOTTO_COUNT_UNIT = "개";
    private static final long NO_REWARD = 0L;

    public static String formatingQuantity(int quantity) {
        return String.format(PURCHASE_QUANTITY_FORMAT, LINE_SEPARATOR, quantity);
    }

    public static String formatingWinningResult(Map<LottoRank, Integer> winningResult) {
        return formatResult(winningResult);
    }

    public static String formatingRateOfReturn(double rateOfReturn) {
        return String.format(RATE_OF_RETURN_FORMAT, rateOfReturn);
    }

    private static String formatResult(Map<LottoRank, Integer> winningResult) {
        return Arrays.stream(LottoRank.values())
                .filter(OutputFormatter::isWinningAmount)
                .map(lottoRank -> createFormat(winningResult, lottoRank))
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    private static boolean isWinningAmount(LottoRank lottoRank) {
        return lottoRank.getWinningAmount() > NO_REWARD;
    }

    private static String createFormat(Map<LottoRank, Integer> winningResult, LottoRank lottoRank) {
        String lottoDescription = lottoRank.getDescription();
        Integer winningCount = winningResult.getOrDefault(lottoRank, 0);

        return lottoDescription + RESULT_SEPARATOR + winningCount + LOTTO_COUNT_UNIT;
    }
}
