package main.java.structural.patterns.decorator;

import java.math.BigDecimal;

/**
 * Декоратор експрес-доставки
 */
public class ExpressDeliveryDecorator extends OrderDecorator {
    private static final BigDecimal EXPRESS_COST = new BigDecimal("200");

    public ExpressDeliveryDecorator(OrderService orderService) {
        super(orderService);
    }

    @Override
    public BigDecimal processOrder() {
        return orderService.processOrder().add(EXPRESS_COST);
    }

    @Override
    public String getServiceDescription() {
        return orderService.getServiceDescription() + ", експрес-доставка (+200 грн)";
    }
}
