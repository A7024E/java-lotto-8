package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.exception.ErrorMessages;
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
        PurchaseAmount purchaseQuantity = PurchaseAmount.from(value);
        // then
        assertThat(purchaseQuantity).isEqualTo(PurchaseAmount.from(value));
    }

    @DisplayName("구입 금액이 1000원 단위로 나누어 떨어지지 않으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1111", "9999", "1001", "1200"})
    void purchaseQuantityDividedByZero(int amount) {
        // given// when// then
        assertThatThrownBy(() -> PurchaseAmount.from(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액을 계산할수있다")
    @Test
    void amountQuantity() {
        // given
        PurchaseAmount purchaseQuantity = PurchaseAmount.from(2000);
        // when
        int quantity = purchaseQuantity.calculateQuantity();
        // then
        assertThat(quantity).isEqualTo(2);
    }

    @DisplayName("구입 금액이 10만원을 초과할경우 예외가 발생한다")
    @Test
    void purchaseQuantityOverLimit() {
        // when// then
        assertThatThrownBy(() -> PurchaseAmount.from(110000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_PURCHASE_AMOUNT_OVER_LIMIT.getMessage());
    }

    @DisplayName("구입 금액이 10만원을 초과할경우 예외가 발생핮지 않는다")
    @Test
    void purchaseQuantityNotOverLimit() {
        // when// then
        assertThatCode(() -> PurchaseAmount.from(10000))
                .doesNotThrowAnyException();
    }
}