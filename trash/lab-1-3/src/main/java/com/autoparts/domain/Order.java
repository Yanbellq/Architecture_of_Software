package main.java.com.autoparts.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас замовлення в інтернет-магазині
 */
public class Order {
    private String orderNumber;
    private String customerEmail;
    private LocalDateTime orderDate;
    private List<OrderItem> items;
    private double totalAmount;
    private String status;
    private String shippingAddress;

    public Order() {
        this.items = new ArrayList<>();
        this.orderDate = LocalDateTime.now();
        this.status = "NEW";
    }

    public void addItem(Part part, int quantity) {
        System.out.println("Додавання до замовлення: " + part.getName() + " x" + quantity);
        OrderItem item = new OrderItem(part, quantity);
        items.add(item);
        calculateTotal();
    }

    public void calculateTotal() {
        totalAmount = items.stream()
                .mapToDouble(item -> item.getPart().getPrice() * item.getQuantity())
                .sum();
        System.out.println("Загальна сума замовлення: " + totalAmount + " грн");
    }

    public void displayOrderInfo() {
        System.out.println("=== Замовлення " + orderNumber + " ===");
        System.out.println("Клієнт: " + customerEmail);
        System.out.println("Дата: " + orderDate);
        System.out.println("Статус: " + status);
        System.out.println("Товари:");
        for (OrderItem item : items) {
            System.out.println("  - " + item.getPart().getName() + " x" + item.getQuantity() +
                    " = " + (item.getPart().getPrice() * item.getQuantity()) + " грн");
        }
        System.out.println("Загальна сума: " + totalAmount + " грн");
    }

    // Геттери та сеттери
    public String getOrderNumber() { return orderNumber; }
    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public List<OrderItem> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }
}
