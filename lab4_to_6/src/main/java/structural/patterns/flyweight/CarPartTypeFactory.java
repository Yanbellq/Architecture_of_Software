package main.java.structural.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Фабрика пристосуванців - управляє типами автозапчастин
 */
public class CarPartTypeFactory {
    private static final Map<String, CarPartType> partTypes = new HashMap<>();

    /**
     * Отримує тип запчастини (створює якщо не існує)
     */
    public static CarPartType getCarPartType(String name, String brand, String category) {
        String key = brand + "|" + name + "|" + category;

        if (!partTypes.containsKey(key)) {
            partTypes.put(key, new ConcreteCarPartType(name, brand, category));
        }

        return partTypes.get(key);
    }

    /**
     * Отримує кількість створених типів
     */
    public static int getCreatedTypesCount() {
        return partTypes.size();
    }

    /**
     * Показує статистику використання пам'яті
     */
    public static void showMemoryStats() {
        System.out.println("📊 Статистика використання пам'яті:");
        System.out.println("Унікальних типів запчастин створено: " + partTypes.size());
        System.out.println("Економія пам'яті завдяки Flyweight pattern!");
    }
}
