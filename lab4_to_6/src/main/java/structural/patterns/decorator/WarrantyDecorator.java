package main.java.structural.patterns.decorator;

import java.math.BigDecimal;

/**
 * Декоратор розширеної гарантії
 */
public class WarrantyDecorator extends OrderDecorator {
    private static final BigDecimal WARRANTY_COST = new BigDecimal("150");

    public WarrantyDecorator(OrderService orderService) {
        super(orderService);
    }

    @Override
    public BigDecimal processOrder() {
        return orderService.processOrder().add(WARRANTY_COST);
    }

    @Override
    public String getServiceDescription() {
        return orderService.getServiceDescription() + ", розширена гарантія (+150 грн)";
    }
}
