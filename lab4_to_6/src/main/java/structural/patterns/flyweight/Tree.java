package main.java.structural.patterns.flyweight;

/**
 * Контекст - конкретне дерево з унікальними координатами
 */
public class Tree {
    private int x, y;           // зовнішній стан
    private TreeType treeType;  // посилання на пристосуванець

    /**
     * Конструктор дерева
     * @param x координата X
     * @param y координата Y
     * @param treeType тип дерева
     */
    public Tree(int x, int y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }

    /**
     * Відображає дерево
     */
    public void render() {
        treeType.render(x, y);
    }
}
