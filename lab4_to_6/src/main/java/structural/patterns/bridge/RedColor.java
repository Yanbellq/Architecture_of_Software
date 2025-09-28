package main.java.structural.patterns.bridge;

/**
 * Конкретна реалізація червоного кольору
 */
public class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Застосовується червоний колір");
    }
}
