package main.java.com.autoparts.creational.builder;

import main.java.com.autoparts.domain.Order;
import main.java.com.autoparts.domain.Part;
import java.time.LocalDateTime;

/**
 * Builder для створення складних замовлень автозапчастин
 */
public class OrderBuilder {
    private Order order;

    public OrderBuilder() {
        this.order = new Order();
        System.out.println("Ініціалізація нового замовлення");
    }

    /**
     * Встановлення номера замовлення
     */
    public OrderBuilder setOrderNumber(String orderNumber) {
        System.out.println("Встановлення номера замовлення: " + orderNumber);
        order.setOrderNumber(orderNumber);
        return this;
    }

    /**
     * Встановлення email клієнта
     */
    public OrderBuilder setCustomerEmail(String customerEmail) {
        System.out.println("Встановлення email клієнта: " + customerEmail);
        order.setCustomerEmail(customerEmail);
        return this;
    }

    /**
     * Додавання товару до замовлення
     */
    public OrderBuilder addPart(Part part, int quantity) {
        System.out.println("Додавання до замовлення: " + part.getName() + " x" + quantity);
        order.addItem(part, quantity);
        return this;
    }

    /**
     * Встановлення адреси доставки
     */
    public OrderBuilder setShippingAddress(String shippingAddress) {
        System.out.println("Встановлення адреси доставки: " + shippingAddress);
        order.setShippingAddress(shippingAddress);
        return this;
    }

    /**
     * Встановлення статусу замовлення
     */
    public OrderBuilder setStatus(String status) {
        System.out.println("Встановлення статусу: " + status);
        order.setStatus(status);
        return this;
    }

    /**
     * Застосування знижки
     */
    public OrderBuilder applyDiscount(double discountPercent) {
        System.out.println("Застосування знижки: " + discountPercent + "%");
        double currentTotal = order.getTotalAmount();
        double discountAmount = currentTotal * (discountPercent / 100);
        // В реальній системі тут була б логіка застосування знижки
        System.out.println("Знижка на суму: " + discountAmount + " грн");
        return this;
    }

    /**
     * Додавання пріоритетної доставки
     */
    public OrderBuilder addExpressDelivery() {
        System.out.println("Додавання експрес-доставки");
        // В реальній системі тут була б логіка розрахунку вартості доставки
        return this;
    }

    /**
     * Додавання страхування замовлення
     */
    public OrderBuilder addInsurance() {
        System.out.println("Додавання страхування замовлення");
        return this;
    }

    /**
     * Фінальне створення замовлення
     */
    public Order build() {
        System.out.println("Замовлення створено успішно!");
        order.calculateTotal();
        return order;
    }
}
