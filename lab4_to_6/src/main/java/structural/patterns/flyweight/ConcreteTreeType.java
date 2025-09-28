package main.java.structural.patterns.flyweight;

/**
 * Конкретний пристосуванець - конкретний тип дерева
 */
public class ConcreteTreeType implements TreeType {
    private String name;      // внутрішній стан
    private String color;     // внутрішній стан
    private String texture;   // внутрішній стан

    /**
     * Конструктор типу дерева
     * @param name назва дерева
     * @param color колір дерева
     * @param texture текстура дерева
     */
    public ConcreteTreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    @Override
    public void render(int x, int y) {
        System.out.println("Відображається " + name + " дерево з кольором " + color +
                " та текстурою " + texture + " на координатах (" + x + ", " + y + ")");
    }
}
