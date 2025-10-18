package main.java.structural.patterns.composite;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Композитний компонент - група товарів
 */
public class OrderGroup extends OrderComponent {
    private List<OrderComponent> components = new ArrayList<>();

    public OrderGroup(String name) {
        super(name);
    }

    @Override
    public void add(OrderComponent component) {
        components.add(component);
    }

    @Override
    public void remove(OrderComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "📦 " + name + " (Загальна вартість: " + calculateTotal() + " грн)");
        for (OrderComponent component : components) {
            component.showDetails(indent + "  ");
        }
    }

    @Override
    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderComponent component : components) {
            total = total.add(component.calculateTotal());
        }
        return total;
    }
}
