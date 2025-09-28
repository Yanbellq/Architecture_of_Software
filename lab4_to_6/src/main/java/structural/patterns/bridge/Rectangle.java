package main.java.structural.patterns.bridge;

/**
 * Уточнена абстракція - прямокутник
 */
public class Rectangle extends Shape {
    public Rectangle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.print("Малюється прямокутник. ");
        color.applyColor();
    }
}
