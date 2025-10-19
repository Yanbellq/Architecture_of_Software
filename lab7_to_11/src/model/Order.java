package model;

import patterns.state_strategy.NewState;
import patterns.state_strategy.OrderState;

public class Order {
    private String id;
    private double amount;
    private OrderState state;

    public Order(String id, double amount) {
        this.id = id;
        this.amount = amount;
        this.state = new NewState();
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }
    public void nextState() { state.next(this); }
    public void setState(OrderState s) { this.state = s; }
}
