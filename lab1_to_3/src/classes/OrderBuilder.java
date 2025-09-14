package classes;

public class OrderBuilder {
    private Order order = new Order();

    public OrderBuilder setCustomer(String customer) {
        order.setCustomer(customer);
        return this;
    }

    public OrderBuilder addPart(Part part) {
        order.addPart(part);
        return this;
    }

    public Order build() {
        return order;
    }
}
