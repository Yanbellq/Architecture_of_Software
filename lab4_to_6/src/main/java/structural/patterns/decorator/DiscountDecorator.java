package main.java.structural.patterns.decorator;

import java.math.BigDecimal;

/**
 * Декоратор знижки
 */
public class DiscountDecorator extends OrderDecorator {
    private BigDecimal discountPercent;

    public DiscountDecorator(OrderService orderService, BigDecimal discountPercent) {
        super(orderService);
        this.discountPercent = discountPercent;
    }

    @Override
    public BigDecimal processOrder() {
        BigDecimal baseAmount = orderService.processOrder();
        BigDecimal discount = baseAmount.multiply(discountPercent).divide(new BigDecimal("100"));
        return baseAmount.subtract(discount);
    }

    @Override
    public String getServiceDescription() {
        return orderService.getServiceDescription() + ", знижка " + discountPercent + "%";
    }
}
