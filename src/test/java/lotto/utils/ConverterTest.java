package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConverterTest {
    @DisplayName("정수형으로 바꿀수있다")
    @Test
    void stringToInt(){
        // given
        String input = "1";
        // when
        int number = Converter.toInt(input);
        // then
        assertThat(number).isEqualTo(1);
    }
    @DisplayName("Intger를 가지는 리스트를 만든다")
    @Test
    void toIntList(){
        // given
        String input = "1,2,3,4,5,6";
        // when
        List<Integer> numbers = Converter.toIntList(input);
        // then
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }
}