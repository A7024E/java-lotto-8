package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseQuantityTest {
    @DisplayName("PurchaseQuantity 객체를 생성한다")
    @Test
    void generatePurchaseQuantity() {
        // given
        int value = 2000;
        // when
        PurchaseQuantity purchaseQuantity = PurchaseQuantity.from(value);
        // then
        assertThat(purchaseQuantity).isEqualTo(PurchaseQuantity.from(value));

    }

    @DisplayName("구입 금액이 1000원 단위로 나누어 떨어지지 않으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"0","1111","9999","1001","1200"})
    void purchaseQuantityDividedByZero(int amount) {
        // given// when// then
        assertThatThrownBy(()-> PurchaseQuantity.from(amount))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("구입 금액을 계산할수있다")
    @Test
    void amountQuantity(){
        // given
        PurchaseQuantity purchaseQuantity = PurchaseQuantity.from(2000);
        // when
        int quantity = purchaseQuantity.calculateQuantity();
        // then
        assertThat(quantity).isEqualTo(2);
    }
}