package patterns.chain_command;

import model.Order;

public abstract class OrderHandler {
    protected OrderHandler next;
    public void setNext(OrderHandler next) { this.next = next; }
    public abstract void handleOrder(Order order);
}