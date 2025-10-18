package main.java.structural.patterns.decorator;

import java.math.BigDecimal;

/**
 * Базовий сервіс обробки замовлень
 */
public class BasicOrderService implements OrderService {
    private BigDecimal baseAmount;

    public BasicOrderService(BigDecimal baseAmount) {
        this.baseAmount = baseAmount;
    }

    @Override
    public BigDecimal processOrder() {
        return baseAmount;
    }

    @Override
    public String getServiceDescription() {
        return "Базове замовлення";
    }
}
