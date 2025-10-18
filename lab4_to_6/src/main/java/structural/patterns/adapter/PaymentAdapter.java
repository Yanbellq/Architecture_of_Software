package main.java.structural.patterns.adapter;

import java.math.BigDecimal;

/**
 * Адаптер для інтеграції застарілої платіжної системи з новою
 */
public class PaymentAdapter implements PaymentGateway {
    private OldPaymentSystem oldSystem;

    public PaymentAdapter(OldPaymentSystem oldSystem) {
        this.oldSystem = oldSystem;
    }

    @Override
    public String processPayment(BigDecimal amount, String cardNumber) {
        System.out.println("Адаптер: конвертація параметрів для застарілої системи");

        // Конвертуємо гривні в копійки
        int amountInKopecks = amount.multiply(new BigDecimal("100")).intValue();

        // Форматуємо номер картки для застарілої системи
        String formattedCard = cardNumber.replaceAll("-", "");

        // Викликаємо застарілу систему
        int result = oldSystem.makePayment(amountInKopecks, formattedCard);

        // Конвертуємо результат у сучасний формат
        if (result == 0) {
            return "УСПІХ: Платіж на суму " + amount + " грн оброблено";
        } else {
            return "ПОМИЛКА: Неможливо обробити платіж";
        }
    }
}
