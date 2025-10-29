package lotto.model.lottonumberstrategy;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberStrategyTest {
    @DisplayName("1부터 45까지 랜덤한 숫자를 생성한다")
    @Test
    void generateNumbers(){
        // given
        RandomNumberStrategy randomNumberStrategy = new LottoNumberStrategy();
        // when
        List<Integer> numbers = randomNumberStrategy.generateNumbers();
        // then
        assertThat(numbers).allMatch(number -> number >=1 && number <=45);
    }

}