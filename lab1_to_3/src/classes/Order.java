package classes;
import java.util.*;

public class Order {
    private List<Part> parts = new ArrayList<>();
    private String customer;

    public void addPart(Part part) { parts.add(part); }
    public void setCustomer(String customer) { this.customer = customer; }

    public void showOrder() {
        System.out.println("Замовлення для: " + customer);
        for (Part p : parts) p.info();
    }
}

