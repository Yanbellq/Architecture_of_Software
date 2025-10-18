package main.java.structural.patterns.bridge;

import main.java.structural.patterns.model.Customer;
import java.math.BigDecimal;

/**
 * Абстракція замовлення з можливістю вибору способу доставки
 */
public abstract class Order {
    protected DeliveryMethod deliveryMethod;
    protected Long orderId;
    protected Customer customer;
    protected BigDecimal totalAmount;

    public Order(Long orderId, Customer customer, BigDecimal totalAmount, DeliveryMethod deliveryMethod) {
        this.orderId = orderId;
        this.customer = customer;
        this.totalAmount = totalAmount;
        this.deliveryMethod = deliveryMethod;
    }

    /**
     * Абстрактний метод обробки замовлення
     */
    public abstract void processOrder();

    /**
     * Загальна логіка підтвердження замовлення
     */
    protected void confirmOrder() {
        System.out.println("Замовлення #" + orderId + " підтверджено для " + customer.getName());
        System.out.println("Загальна сума: " + totalAmount + " грн");
    }
}
