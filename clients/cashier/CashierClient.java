package clients.cashier;

import middle.MiddleFactory;
import middle.Names;
import middle.RemoteMiddleFactory;

import javax.swing.*;

/**
 * The standalone Cashier Client using the BetterCashierModel.
 * @author Your Name
 * @version 1.0
 */
public class CashierClient {
    public static void main(String args[]) {
        String stockURL = args.length < 1 ? Names.STOCK_RW : args[0];
        String orderURL = args.length < 2 ? Names.ORDER : args[1];

        RemoteMiddleFactory mrf = new RemoteMiddleFactory();
        mrf.setStockRWInfo(stockURL);
        mrf.setOrderInfo(orderURL);
        displayGUI(mrf);
    }

    private static void displayGUI(MiddleFactory mf) {
        JFrame window = new JFrame();
        window.setTitle("Better Cashier Client (MVC RMI)");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BetterCashierModel model = new BetterCashierModel(mf);
        CashierView view = new CashierView(window, mf, 0, 0);  // No changes needed in the view
        CashierController cont = new CashierController(model, view);
        view.setController(cont);

        model.addObserver(view);
        window.setVisible(true);
        model.askForUpdate();
    }
}
