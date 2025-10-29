package lotto.model;

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
        if(quantity / 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NOT_DIVIDE_PURCHASE_AMOUNT.getMessage());
        }
        if(quantity < 1000){
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT_MINIMUM.getMessage());
        }
    }
}
