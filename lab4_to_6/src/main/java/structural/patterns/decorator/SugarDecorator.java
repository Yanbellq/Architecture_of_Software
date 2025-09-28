package main.java.structural.patterns.decorator;

/**
 * Конкретний декоратор - цукор
 */
public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", з цукром";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 5.0;
    }
}
