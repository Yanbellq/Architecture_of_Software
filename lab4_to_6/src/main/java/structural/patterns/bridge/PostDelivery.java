package main.java.structural.patterns.bridge;

/**
 * Поштова доставка
 */
public class PostDelivery implements DeliveryMethod {
    @Override
    public void arrangeDelivery(String address) {
        System.out.println("📮 Організовується поштова доставка");
        System.out.println("📍 Адреса: " + address);
        System.out.println("⏰ Очікуваний час доставки: 3-5 робочих днів");
    }
}
