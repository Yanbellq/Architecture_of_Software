package patterns.chain_command;

import model.Order;

public class DirectorHandler extends OrderHandler {
    public void handleOrder(Order order) {
        System.out.println("Директор схвалює велике замовлення: " + order.getId());
    }
}
