package clients.cashier;

import catalogue.BetterBasket;
import middle.MiddleFactory;

/**
 * Extends the existing CashierModel class to use BetterBasket instead of Basket.
 * Overrides the makeBasket method to return BetterBasket.
 * @author Your Name
 * @version 1.0
 */
public class BetterCashierModel extends CashierModel {

    public BetterCashierModel(MiddleFactory mf) {
        super(mf);
    }

    /**
     * Overrides the method to return BetterBasket instead of Basket.
     * @return an instance of BetterBasket
     */
    @Override
    protected BetterBasket makeBasket() {
        return new BetterBasket();
    }
}
