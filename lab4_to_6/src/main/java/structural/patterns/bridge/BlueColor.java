package main.java.structural.patterns.bridge;

/**
 * Конкретна реалізація синього кольору
 */
public class BlueColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Застосовується синій колір");
    }
}
