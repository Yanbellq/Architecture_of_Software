package main.java.structural.patterns.bridge;

import main.java.structural.patterns.model.Customer;
import java.math.BigDecimal;

/**
 * Звичайне замовлення
 */
public class RegularOrder extends Order {

    public RegularOrder(Long orderId, Customer customer, BigDecimal totalAmount, DeliveryMethod deliveryMethod) {
        super(orderId, customer, totalAmount, deliveryMethod);
    }

    @Override
    public void processOrder() {
        System.out.println("--- ОБРОБКА ЗВИЧАЙНОГО ЗАМОВЛЕННЯ ---");
        confirmOrder();
        deliveryMethod.arrangeDelivery(customer.getAddress());
        System.out.println("Звичайне замовлення оброблено\n");
    }
}
