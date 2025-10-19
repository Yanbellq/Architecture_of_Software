package patterns.chain_command;

import model.Order;

public class ManagerHandler extends OrderHandler {
    public void handleOrder(Order order) {
        if (order.getAmount() < 1000)
            System.out.println("Менеджер схвалює замовлення: " + order.getId());
        else if (next != null) next.handleOrder(order);
    }
}