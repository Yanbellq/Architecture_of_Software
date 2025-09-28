package main.java.structural.patterns.decorator;

/**
 * Базова реалізація - проста кава
 */
public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Проста кава";
    }

    @Override
    public double getCost() {
        return 25.0;
    }
}
