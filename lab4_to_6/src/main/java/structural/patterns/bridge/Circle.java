package main.java.structural.patterns.bridge;

/**
 * Уточнена абстракція - коло
 */
public class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.print("Малюється коло. ");
        color.applyColor();
    }
}
