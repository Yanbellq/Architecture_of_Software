package patterns.state_strategy;

import model.Order;

public interface OrderState { void next(Order order); }