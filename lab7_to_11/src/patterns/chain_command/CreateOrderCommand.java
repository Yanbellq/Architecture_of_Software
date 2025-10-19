package patterns.chain_command;

import model.Order;

public class CreateOrderCommand implements Command {
    private Order order;
    public CreateOrderCommand(Order order) { this.order = order; }
    public void execute() { System.out.println("Замовлення створено: " + order.getId()); }
}