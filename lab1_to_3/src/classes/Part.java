package classes;

public class Part implements Cloneable {
    private String name;
    private double price;

    public Part(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Part clone() {
        return new Part(this.name, this.price);
    }

    public void info() {
        System.out.println("Запчастина: " + name + " | Ціна: " + price);
    }
}
