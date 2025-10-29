package lotto.model;

public class PurchaseQuantity {
    private int quantity;

    private PurchaseQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static PurchaseQuantity from(int quantity) {
        return new PurchaseQuantity(quantity);
    }

}
