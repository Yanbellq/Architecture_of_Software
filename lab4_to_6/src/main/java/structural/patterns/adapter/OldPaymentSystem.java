package main.java.structural.patterns.adapter;

/**
 * Застаріла система платежів (несумісна з новим інтерфейсом)
 */
public class OldPaymentSystem {
    /**
     * Обробляє платіж через застарілу систему
     * @param sum сума у копійках
     * @param card номер картки у старому форматі
     * @return код результату (0 - успіх)
     */
    public int makePayment(int sum, String card) {
        System.out.println("Застаріла система: обробка платежу " + (sum / 100.0) + " грн");
        System.out.println("Картка: " + card);

        // Симуляція обробки
        if (card != null && !card.isEmpty() && sum > 0) {
            System.out.println("Застаріла система: платіж успішний");
            return 0; // успіх
        }
        return 1; // помилка
    }
}
