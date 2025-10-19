package patterns.state_strategy;

import model.Order;

class PaidState implements OrderState {
    public void next(Order order){ order.setState(new ShippedState()); System.out.println("Order відправлено"); }
}