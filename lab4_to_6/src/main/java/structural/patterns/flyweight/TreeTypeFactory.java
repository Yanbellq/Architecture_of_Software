package main.java.structural.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Фабрика пристосуванців - управляє екземплярами типів дерев
 */
public class TreeTypeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    /**
     * Отримує тип дерева (створює якщо не існує)
     * @param name назва дерева
     * @param color колір дерева
     * @param texture текстура дерева
     * @return тип дерева
     */
    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + color + texture;

        if (!treeTypes.containsKey(key)) {
            System.out.println("Створюється новий тип дерева: " + name);
            treeTypes.put(key, new ConcreteTreeType(name, color, texture));
        } else {
            System.out.println("Використовується існуючий тип дерева: " + name);
        }

        return treeTypes.get(key);
    }

    /**
     * Отримує кількість створених типів дерев
     * @return кількість типів
     */
    public static int getCreatedTreeTypesCount() {
        return treeTypes.size();
    }
}
