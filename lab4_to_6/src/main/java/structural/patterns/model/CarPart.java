package main.java.structural.patterns.model;

import java.math.BigDecimal;

/**
 * Модель автозапчастини
 */
public class CarPart {
    private Long id;
    private String name;
    private String brand;
    private String carModel;
    private String partNumber;
    private BigDecimal price;
    private Integer quantity;

    public CarPart(Long id, String name, String brand, String carModel,
                   String partNumber, BigDecimal price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.carModel = carModel;
        this.partNumber = partNumber;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public String getCarModel() { return carModel; }
    public String getPartNumber() { return partNumber; }
    public BigDecimal getPrice() { return price; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return String.format("%s %s для %s (№%s) - %s грн",
                brand, name, carModel, partNumber, price);
    }
}
