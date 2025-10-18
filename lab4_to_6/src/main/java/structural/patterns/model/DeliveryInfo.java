package main.java.structural.patterns.model;

import java.time.LocalDate;

/**
 * Інформація про доставку замовлення
 */
public class DeliveryInfo {
    private String deliveryType;
    private String address;
    private LocalDate expectedDate;
    private String trackingNumber;

    public DeliveryInfo(String deliveryType, String address, LocalDate expectedDate) {
        this.deliveryType = deliveryType;
        this.address = address;
        this.expectedDate = expectedDate;
    }

    // Getters and Setters
    public String getDeliveryType() { return deliveryType; }
    public String getAddress() { return address; }
    public LocalDate getExpectedDate() { return expectedDate; }
    public String getTrackingNumber() { return trackingNumber; }
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }

    @Override
    public String toString() {
        return String.format("Доставка %s на адресу: %s (очікується: %s)",
                deliveryType, address, expectedDate);
    }
}
