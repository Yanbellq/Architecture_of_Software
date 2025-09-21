package main.java.com.autoparts.creational.prototype;
import main.java.com.autoparts.domain.Part;

/**
 * Конкретний прототип - гальмівна деталь
 */
public class BrakePart extends Part implements CloneablePart {
    private String brakeSystem;
    private String vehicleModel;

    public BrakePart(String partNumber, String name, String brand, double price,
                     int stockQuantity, String brakeSystem, String vehicleModel) {
        super(partNumber, name, brand, price, stockQuantity, "BRAKE");
        this.brakeSystem = brakeSystem;
        this.vehicleModel = vehicleModel;
    }

    @Override
    public BrakePart clone() {
        System.out.println("Клонування гальмівної деталі: " + this.name);
        return new BrakePart(this.partNumber, this.name, this.brand, this.price,
                this.stockQuantity, this.brakeSystem, this.vehicleModel);
    }

    @Override
    public String getPartDescription() {
        return "Гальмівна деталь: " + name + " для " + brakeSystem + ", модель: " + vehicleModel;
    }

    @Override
    public void displayPartInfo() {
        super.displayPartInfo();
        System.out.println("Гальмівна система: " + brakeSystem);
        System.out.println("Модель авто: " + vehicleModel);
    }

    // Геттери та сеттери
    public String getBrakeSystem() { return brakeSystem; }
    public void setBrakeSystem(String brakeSystem) { this.brakeSystem = brakeSystem; }
    public String getVehicleModel() { return vehicleModel; }
    public void setVehicleModel(String vehicleModel) { this.vehicleModel = vehicleModel; }
}
