package main.java.structural.patterns.adapter;

import java.math.BigDecimal;

/**
 * Сучасний інтерфейс платіжного шлюзу
 */
public interface PaymentGateway {
    /**
     * Обробляє платіж через сучасну систему
     * @param amount сума платежу
     * @param cardNumber номер картки
     * @return результат транзакції
     */
    String processPayment(BigDecimal amount, String cardNumber);
}
