package patterns.state_strategy;

import model.Order;

class ShippedState implements OrderState {
    public void next(Order order){ System.out.println("Order завершено"); }
}