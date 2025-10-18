package main.java.structural.patterns.composite;

import java.math.BigDecimal;

/**
 * Листковий компонент - одиничний товар у замовленні
 */
public class OrderItem extends OrderComponent {
    private String partNumber;
    private BigDecimal unitPrice;
    private Integer quantity;

    public OrderItem(String name, String partNumber, BigDecimal unitPrice, Integer quantity) {
        super(name);
        this.partNumber = partNumber;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    @Override
    public void showDetails(String indent) {
        BigDecimal total = unitPrice.multiply(new BigDecimal(quantity));
        System.out.println(String.format("%s🔧 %s (№%s) - %d шт. × %s грн = %s грн",
                indent, name, partNumber, quantity, unitPrice, total));
    }

    @Override
    public BigDecimal calculateTotal() {
        return unitPrice.multiply(new BigDecimal(quantity));
    }
}
