package main.java.structural.patterns.flyweight;

/**
 * Інтерфейс пристосуванця - тип дерева
 */
public interface TreeType {
    /**
     * Відображає дерево з заданими координатами
     * @param x координата X
     * @param y координата Y
     */
    void render(int x, int y);
}
