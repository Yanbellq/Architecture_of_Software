package main.java.structural.patterns.flyweight;

import java.math.BigDecimal;

/**
 * Інтерфейс пристосуванця - тип автозапчастини
 */
public interface CarPartType {
    /**
     * Відображає інформацію про запчастину з контекстними даними
     * @param partNumber номер запчастини
     * @param quantity кількість на складі
     * @param price ціна
     */
    void displayInfo(String partNumber, Integer quantity, BigDecimal price);
}
