package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    @DisplayName("주어진 수량대로 로또를 발행한다")
    @Test
    void issueLottos() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int quantity = 5;
        LottoGenerator lottoGenerator = LottoGenerator.from(() -> lottoNumbers);
        // when
        List<Lotto> lottos = lottoGenerator.issueLottos(quantity);
        // then
        List<Lotto> compareLottos = List.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 6))
        );

        assertThat(lottos).hasSize(5).isEqualTo(compareLottos);

    }

}