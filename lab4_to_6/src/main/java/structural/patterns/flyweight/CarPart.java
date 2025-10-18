package main.java.structural.patterns.flyweight;

import java.math.BigDecimal;

/**
 * Контекст - конкретна автозапчастина з унікальними даними
 */
public class CarPart {
    private final String partNumber;    // зовнішній стан
    private final Integer quantity;     // зовнішній стан
    private final BigDecimal price;     // зовнішній стан
    private final CarPartType type;     // посилання на пристосуванець

    public CarPart(String partNumber, Integer quantity, BigDecimal price, CarPartType type) {
        this.partNumber = partNumber;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    /**
     * Відображає інформацію про запчастину
     */
    public void displayInfo() {
        type.displayInfo(partNumber, quantity, price);
    }

    // Getters
    public String getPartNumber() { return partNumber; }
    public Integer getQuantity() { return quantity; }
    public BigDecimal getPrice() { return price; }
}
