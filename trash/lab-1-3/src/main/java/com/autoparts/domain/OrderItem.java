package main.java.com.autoparts.domain;

/**
 * Позиція замовлення
 */
public class OrderItem {
    private Part part;
    private int quantity;

    public OrderItem(Part part, int quantity) {
        this.part = part;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return part.getPrice() * quantity;
    }

    // Геттери та сеттери
    public Part getPart() { return part; }
    public void setPart(Part part) { this.part = part; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
