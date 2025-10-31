package lotto.view;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.LottoRank;

public class OutputFormatter {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String RATE_OF_RETURN_FORMAT = "%,.1f";
    private static final long MISS = 0L;

    public static String formatingQuantity(int quantity) {
        return String.format("%s%d개를 구매했습니다.", LINE_SEPARATOR, quantity);
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
        return lottoRank.getWinningAmount() > MISS;
    }

    private static String createFormat(Map<LottoRank, Integer> winningResult, LottoRank lottoRank) {
        String lottoDescription = lottoRank.getDescription();
        Integer winningCount = winningResult.getOrDefault(lottoRank, 0);

        return lottoDescription + " - " + winningCount + "개";
    }
}
