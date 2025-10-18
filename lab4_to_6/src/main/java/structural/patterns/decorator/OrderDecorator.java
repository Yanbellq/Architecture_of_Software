package main.java.structural.patterns.decorator;

import java.math.BigDecimal;

/**
 * Абстрактний декоратор замовлення
 */
public abstract class OrderDecorator implements OrderService {
    protected OrderService orderService;

    public OrderDecorator(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public BigDecimal processOrder() {
        return orderService.processOrder();
    }

    @Override
    public String getServiceDescription() {
        return orderService.getServiceDescription();
    }
}
