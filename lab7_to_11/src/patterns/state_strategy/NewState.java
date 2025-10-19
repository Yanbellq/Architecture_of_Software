package patterns.state_strategy;

import model.Order;

public class NewState implements OrderState {
    public void next(Order order){ order.setState(new PaidState()); System.out.println("Order оплачено"); }
}