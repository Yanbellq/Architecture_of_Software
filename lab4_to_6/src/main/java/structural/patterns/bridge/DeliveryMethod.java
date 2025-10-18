package main.java.structural.patterns.bridge;

/**
 * Інтерфейс способу доставки
 */
public interface DeliveryMethod {
    /**
     * Організовує доставку на вказану адресу
     * @param address адреса доставки
     */
    void arrangeDelivery(String address);
}
