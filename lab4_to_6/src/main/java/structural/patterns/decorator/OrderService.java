package main.java.structural.patterns.decorator;

import java.math.BigDecimal;

/**
 * Базовий інтерфейс сервісу замовлень
 */
public interface OrderService {
    /**
     * Обробляє замовлення та повертає загальну вартість
     * @return загальна вартість замовлення
     */
    BigDecimal processOrder();

    /**
     * Отримує опис послуг замовлення
     * @return опис послуг
     */
    String getServiceDescription();
}
