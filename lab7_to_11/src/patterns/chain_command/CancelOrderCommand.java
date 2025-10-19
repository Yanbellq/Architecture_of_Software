package patterns.chain_command;

import model.Order;

class CancelOrderCommand implements Command {
    private Order order;
    public CancelOrderCommand(Order order) { this.order = order; }
    public void execute() { System.out.println("Замовлення скасовано: " + order.getId()); }
}