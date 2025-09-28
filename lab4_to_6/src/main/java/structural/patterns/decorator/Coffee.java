package main.java.structural.patterns.decorator;

/**
 * Базовий інтерфейс - кава
 */
public interface Coffee {
    /**
     * Отримує опис кави
     * @return опис
     */
    String getDescription();

    /**
     * Отримує вартість кави
     * @return вартість
     */
    double getCost();
}
