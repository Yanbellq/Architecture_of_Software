package main.java.structural.patterns.model;

/**
 * Модель клієнта інтернет-магазину автозапчастин
 */
public class Customer {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;

    public Customer(Long id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    @Override
    public String toString() {
        return "Клієнт: " + name + " (" + email + ")";
    }
}
