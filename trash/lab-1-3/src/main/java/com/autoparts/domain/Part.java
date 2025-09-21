package main.java.com.autoparts.domain;

/**
 * Базовий клас для автозапчастин
 */
public abstract class Part {
    protected String partNumber;
    protected String name;
    protected String brand;
    protected double price;
    protected int stockQuantity;
    protected String category;

    public Part(String partNumber, String name, String brand, double price, int stockQuantity, String category) {
        this.partNumber = partNumber;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }

    public abstract String getPartDescription();

    public void displayPartInfo() {
        System.out.println("Деталь: " + name + " (" + partNumber + ")");
        System.out.println("Бренд: " + brand + ", Ціна: " + price + " грн");
        System.out.println("На складі: " + stockQuantity + " шт.");
    }

    // Геттери та сеттери
    public String getPartNumber() { return partNumber; }
    public void setPartNumber(String partNumber) { this.partNumber = partNumber; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
