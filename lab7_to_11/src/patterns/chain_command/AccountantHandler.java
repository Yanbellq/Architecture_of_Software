package patterns.chain_command;

import model.Order;

public class AccountantHandler extends OrderHandler {
    public void handleOrder(Order order) {
        if (order.getAmount() < 5000)
            System.out.println("Бухгалтер схвалює замовлення: " + order.getId());
        else if (next != null) next.handleOrder(order);
    }
}
