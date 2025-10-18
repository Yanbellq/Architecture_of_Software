package main.java.structural.patterns.flyweight;

import java.math.BigDecimal;

/**
 * Конкретний пристосуванець - конкретний тип автозапчастини
 */
public class ConcreteCarPartType implements CarPartType {
    private final String name;        // внутрішній стан
    private final String brand;       // внутрішній стан
    private final String category;    // внутрішній стан

    public ConcreteCarPartType(String name, String brand, String category) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        System.out.println("Створено новий тип запчастини: " + brand + " " + name);
    }

    @Override
    public void displayInfo(String partNumber, Integer quantity, BigDecimal price) {
        System.out.println(String.format("🔧 %s %s | Категорія: %s | №%s | Кількість: %d | Ціна: %s грн",
                brand, name, category, partNumber, quantity, price));
    }
}
