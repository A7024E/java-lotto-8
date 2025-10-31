package lotto.model;

import java.util.Objects;
import lotto.exception.ErrorMessages;

public class PurchaseAmount {

    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 100000;

    private final int quantity;

    private PurchaseAmount(int quantity) {
        validate(quantity);
        this.quantity = quantity;
    }

    public static PurchaseAmount from(int quantity) {
        return new PurchaseAmount(quantity);
    }

    public int calculateQuantity() {
        return quantity / LOTTO_PRICE;
    }

    public int getQuantity() {
        return quantity;
    }

    private void validate(int quantity) {
        validateDivideAmount(quantity);
        validateMinimumAmount(quantity);
        validateOverLimitAmount(quantity);

    }

    private static void validateOverLimitAmount(int quantity) {
        if (quantity > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT_OVER_LIMIT.getMessage());
        }
    }

    private static void validateMinimumAmount(int quantity) {
        if (quantity < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT_MINIMUM.getMessage());
        }
    }

    private static void validateDivideAmount(int quantity) {
        if (quantity % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NOT_DIVIDE_PURCHASE_AMOUNT.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurchaseAmount that = (PurchaseAmount) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(quantity);
    }
}
