package main.java.structural.patterns.bridge;

/**
 * Абстракція - геометрична фігура
 */
public abstract class Shape {
    protected Color color;

    /**
     * Конструктор з кольором
     * @param color колір фігури
     */
    public Shape(Color color) {
        this.color = color;
    }

    /**
     * Абстрактний метод для малювання фігури
     */
    public abstract void draw();
}
