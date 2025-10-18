package main.java.structural.patterns.composite;

import java.math.BigDecimal;

/**
 * Базовий компонент структури замовлення
 */
public abstract class OrderComponent {
    protected String name;

    public OrderComponent(String name) {
        this.name = name;
    }

    /**
     * Показує деталі компонента
     * @param indent відступ для ієрархії
     */
    public abstract void showDetails(String indent);

    /**
     * Розраховує загальну вартість
     * @return вартість компонента
     */
    public abstract BigDecimal calculateTotal();

    /**
     * Додає дочірній компонент
     */
    public void add(OrderComponent component) {
        throw new UnsupportedOperationException("Операція не підтримується для " + getClass().getSimpleName());
    }

    /**
     * Видаляє дочірній компонент
     */
    public void remove(OrderComponent component) {
        throw new UnsupportedOperationException("Операція не підтримується для " + getClass().getSimpleName());
    }
}
