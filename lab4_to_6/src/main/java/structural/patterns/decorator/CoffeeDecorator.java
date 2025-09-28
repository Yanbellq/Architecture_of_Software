package main.java.structural.patterns.decorator;

/**
 * Базовий декоратор кави
 */
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    /**
     * Конструктор декоратора
     * @param coffee кава для декорування
     */
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }
}
