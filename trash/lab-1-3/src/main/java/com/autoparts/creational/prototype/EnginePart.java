package main.java.com.autoparts.creational.prototype;

import main.java.com.autoparts.domain.Part;

/**
 * Конкретний прототип - деталь двигуна
 */
public class EnginePart extends Part implements CloneablePart {
    private String engineType;
    private String compatibility;

    public EnginePart(String partNumber, String name, String brand, double price,
                      int stockQuantity, String engineType, String compatibility) {
        super(partNumber, name, brand, price, stockQuantity, "ENGINE");
        this.engineType = engineType;
        this.compatibility = compatibility;
    }

    @Override
    public EnginePart clone() {
        System.out.println("Клонування деталі двигуна: " + this.name);
        return new EnginePart(this.partNumber, this.name, this.brand, this.price,
                this.stockQuantity, this.engineType, this.compatibility);
    }

    @Override
    public String getPartDescription() {
        return "Деталь двигуна: " + name + " для " + engineType + ", сумісність: " + compatibility;
    }

    @Override
    public void displayPartInfo() {
        super.displayPartInfo();
        System.out.println("Тип двигуна: " + engineType);
        System.out.println("Сумісність: " + compatibility);
    }

    // Геттери та сеттери
    public String getEngineType() { return engineType; }
    public void setEngineType(String engineType) { this.engineType = engineType; }
    public String getCompatibility() { return compatibility; }
    public void setCompatibility(String compatibility) { this.compatibility = compatibility; }
}
