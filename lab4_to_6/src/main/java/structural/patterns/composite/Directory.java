package main.java.structural.patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Композитний компонент - директорія
 */
public class Directory extends FileComponent {
    private List<FileComponent> children = new ArrayList<>();

    /**
     * Конструктор директорії
     * @param name ім'я директорії
     */
    public Directory(String name) {
        super(name);
    }

    @Override
    public void add(FileComponent component) {
        children.add(component);
    }

    @Override
    public void remove(FileComponent component) {
        children.remove(component);
    }

    @Override
    public void showInfo(String indent) {
        System.out.println(indent + "📁 Директорія: " + name);
        for (FileComponent child : children) {
            child.showInfo(indent + "  ");
        }
    }

    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileComponent child : children) {
            totalSize += child.getSize();
        }
        return totalSize;
    }
}
