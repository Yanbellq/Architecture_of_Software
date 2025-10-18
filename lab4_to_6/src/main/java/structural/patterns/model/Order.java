package main.java.structural.patterns.model;

import main.java.structural.patterns.composite.OrderItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;



/**
 * Модель замовлення
 */
public class Order {
    private Long id;
    private Customer customer;
    private List<OrderItem> items;
    private LocalDateTime orderDate;
    private String status;
    private BigDecimal totalAmount;
    private DeliveryInfo deliveryInfo;

    public Order(Long id, Customer customer, LocalDateTime orderDate) {
        this.id = id;
        this.customer = customer;
        this.orderDate = orderDate;
        this.status = "НОВИЙ";
        this.totalAmount = BigDecimal.ZERO;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public Customer getCustomer() { return customer; }
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public DeliveryInfo getDeliveryInfo() { return deliveryInfo; }
    public void setDeliveryInfo(DeliveryInfo deliveryInfo) { this.deliveryInfo = deliveryInfo; }

    @Override
    public String toString() {
        return String.format("Замовлення #%d від %s на суму %s грн (Статус: %s)",
                id, customer.getName(), totalAmount, status);
    }
}
