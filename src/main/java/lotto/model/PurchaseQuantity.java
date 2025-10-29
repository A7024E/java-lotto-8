package lotto.model;

import java.util.Objects;
import lotto.exception.ErrorMessages;

public class PurchaseQuantity {
    private int quantity;

    private PurchaseQuantity(int quantity) {
        validate(quantity);
        this.quantity = quantity;
    }

    public static PurchaseQuantity from(int quantity) {
        return new PurchaseQuantity(quantity);
    }

    public int calculateQuantity() {
        return quantity / 1000;
    }

    private void validate(int quantity) {
        if(quantity % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NOT_DIVIDE_PURCHASE_AMOUNT.getMessage());
        }
        if(quantity < 1000){
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT_MINIMUM.getMessage());
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
        PurchaseQuantity that = (PurchaseQuantity) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(quantity);
    }
}
