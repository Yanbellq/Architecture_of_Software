package main.java.structural.patterns.bridge;

/**
 * Доставка кур'єром
 */
public class CourierDelivery implements DeliveryMethod {
    @Override
    public void arrangeDelivery(String address) {
        System.out.println("🚚 Організовується доставка кур'єром");
        System.out.println("📍 Адреса: " + address);
        System.out.println("⏰ Очікуваний час доставки: завтра до 18:00");
    }
}
