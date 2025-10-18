package main.java.structural.patterns.bridge;

import main.java.structural.patterns.model.Customer;
import java.math.BigDecimal;

/**
 * Термінове замовлення
 */
public class UrgentOrder extends Order {

    public UrgentOrder(Long orderId, Customer customer, BigDecimal totalAmount, DeliveryMethod deliveryMethod) {
        super(orderId, customer, totalAmount, deliveryMethod);
    }

    @Override
    public void processOrder() {
        System.out.println("--- ОБРОБКА ТЕРМІНОВОГО ЗАМОВЛЕННЯ ---");
        System.out.println("⚡ ПРИОРИТЕТНА ОБРОБКА!");
        confirmOrder();
        System.out.println("⚡ Термінова доставка активована!");
        deliveryMethod.arrangeDelivery(customer.getAddress());
        System.out.println("Термінове замовлення оброблено\n");
    }
}
