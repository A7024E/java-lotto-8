package lotto.view;

import java.util.List;
import lotto.model.Lotto;

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
        System.out.println(LINE_SEPARATOR);
    }

    public void printWinningNumberMessage(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printErrorMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}
